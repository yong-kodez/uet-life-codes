#include <stdio.h>

int main() {
    int n, sum;
    printf("Nhap so n: ");
    scanf("%d", &n);
    printf("Cac uoc nguyen duong cua %d la:", n);
    for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            printf(" %d", i);
        }
    }
    return 0;
}
