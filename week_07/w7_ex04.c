#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

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
    pid_t chi = fork();
    // echo : 1 
    // cd : 1
    // grep : 2

}
