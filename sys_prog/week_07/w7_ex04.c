#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

#define CMDSIZ 32
void process_command(char *cmdbuf);

int main() {
    int logout = 0, cmdsiz;
    char cmdbuf[CMDSIZ];
    while (!logout) {
        write(1, "myshell> ", 9);
        cmdsiz = read(0, cmdbuf, CMDSIZ);
        cmdbuf[cmdsiz - 1] = '\0';
        if (strcmp("logout", cmdbuf) == 0) 
            ++logout;
        else process_command(cmdbuf);
    }
    return 0;
}
void process_command(char *cmdbuf) {
    int idx = 0;
    char *argv[5], *ptr = cmdbuf;
    argv[0] = cmdbuf;

    for (ptr; *ptr != '\0'; ptr++) {
        if (*ptr == ' ') {
            *ptr = '\0';
            idx++;
            argv[idx] = ptr + 1;
        }
    } argv[idx + 1] = NULL;

    if (strcmp(argv[0], "cd") == 0) {
        if (argv[1] == NULL) {
            char *home = getenv("HOME");
            if (chdir(home) < 0) perror("cd home");
        } else {
            if (chdir(argv[1]) < 0) perror("cd");
        }
        printf("\n");
        return;
    }
    pid_t pid = fork();
    if (pid < 0) printf(" ! Fork error !\n");
    else if (pid == 0) {
        execvp(argv[0], argv);
    } else {
        wait(NULL);
        printf("\n");
        return;
    }
}
