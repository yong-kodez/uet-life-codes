#include <stdio.h>
#include <pthread.h>

void *printNums(int n);

int main() {
    pthread_t t1;
    int n;
    printf("Enter n: ");
    scanf("%d", &n);
    pthread_create(&t1, NULL, printNums(n), NULL);
    pthread_join(t1, NULL);
    return 0;
}
void *printNums(int n) {
    for (int i = 1; i <= n; i++) {
        printf("%d ", i);
    } printf("\n");
}
