#include <stdio.h>

int main() {
    int a, b;
    printf("Nhap 2 so a, b: ");
    scanf("%d %d", &a, &b);
    printf("Truoc khi hoan doi: a=%d, b=%d\n", a, b);
    a = a + b;
    b = a - b;
    a = a - b;
    printf("Sau khi hoan doi: a=%d, b=%d\n", a, b);

    return 0;
}
