#include <stdio.h>
#include <stdlib.h>

int main() {
    int number = 100;
    int *ptr = &number;
    
    printf("Dia chi bien: %p\n", &number);
    printf("Gia tri con tro: %p\n", ptr);
    printf("Gia tri con tro tro toi: %d\n", *ptr);

    *ptr = 200;
    printf("Gia tri sau thay doi: %d", number);
    return 0;
}
