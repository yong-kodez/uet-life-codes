#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int sharedVar = 5;

int main() {
    pid_t pid = fork();
    if (pid < 0) {
        perror("Fork failed\n");
        exit(1);
    }
    if (pid == 0) {
        sharedVar += 10;
        printf("Child Proces: sharedVar = %d\n", sharedVar);
        exit(0);
    } else {
        wait(NULL);
        printf("Parent Process: sharedVar = %d\n", sharedVar);
    }
    return 0;
}
