#include <stdio.h>
#include <dirent.h>
#include <unistd.h>

int main() {
    pid_t pid = fork();
    if (pid < 0) printf("Fork failed!\n");
    else if (pid == 0) {
        execlp("ls", "ls", NULL);
    }
}
