#include <stdio.h>

int main() {
    int n, steps = 0;
    do {
        printf("Nhap so nguyen duong n: ");
        scanf("%d",&n);
    } while (n<=0);
    printf("Bien doi: %d",n);
    while (n != 1) {
        if (n % 2 == 0) n = n / 2;
        else n = 3*n + 1;
        steps += 1;
        printf(" -> %d", n);
    }
    printf("\nCan %d buoc\n", steps);
    return 0;
}
