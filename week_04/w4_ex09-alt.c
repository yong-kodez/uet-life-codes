#include <stdio.h>
#include <stdlib.h>

int binarySearch(int *arr, int left, int right, int target) {
    int mid = (left + right) / 2;
    if (*(arr+mid) == target) return mid;
    if (left > right) return -1;
    if (*(arr+mid) > target) 
        return binarySearch(arr, left, mid - 1, target);
    else return binarySearch(arr, mid + 1, right, target);
}
int main() {
    int n, target, index;
    printf("Array size: ");
    scanf("%d", &n);

    int *arr = (int*)malloc(n*sizeof(int));
    printf("Array elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", arr + i);
    }
    printf("Target: ");
    scanf("%d", &target);

    index = binarySearch(arr, 0, n-1, target); 
    if (index >= 0) printf("Found at index %d\n", index);
    else printf("Not found");

    free(arr);
    return 0;
}
