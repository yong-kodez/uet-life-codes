#include <stdio.h>
#include <stdlib.h>

int main() {
    int arr[] = {10, 20, 30};
    int *ptr = arr;
    printf("%p, %p\n", ptr, ptr+2);
    printf("%d", (ptr+2) - ptr);
}
