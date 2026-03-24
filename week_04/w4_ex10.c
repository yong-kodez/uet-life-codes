#include <stdio.h>
#include <stdlib.h>

int main() {
    int i, m, n, *arr;
    printf("Init size: ");
    scanf("%d", &n);
    arr = (int*)malloc(n*sizeof(int));
    if (arr == NULL) {
        printf("MEMORY ERROR");
        return 1;
    }
    printf("Array elems: ");
    for (i = 0; i < n; i++) 
        scanf("%d", arr+i);
    
    printf("Add size: ");
    scanf("%d", &m);
    arr = (int*)realloc(arr, (m+n)*sizeof(int));
    printf("Add elems: ");
    for (i = 0; i < m; i++)
        scanf("%d", arr+n+i);

    printf("New array:");
    for (i = 0; i < (m+n); i++) 
        printf(" %d", *(arr+i));
    free(arr);
    return 0;
}
