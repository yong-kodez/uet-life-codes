#include <stdio.h>

union data {
    int i;
    float f;
};
int main() {
    int cmd;
    union data pack;
    // Kich thuoc union dua tren kieu du lieu co kich thuoc lon nhat
    printf("Kich thuoc union: %zu\n", sizeof(union data));
    while (1) {
        printf("\n--- MENU ---\n");
        printf("1. So nguyen (int)\n");
        printf("2. So thuc (float)\n");
        printf("0. Thoat chuong trinh\n");
        printf("-> Lua chon kieu du lieu nhap: ");
        scanf("%d", &cmd);
        switch (cmd) {
            case 1: 
                printf("- Nhap gia tri nguyen: ");
                scanf("%d", &pack.i);
                printf("+ Gia tri da nhap: %d\n", pack.i);
                break;
            case 2:
                printf("- Nhap gia tri thuc: ");
                scanf("%f", &pack.f);
                printf("+ Gia tri da nhap: %.3f\n", pack.f);
                break;
            case 0: printf("*** Thoat chuong trinh...***\n"); return 0;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }
    }
    return 0;
}
