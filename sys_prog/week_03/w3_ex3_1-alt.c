#include <stdio.h>

void transpose(int row, int col, int arr[10][10]) {
    for (int i = 0; i < col; i++) {
        for (int j = 0; j < row; j++) {
            printf("%d\t", arr[j][i]);
        }
        printf("\n");
    }
}
int main() {
    int m,n;
    printf("Nhap kich thuoc ma tran (m x n): ");
    scanf("%d %d", &m, &n);
    int matrix[10][10] = {0};
    printf("Nhap cac phan tu cua ma tran %dx%d:\n",m,n);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    printf("Ma tran luc sau (%dx%d) la:\n", n, m);
    transpose(m, n, matrix);
    return 0;
}
