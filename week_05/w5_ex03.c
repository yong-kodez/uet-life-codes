#include <stdio.h>

typedef struct {
    int id;
    int balance;
} Account;
void deposit(Account *acc, int amount) {
    acc -> balance += amount;
    printf("Gui thanh cong %d\n", amount);
}
void withdraw(Account *acc, int amount) {
    if (acc -> balance < amount) 
        printf("So du khong du!\n");
    else {
        acc -> balance -= amount;
        printf("Rut thanh cong %d\n", amount);
    }
}
int main() {
    int cmd = 0, amount;
    Account account;
    account.balance = 0;
    printf("Nhap id tai khoan: ");
    scanf("%d", &account.id);
    printf("Nhap so du ban dau gui vao: ");
    scanf("%d", &account.balance);
    do {
        printf("\n=== BANK MANAGEMENT ===\n");
        printf("1. Gui tien (deposit)\n");
        printf("2. Rut tien (withdraw)\n");
        printf("3. In ra so tien cua tai khoan\n");
        printf("0. Thoat\n");
        printf("Nhap lenh: ");
        scanf("%d", &cmd);
        if (cmd == 1) {
            printf("So tien gui vao: ");
            scanf("%d", &amount);
            deposit(&account, amount);
        } else if (cmd == 2) {
            printf("So tien can rut: ");
            scanf("%d", &amount);
            withdraw(&account, amount);
        } else if(cmd == 3) {
            printf("So tien trong tai khoan %d: %d\n", account.id, account.balance);
        } else {
            printf("Thoat chuong trinh...\n");
            break;
        }
    } while (cmd != 0);
    return 0;
}
