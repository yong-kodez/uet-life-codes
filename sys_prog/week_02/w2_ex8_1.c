#include <stdio.h>

int main() {
    char c;
    printf("Nhap vao mot ki tu: ");
    scanf("%c", &c);
    if (65 <= c && c <= 90) {
        printf("Chu cai ban dau: %c\n", c);
        c = c + ' ';
        printf("Chu cai luc sau: %c\n", c);
    } else if (97 <= c && c <= 122) {
        printf("Chu cai ban dau: %c\n", c);
        c = c - ' ';
        printf("Chu cai luc sau: %c\n", c);
    } else 
        printf("Khong phai chu cai\n");
    return 0;
}
