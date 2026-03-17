#include <stdio.h>

int strlen(char string[]) {
    int wcount = 0;
    char *ptr = string;
    while (*ptr != '\0') {
        wcount += 1;
        ptr += 1;
    }
    return wcount;
}

int main() {
    char s1[100];
    printf("Nhap chuoi s1: ");
    scanf("%s", s1);
    printf("Do dai chuoi: %d\n", strlen(s1));
}
