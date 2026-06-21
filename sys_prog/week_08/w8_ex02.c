#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

void *calSum(void *arg) {
    int n = *(int*)arg;
    int *sum = calloc(1, sizeof(int));
    *sum = (n*(n+1))/2;
    free(arg);
    return (void*)sum;
}

int main() {
    int *n = calloc(1, sizeof(int));
    printf("Enter n: ");
    scanf("%d", n);

    pthread_t t;
    pthread_create(&t, NULL, calSum, (void*)n);

    void *sum = NULL;
    pthread_join(t, &sum);

    int rs = *(int*)sum;
    printf("Sum: %d\n", rs);
    free(sum);
    return 0;
}
