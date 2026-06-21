#include <stdio.h>
#include <pthread.h>

long N = 1<<20;
int p;
long gsum[16] = {0};

void *work(void *arg) {
    long id = (long)arg;
    long start = id * N / p;
    long end = (id + 1) * N / p;

    long local_sum = 0;
    for (long i = start; i < end; i++) {
        local_sum += i;
    }
    gsum[id] = local_sum;
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
    long total = 0;
    for (int i = 0; i < p; i++) {
        printf("%d\n", gsum[i]);
        total += gsum[i];
    }
    printf(" * Total: %ld\n", total);
    return 0;
}
