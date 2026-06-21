#include <stdio.h>

void check_year(int y) {
    if (y < 0) {
        printf("Nam khong hop le\n");
    } else {
        if ( y % 400 == 0 || 
            (y % 4 == 0 && y % 100 != 0)) {
            printf("Nam %d la nam nhuan\n", y);
        } else {
            printf("Nam %d khong phai nam nhuan\n", y);
        }
    } 
}
int main() {
    int year;
    printf("Nhap nam: ");
    scanf("%d", &year);
    check_year(year);
    return 0;
}
