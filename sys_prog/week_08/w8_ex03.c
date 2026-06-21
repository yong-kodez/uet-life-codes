#include <stdio.h>
#include <pthread.h>

void *unique(void *arg) {
    pthread_t id = pthread_self();
    printf("Thread with ID %d is running\n", (int)id);
}
int main() {
    pthread_t t1, t2, t3;
    pthread_create(&t1, NULL, unique, NULL);
    pthread_create(&t2, NULL, unique, NULL);
    pthread_create(&t3, NULL, unique, NULL);

    printf("Main thread is running\n");

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    pthread_join(t3, NULL);
    return 0;
}
