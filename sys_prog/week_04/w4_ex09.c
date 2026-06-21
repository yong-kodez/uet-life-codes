#include <stdio.h>
#include <stdlib.h>

int binarySearch(int *arr, int left, int right, int target) {
    int mid;
    while (left <= right) {
        mid = (left + right) / 2;
        if (*(arr+mid) == target) return mid;
        else if (*(arr+mid) > target) right = mid - 1;
        else left = mid + 1;
    }
    return -1;
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
