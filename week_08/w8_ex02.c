#include <stdio.h>
#include <pthread.h>

void *calSum(void *arg);
int sum;

int main() {
    pthread_t t;
    
    int n;
    scanf("%d", &n);
    pthread_create(&t, NULL, calSum, NULL);
    pthread_join(t, NULL);
    printf("%d\n", sum);
    return 0;
}
void *calSum(void *arg) {
    sum = ((n+1)*n)/2;
}
