#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main() {
    int fd[2];
    if (pipe(fd) < 0) {
        perror("pipe");
        return 1;
    }
    pid_t pid = fork();

    if (pid < 0) {
        printf(" * Fork error!");
    } else if (pid == 0) {
        close(fd[0]);
        dup2(fd[1], 1);
        close(fd[1]);
        execlp("ls", "ls", NULL);

        perror("ls");
        return 1;
    } else {
        close(fd[1]);
        dup2(fd[0], 0);
        close(fd[0]);
        execlp("wc", "wc", "-l", NULL);
        char c;

        perror("wc");
        return 1;
    }
    return 0;
}
