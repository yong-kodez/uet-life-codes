#include <stdio.h>
#include <stdlib.h>

int main() {
    int *ptr = (int*) malloc(sizeof(int));
    if (ptr == NULL) {
        printf("Loi tao bo nho");
        return 1;
    }
    scanf("%d",ptr);
    printf("Gia tri da nhap: %d\n", *ptr);
    
    free(ptr);
    ptr = NULL;
    return 0;
}
