#include <stdio.h>

int main() {
    int n;
    printf("Nhap so n: ");
    scanf("%d", &n);
    if (n % 2 == 0) {
        printf("n = %d la so chan\n", n);
    } else {
        printf("n = %d la so le\n", n);
    }
    return 0;
}
