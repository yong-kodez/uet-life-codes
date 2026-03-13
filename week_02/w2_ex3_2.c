#include <stdio.h>

int main() {
    int element, n, sum = 0;
    do {
        printf("Nhap so nguyen duong N: ");
        scanf("%d",&n);
    } while (n <=0);
    printf("Nhap day so (%d so): ", n);
    for (int i = 0; i<n-1; i++) {
        scanf("%d", &element);
        if (element > n) {
            printf("Day co so lon hon %d!\n", n);
            return 0;
        }
        sum += element;
    }
    printf("So con thieu la: %d\n", (n*(n+1))/2 - sum);
    return 0;
}
