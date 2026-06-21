#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
int main() {
    printf("Case 2: Wait for child\n");
    pid_t pid;
    pid = fork();
    if (pid < 0) printf("Fork failed!\n");
    else if (pid > 0) {
        int status;
        wait(&status);
        printf("[PARENT] Wait for child\n");
    }
    else {
        printf("[CHILD] Execute complete!\n");
    }
}
