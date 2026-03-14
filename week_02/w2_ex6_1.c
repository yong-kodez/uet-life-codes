#include <stdio.h>

int main() {
    float kms, money = 0;
    int tier = 1;
    printf("Nhap so km khach di: ");
    scanf("%f", &kms);
    while (kms > 0) {
        if (tier == 1) {
            if (kms < 1) money = money + kms * 10000;
            else money = money + 1*10000; 
            tier += 1;
            kms -= 1; 
        } else if (tier == 2) {
            if (kms < 4) money = money + kms * 8000;
            else money = money + 4*8000;
            tier += 1;
            kms -= 4;
        } else {
            money = money + kms * 6500;
            kms = 0;
        }
    }
    printf("So tien can tra: %.2f\n", money);
    return 0;
}
