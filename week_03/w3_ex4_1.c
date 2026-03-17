#include <stdio.h>

void rotate(int n, int arr[10][10]) {
    int temp;
    for (int i = 0; i < n - i - 1; i++) {
        for (int j = i; j < n - i - 1; j++) {
            temp = arr[i][j];
            arr[i][j] = arr[n-j-1][i];
            arr[n-j-1][i] = arr[n-i-1][n-j-1];
            arr[n-i-1][n-j-1] = arr[j][n-i-1];
            arr[j][n-i-1] = temp;
        }
    }
}
int main() {
    int n;
    do {
        printf("Nhap kich thuoc ma tran vuong (n x n): ");
        scanf("%d", &n);
    } while (n <= 0 || n > 10);
    int matrix[10][10] = {0};
    printf("Nhap cac phan tu cua ma tran %dx%d:\n",n,n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
    rotate(n, matrix);
    printf("Ma tran sau khi xoay:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
    return 0;
}
