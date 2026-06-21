#include <stdio.h>
#include <stdlib.h>

int main() {
    int i, arr[] = {10, 20, 30, 40, 50};
    int *ptr = arr;
    printf("Cach 1: Chi so mang\n");
    for (i = 0; i < 5; i++) {
        printf("Elem %d: %d (%p)\n", i, ptr[i], &ptr[i]);
    } printf("\n");
    printf("Cach 2: Phep cong con tro\n");
    for (i = 0; i < 5; i++) {
        printf("Elem %d: %d (%p)\n", i, *ptr, ptr);
        ptr++;
    }
    return 0;
}
