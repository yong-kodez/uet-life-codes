#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

int p, Arows, Acols, Brows, Bcols;
typedef struct {
    int **A, **B, **C;
    long s_row;
    long e_row;
} arg_t;

void getMat(int row, int col, int mat[row][col]);
void printMat(int row, int col, int mat[row][col]);
void *mult(void *arg);

int main() {
    printf("Enter n threads: ");
    scanf("%d", &p);
    printf("Matrix A size (m x n): ");
    scanf("%d %d", &Arows, &Acols);
    int matA[Arows][Acols];
    printf("Matrix B size (n x p): ");
    scanf("%d %d", &Brows, &Bcols);
    int matB[Brows][Bcols];
    int matC[Arows][Bcols];

    if (Acols != Brows) {
        printf(" * Cannot multiply!\n");
        return 1;
    }
    printf(" - Enter matrix A:\n");
    getMat(Arows, Acols, matA);
    printf(" - Enter matrix B:\n");
    getMat(Brows, Bcols, matB);

    pthread_t t[p];
    arg_t tArgs[p];
    for (int i = 0; i < p; i++) {
        long id = i;
        tArgs[i].A = matA;
        tArgs[i].B = matB;
        tArgs[i].C = matC;
        tArgs[i].s_row = id * Arows / p;
        tArgs[i].e_row = (id + 1) * Arows / p;

        pthread_create(&t[i], NULL, mult, &tArgs[i]);
    }
    for (int i = 0; i < p; i++)
        pthread_join(t[i], NULL);
    printf(" -> Matrix C = A x B:\n");
    printMat(Arows, Bcols, matC);

    return 0;
}
void getMat(int row, int col, int mat[row][col]) {
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            scanf("%d", &(mat[i][j]));
        }
    }
}
void printMat(int row, int col, int mat[row][col]) {
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            printf("%d\t", mat[i][j]);
        }
        printf("\n");
    }
}
void *mult(void *arg) {
    arg_t args = *(arg_t*)arg;
    int **matA = args.A, **matB = args.B, **matC = args.C;
    int start = args.s_row;
    int end = args.e_row;

    int i, j, k;
    for (i = start; i < end; i++) {
        for (j = 0; j < Bcols; j++) {
            matC[i][j] = 0;
            for (k = 0; k < Acols; k++)
                matC[i][j] += matA[i][k] * matB[k][j];
        }
    }
}
