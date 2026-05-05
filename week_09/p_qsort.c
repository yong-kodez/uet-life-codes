#include <stdio.h>
#include <pthread.h>

void swap(int *a, int *b);
int partition(int *arr, int low, int high);
void quicksort(int *arr, int low, int high);
void *p_qsort(void *arg);

int main() {
    
}
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
int partition(int *arr, int low, int high) {

}
void quicksort(int *arr, int low, int high) {

}
