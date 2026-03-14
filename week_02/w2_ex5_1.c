#include <stdio.h>

int main() {
    int a,b,c;
    printf("Nhap 3 so a, b, c: ");
    scanf("%d %d %d", &a, &b, &c);
    if (b > a || c > a) {
        if (b > c) {
            printf("So lon nhat la: %d\n", b);
        } else {
            printf("So lon nhat la: %d\n", c);
        }
    } else {
        printf("So lon nhat la: %d\n", a);
    }
    return 0;
}
