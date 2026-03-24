#include <stdio.h>
#include <stdlib.h>

void getInput(int *arr, int *size) {
    printf("Nhap cac phan tu mang:\n");
    for (int i = 0; i < *size; i++) {
        scanf("%d", arr);
        arr++;
    }
}
void findMinMax(int *arr, int size, int *min, int *max) {
    for (int i = 0; i < size; i++) {
        if (*arr > *max) *max = *arr;
        if (*arr < *min) *min = *arr;
        arr++;
    }
}
int main() {
    int n;
    printf("Nhap kich thuoc mang: ");
    scanf("%d", &n);

    int *arr = (int*) malloc(n * sizeof(int));
    getInput(arr, &n);
    int min = *arr, max = *arr;
    findMinMax(arr, n, &min, &max);
    printf("Max: %d, Min: %d\n", max, min);
    free(arr);
    return 0;
}
