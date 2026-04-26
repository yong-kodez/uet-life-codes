#include <stdio.h>
#include <pthread.h>
#include <signal.h>

#define SIZE 5
int tray[SIZE] = {0};
int status = 0;
pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

void *produce(void *arg) {
    int val = 0;
    while (!status) {
        pthread_mutex_lock(&lock);
        if (tray[SIZE - 1] != 0) {
            for (int i = 0; i < SIZE; i++) {
                if (tray[i] == 0) {
                    sleep(1);
                    val += 1;
                    printf(" - Generated %d, placing %d\n", val, val);
                    tray[i] = val;
                    break;
                }
            }
        } else {
            sleep(1);
            printf(" * Tray full! Waiting...\n");
        }
        pthread_mutex_unlock(&lock);
    }

}
void *consume(void *arg) {
    while (!status) {
        pthread_mutex_lock(&lock);
        if (tray[0] != 0) {
            for (int i = SIZE - 1; i >= 0; i--) {
                if (tray[i] != 0) {
                    sleep(1);
                    printf(" - Took %d, serving %d\n", tray[i], tray[i]);
                    tray[i] = 0;
                    break;
                }
            }
        } else {
            sleep(1);
            printf(" * Tray empty! Waiting...\n");
        }
        pthread_mutex_unlock(&lock);
    }
}
void sig_handler(int sig) {
    status = 1;
}
int main() {
    signal(SIGINT, sig_handler);
    pthread_t producer, consumer;
    pthread_create(&producer, NULL, produce, NULL);
    pthread_create(&consumer, NULL, consume, NULL);

    pthread_join(producer, NULL);
    pthread_join(consumer, NULL);
    printf("*** Service terminated!\n");
    return 0;
}
