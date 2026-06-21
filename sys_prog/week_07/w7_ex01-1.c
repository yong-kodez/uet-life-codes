#include <stdio.h>
#include <unistd.h>

int main() {
    printf("Case 1: Do not wait\n");
    pid_t pid = fork();
    if (pid < 0) {
        printf("Fork failed!\n");
    }
    else if (pid > 0) {
        printf("[PARENT] Do not wait for child\n");
    }
    else {
        printf("[CHILD] Execute complete!\n");
    }
    return 0;
}
