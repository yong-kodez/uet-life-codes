#include <stdio.h>
#include <stdlib.h>

int sumRows(int *rows, int cols) {
    int sum = 0;
    for (int i = 0; i < cols; i++)
        sum += *(rows + i);
    return sum;
}
int main() {
    int i, row, col, *rowsums, **matrix;
    printf("row x col: ");
    scanf("%d %d", &row, &col);

    matrix = (int**)malloc(row * sizeof(int *));
    for (i = 0; i < row; i++) {
        *(matrix + i) = (int*)malloc(col * sizeof(int));
        printf("Row %d: ", i + 1);
        for (int j = 0; j < col; j++) {
            scanf("%d", *(matrix + i) + j);
        }
    }
    printf("\n---SUMS---\n");
    for (i = 0; i < row; i++) {
        printf("Sum row %d: %d\n", i + 1, sumRows(*(matrix + i), col));
    }
    for (i = 0; i < row; i++) 
        free(*(matrix + i));
    free(matrix);
    return 0;
}
