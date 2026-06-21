#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <signal.h>
#include <unistd.h>

#define SIZE 5

int tray[SIZE] = {0};
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

void *produce(void *arg) {
    int val = 0;
    while (1) {
        pthread_mutex_lock(&lock);
        while (tray[SIZE - 1] != 0) {
            sleep(1);
            printf(" * Tray full! Waiting...\n");
            pthread_cond_wait(&cond, &lock);
        }

        for (int i = 0; i < SIZE; i++) {
            if (tray[i] == 0) {
                sleep(1);
                val += 1;
                tray[i] = val;
                printf(" + Generated %d, placing %d\n", val, val);
                pthread_cond_signal(&cond);
                break;
            }
        }
        pthread_mutex_unlock(&lock);
    }
}
void *consume(void *arg) {
    while (1) {
        pthread_mutex_lock(&lock);
        while (tray[0] == 0) {
            sleep(1);
            printf(" * Tray empty! Waiting...\n");
            pthread_cond_wait(&cond, &lock);
        }

        for (int i = SIZE - 1; i >= 0; i--) {
            if (tray[i] != 0) {
                sleep(1);
                printf(" - Took %d, serving %d\n", tray[i], tray[i]);
                tray[i] = 0;
                pthread_cond_signal(&cond);
                break;
            }
        }
        pthread_mutex_unlock(&lock);
    }
}
void sig_handler(int sig) {
    printf("\n*** Service terminated!\n");
    exit(0);
}
int main() {
    signal(SIGINT, sig_handler);
    pthread_t producer, consumer;
    pthread_create(&producer, NULL, produce, NULL);
    pthread_create(&consumer, NULL, consume, NULL);

    pthread_join(producer, NULL);
    pthread_join(consumer, NULL);
    return 0;
}
