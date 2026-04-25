#include <stdio.h>
#include <pthread.h>

int counter;
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;

void *increment(void *arg) {
    for (int i = 0; i < 100; i++) {
        pthread_mutex_lock(&lock);
        counter += 1;
        pthread_mutex_unlock(&lock);
    }
}
void *decrement(void *arg) {
    for (int i = 0; i < 50; i++) {
        pthread_mutex_lock(&lock);
        counter -= 1;
        pthread_mutex_unlock(&lock);
    }
}
int main() {
    pthread_t t1, t2;
    pthread_create(&t1, NULL, increment, NULL);
    pthread_create(&t2, NULL, decrement, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    printf("Main: counter = %d\n", counter);
    return 0;
}
