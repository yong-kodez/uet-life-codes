#include <stdio.h>
#include <pthread.h>

long N = 1<<20;
int p;
long total = 0;
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;

void *work(void *arg) {
    long id = (long)arg;
    long start = id * N / p;
    long end = (id + 1) * N / p;

    for (long i = start; i < end; i++) {
        pthread_mutex_lock(&lock);
        total += i;
        pthread_mutex_unlock(&lock);
    }
    return NULL;
}
int main() {
    long id;
    printf("Enter n threads: ");
    scanf("%d", &p);

    pthread_t t[p];
    for (int i = 0; i < p; i++) {
        id = i;
        pthread_create(&t[i], NULL, work, (void*)id);
    }
    for (int i = 0; i < p; i++) {
        pthread_join(t[i], NULL);
    }
    printf(" * Total: %ld\n", total);
    return 0;
}
