#include <stdio.h>

int main() {
    int n, mod, digits = 0, evens = 0;
    do {
        printf("Nhap so nguyen duong n: ");
        scanf("%d", &n);
    } while (n<=0);
    do {
        mod = n % 10;
        digits += 1;
        if (mod % 2 == 0) evens += 1;
        n /= 10;
    } while (n != 0);
    printf("So chu so chan la: %d\n", evens);
    printf("So chu so le la: %d\n", digits - evens);
    return 0;
}
