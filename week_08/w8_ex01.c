#include <stdio.h>
#include <pthread.h>

void *printNums(void *n);

int main() {
    pthread_t t1;

    int n;
    printf("Enter n: ");
    scanf("%d", &n);
    
    pthread_create(&t1, NULL, printNums, &n);
    pthread_join(t1, NULL);
    return 0;
}
void *printNums(void *n) {
    int val = *(int*)n;
    for (int i = 1; i <= val; i++) {
        printf("%d ", i);
    } printf("\n");
}
