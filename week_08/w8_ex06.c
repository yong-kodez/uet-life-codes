#include <stdio.h>
#include <pthread.h>

int counter;
int size;
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

void *barrier(void *arg) {
    pthread_mutex_lock(&lock);
    int id = (int)arg;
    counter += 1;
    printf(" - Thread %d reached the barrier\n", id + 1);

    if (counter == size) {
        printf(" *** All threads reached the barrier! Releasing them ...\n");
        pthread_cond_broadcast(&cond);
    } else pthread_cond_wait(&cond, &lock);

    printf(" - Thread %d passed the barrier\n", id + 1);
    pthread_mutex_unlock(&lock);
}
int main() {
    printf("Enter number of threads: ");
    scanf("%d", &size);

    pthread_t ths[size];
    for (int i = 0; i < size; i++) {
        pthread_create(&ths[i], NULL, barrier, (void*)i);
    }
    for (int i = 0; i < size; i++) {
        pthread_join(ths[i], NULL);
    }
    return 0;
}
