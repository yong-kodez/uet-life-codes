#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

int n;
int sum;
void *calSum(void *arg) {
    sum = (n*(n+1))/2;
}

int main() {
    printf("Enter N: ");
    scanf("%d", &n);

    pthread_t t;
    pthread_create(&t, NULL, calSum, NULL);
    pthread_join(t, NULL);

    printf("Sum (1 to %d): %d\n", n, sum);
    return 0;
}
