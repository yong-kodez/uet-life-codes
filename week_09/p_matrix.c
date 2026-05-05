#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

int p, Arows, Acols, Brows, Bcols;
typedef struct {
    int id;
    long s_row;
    long e_row;
} thArg_t;
int **matA, **matB, **matC;

void getMat(int ***mat, int row, int col);
void freeMat(int **mat, int row);
void printMat(int **mat, int row, int col);
void *mult(void *arg);

int main() {
    printf("Enter n threads: ");
    scanf("%d", &p);
    printf("Matrix A size (m x n): ");
    scanf("%d %d", &Arows, &Acols);
    printf("Matrix B size (n x p): ");
    scanf("%d %d", &Brows, &Bcols);

    if (Acols != Brows || p > Arows) {
        printf(" * Cannot multiply!\n");
        return 1;
    } else {
        printf(" - Enter matrix A:\n");
        getMat(&matA, Arows, Acols);
        printf(" - Enter matrix B:\n");
        getMat(&matB, Brows, Bcols);
        matC = calloc(Arows, sizeof(int*));
        for (int i = 0; i < Arows; i++)
            matC[i] = calloc(Bcols, sizeof(int));
    }
    pthread_t t[p];
    thArg_t tArgs[p];
    for (int i = 0; i < p; i++) {
        long id = i;
        tArgs[i].id = id;
        tArgs[i].s_row = id * Arows / p;
        tArgs[i].e_row = (id + 1) * Arows / p;

        pthread_create(&t[i], NULL, mult, &tArgs[i]);
    }
    for (int i = 0; i < p; i++)
        pthread_join(t[i], NULL);
    printf(" -> Matrix C = A x B:\n");
    printMat(matC, Arows, Bcols);

    freeMat(matA, Arows);
    freeMat(matB, Brows);
    freeMat(matC, Arows);
    return 0;
}
void getMat(int ***mat, int row, int col) {
    *mat = calloc(row, sizeof(int*));
    for (int i = 0; i < row; i++) {
        (*mat)[i] = calloc(col, sizeof(int));
        for (int j = 0; j < col; j++) {
            scanf("%d", &((*mat)[i][j]));
        }
    }
}
void freeMat(int **mat, int row) {
    for (int i = 0; i < row; i++)
        free(mat[i]);
    free(mat);
}
void printMat(int **mat, int row, int col) {
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            printf("%d\t", mat[i][j]);
        }
        printf("\n");
    }
}
void *mult(void *arg) {
    thArg_t args = *(thArg_t*)arg;
    int start = args.s_row;
    int end = args.e_row;

    int i, j, k;
    for (i = start; i < end; i++) {
        for (j = 0; j < Bcols; j++) {
            for (k = 0; k < Acols; k++)
                matC[i][j] += matA[i][k] * matB[k][j];
        }
    }
}
