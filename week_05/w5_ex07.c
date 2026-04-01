#include <stdio.h>

struct Node {
    int data;
    struct Node *next;
};
int main() {
    int cmd;
    while (1) {
        printf("\n--- MENU ---\n");
        printf("1. In danh sach\n");
        printf("2. Them mot phan tu\n");
        printf("3. Xoa mot phan tu\n");
        printf("0. Thoat chuong trinh\n");
        printf("-> Lua chon thao tac: ");
        scanf("%d", &cmd);
        switch (cmd) {
            case 1:
            case 2:
            case 3:
            case 0: printf("*** Thoat chuong trinh...***\n"); return 0;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }
    }
    return 0;
}
