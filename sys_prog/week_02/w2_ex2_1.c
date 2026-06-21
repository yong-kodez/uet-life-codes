#include <stdio.h>

int main() {
    int a, b;
    printf("Nhap hai so a, b: ");
    scanf("%d %d", &a, &b);
    if (a > b) {
        printf("a = %d lon hon b = %d\n", a, b);
    } else if (a == b) {
        printf("a, b bang nhau va bang %d\n", a);
    } else {
        printf("b = %d lon hon a = %d\n", b, a);
    }
    return 0;
}
