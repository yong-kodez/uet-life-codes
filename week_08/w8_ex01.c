#include <stdio.h>
#include <pthread.h>

int n;
void *printNums(void *arg) {
    for (int i = 1; i <= n; i++) {
        printf("%d\n", i);
    }
}

int main() {
    pthread_t t1;

    printf("Enter n: ");
    scanf("%d", &n);

    pthread_create(&t1, NULL, printNums, &n);
    pthread_join(t1, NULL);
    printf("Main thread exiting\n");
    return 0;
}
