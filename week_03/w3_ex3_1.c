#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
void transpose(int row, int col, int arr[10][10]) {
    int longer = (row > col) ? row : col;
    int shorter = (row > col) ? col : row;
    for (int i = 0; i < shorter; i++) {
        for (int j = i + 1; j < longer; j++) {
            swap(&arr[i][j], &arr[j][i]);
        }
    }
}
int main() {
    int m,n;
    do { 
        printf("Nhap kich thuoc ma tran (m x n): ");
        scanf("%d %d", &m, &n);
    } while (m < 1 || m > 10 || n > 10 || n < 1);
    int matrix[10][10] = {0};
    printf("Nhap cac phan tu cua ma tran %dx%d:\n",m,n);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
    transpose(m, n, matrix);
    printf("Ma tran chuyen vi (%dx%d) la:\n", n, m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }

    return 0;
}
