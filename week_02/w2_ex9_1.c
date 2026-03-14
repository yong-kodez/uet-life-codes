#include <stdio.h>

int main() {
    int year;
    do {
        printf("Nhập một năm: ");
        scanf("%d", &year);
    } while (year < 0);
    printf("Năm %d là năm ", year);
    switch (year % 12) {
        case 0: 
            printf("Thân");
            break;
        case 1:
            printf("Dậu");
            break;
        case 2:
            printf("Tuất");
            break;
        case 3:
            printf("Hợi");
            break;
        case 4:
            printf("Tý");
            break;
        case 5:
            printf("Sửu");
            break;
        case 6:
            printf("Dần");
            break;
        case 7:
            printf("Mão");
            break;
        case 8:
            printf("Thìn");
            break;
        case 9:
            printf("Tỵ");
            break;
        case 10:
            printf("Ngọ");
            break;
        case 11:
            printf("Mùi");
            break;
    }
    return 0;
} 
