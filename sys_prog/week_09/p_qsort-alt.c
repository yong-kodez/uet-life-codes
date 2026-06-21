#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include "randgen.h"

#define THRESHOLD 5
int n, *arr;
typedef struct {
    int low;
    int high;
    int *arr;
} arg_t;

void swap(int *a, int *b);
int partition(int *arr, int low, int high);
void quicksort(int *arr, int low, int high);
void *p_qsort(void *arg);

int main() {
    arr = (int*)(calloc(10000, sizeof(int)));
    n = 10000;
    // printf("Enter array size: ");
    // scanf("%d", &n);
    // arr = (int*)malloc(n * sizeof(int));

    printf("Elements:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
 
    pthread_t t;
    arg_t data = {0, n-1, arr};
    pthread_create(&t, NULL, p_qsort, &data);
    pthread_join(t, NULL);

    printf("-> Ater sorted:\n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
    free(arr);
}
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
int partition(int *arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i+1], &arr[high]);
    return i + 1;
}
void quicksort(int *arr, int low, int high) {
    if (low < high) {
        int p = partition(arr, low, high);
        quicksort(arr, low, p - 1);
        quicksort(arr, p + 1, high);
    }
}
void *p_qsort(void *arg) {
    arg_t data = *(arg_t*)arg;
    int low = data.low;
    int high = data.high;
    int *arr = data.arr;

    if (low >= high) return NULL;
    if (high - low + 1 <= THRESHOLD) {
        quicksort(arr, low, high);
        return NULL;
    }
    int p = partition(arr, low, high);

    pthread_t newThread;
    arg_t leftData = {low, p-1, arr};
    arg_t rightData = {p+1, high, arr};

    pthread_create(&newThread, NULL, p_qsort, &leftData);
    p_qsort(&rightData);
    pthread_join(newThread, NULL);
    return NULL;
}
