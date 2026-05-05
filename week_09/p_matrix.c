#include <stdio.h>
#include <pthread.h>

int p, Arows, Acols, Brows, Bcols;
typedef struct {
    int id;
    long s_row;
    long e_row;
} arg_t;

int main() {
    printf("Enter n threads: ");
    scanf("%d", &p);
    printf("Matrix A size (m x n): ");
    scanf("%d %d", &Arows, &Acols);
    printf("Matrix B size (n x p): ");
    scanf("%d %d", &Brows, &Bcols);

    if (Acols != Brows) {
        printf(" * Cannot multiply!");
        return 1;
    }
    pthread_t t[p];
    arg_t ThrArgs[p];
    long id;
    for (int i = 0; i < p; i++) {
        id = i;
        ThrArgs[i].id = id;
        ThrArgs[i].s_row = id * 
    }
    
}
