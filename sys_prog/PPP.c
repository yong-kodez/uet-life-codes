#include <stdio.h>
#include <pthread.h>

pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;
static int stat = 0;
static int count = 1;

void *Ping(void *arg);
void *Pong(void *arg);
void *Peng(void *arg);

void main() {
    pthread_t t1, t2, t3;

    pthread_create(&t1, NULL, Ping, NULL);
    pthread_create(&t2, NULL, Pong, NULL);
    pthread_create(&t3, NULL, Peng, NULL);
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    pthread_join(t3, NULL);
    pthread_mutex_destroy(&lock);
    pthread_cond_destroy(&cond);
}
void *Ping(void *arg) {
    for (int i = 0; i < 10; i++) {
        pthread_mutex_lock(&lock);
        while (stat != 0) {
            pthread_cond_wait(&cond, &lock);
        }
        printf("%d. Ping ", i+1);
        stat = 1;
        pthread_cond_broadcast(&cond);
        pthread_mutex_unlock(&lock);
    }
}
void *Pong(void *arg) {
    for (int i = 0; i < 10; i++) {
        pthread_mutex_lock(&lock);
        while (stat != 1) {
            pthread_cond_wait(&cond, &lock);
        }
        printf("Pong ");
        stat = 2;
        pthread_cond_broadcast(&cond);
        pthread_mutex_unlock(&lock);
    }
}
void *Peng(void *arg) {
    for (int i = 0; i < 10; i++) {
        pthread_mutex_lock(&lock);
        while (stat != 2) {
            pthread_cond_wait(&cond, &lock);
        }
        printf("Peng\n");
        stat = 0;
        pthread_cond_broadcast(&cond);
        pthread_mutex_unlock(&lock);
    }
}
