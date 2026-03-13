#include <stdio.h>

int main() {
    double n;
    do {
        printf("Nhap so thuc duong N: ");
        scanf("%lf", &n);
    } while (n <= 0);
    double mid, left = 0, right = (n < 1.0) ? 1.0 : n;
    while (right - left > 0.0001) {
        mid = (right + left) / 2.0;
        if (mid*mid > n) right = mid;
        else left = mid;
    }
    printf("Can bac hai cua %f la: %f\n", n, mid);
    return 0;
}


