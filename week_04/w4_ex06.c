#include <stdio.h>
#include <stdlib.h>

int* findElement(int *arr, int size, int key) {
    for (int i = 0; i < size; i++) {
        if (*(arr+i) == key) return arr+i;
    }
    return NULL;
}
int main() {
    printf("Nhap kich thuoc mang: ");
    int n;
    scanf("%d", &n);

    int *ptr = (int*)malloc(n * sizeof(int));
    printf("Nhap cac phan tu cua mang:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", ptr + i);
    }

    int key;
    printf("Nhap gia tri key can tim: ");
    scanf("%d", &key);
    int* key_ptr = findElement(ptr, n, key);
    if (key_ptr == NULL) 
        printf("Khong tim thay gia tri %d\n", key);
    else
        printf("Found %d at %p\nIndex: %d\n", key, key_ptr, key_ptr - ptr);
    free(ptr);
    return 0;
}
