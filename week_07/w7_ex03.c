#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();
    if (pid < 0) printf("Fork failed!\n");
    else if (pid == 0) {
        char *home = getenv("HOME");
        if (home == NULL) {
            perror("path");
            return 1;
        }
        execlp("ls", "ls", "-l", home, NULL);
    } else {
        int status;
        wait(&status);
        printf("***");
        printf("[PARENT] The program still alive till now!\n");
    }
    return 0;
}
