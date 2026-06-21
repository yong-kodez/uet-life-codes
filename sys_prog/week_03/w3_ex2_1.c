#include <stdio.h>

void swap(int *a, int *b) {
    *a = *a + *b;
    *b = *a - *b;
    *a = *a - *b;
}
void BubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j+1]) swap(&arr[j], &arr[j+1]);
        }
    }
}
int removeDuplicates(int arr[],int n) {
    int i = 0, j = 0;
    for (i; i < n-1; i++) {
        if (arr[i] != arr[i+1]) {
            arr[j++] = arr[i];
        }
    }
    arr[j] = arr[n-1];
    return j+1;
}

int main() {
    int n;
    printf("Nhap n: ");
    scanf("%d", &n);

    int arr[n];
    printf("Nhap %d phan tu cua mang A: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    BubbleSort(arr,n);
    printf("Mang A sau sap xep: ");
    for (int i = 0; i < n; i++) {
        printf(" %d",arr[i]);
    }

    int new_len = removeDuplicates(arr,n);
    printf("\nMang A sau khi loai bo trung lap (%d phan tu): ", n - new_len);
    for (int i = 0; i < new_len; i++) {
        printf("%d ",arr[i]);
    } printf("\n");
    return 0;
}
