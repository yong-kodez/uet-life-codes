#include <stdio.h>

int isPrime(long n) {
    if (n < 2) return 0;
    for (int i = 2; i*i <= n; i++) {
        if (n <= 1 || n % i == 0)
            return 0;
    }
    return 1;
}
int main() {
    int m, n;
    printf("Nhap khoang [m,n]: ");
    scanf("%d %d", &m, &n);
    printf("Cac so nguyen to trong khoang [%d,%d] la:", m, n);

    for (m; m <= n; m++) {
        if (isPrime(m) == 1) printf(" %d", m);
    }
    return 0;
}
