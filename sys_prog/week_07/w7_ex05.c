#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main() {
    int fd_1[2], fd_2[2];
    if ((pipe(fd_1) < 0) || (pipe(fd_2) < 0)) {
        perror("pipe");
        return 1;
    }

    pid_t pid = fork();
    if (pid < 0) {
        perror("fork");
        return 1;
    } else if (pid == 0) {
        close(fd_1[0]);
        close(fd_2[1]);

        char mess[100], buf[100];
        int byteRead;
        write(1, "[CHI] Send: ", 12);
        while ((byteRead = read(0, buf, sizeof(buf))) > 0) {
            write(fd_1[1], buf, byteRead);
            if (buf[byteRead - 1] == '\n') break;
        }
        int n = read(fd_2[0], mess, sizeof(mess));
        if (n > 0) {
            mess[n] = '\0';
            write(1, "[CHI] Received: ", 16);
            write(1, mess, strlen(mess));
        }
        
        close(fd_1[1]);
        close(fd_2[0]);
    } else {
        close(fd_1[1]);
        close(fd_2[0]);

        char mess[100], buf[100];
        int byteRead, n = read(fd_1[0], mess, sizeof(mess));
        if (n > 0) {
            mess[n] = '\0';
            write(1, "[PAR] Received: ", 16);
            write(1, mess, strlen(mess));
        }
        write(1, "----------\n[PAR] Send: ", 23);
        while ((byteRead = read(0, buf, sizeof(buf))) > 0) {
            write(fd_2[1], buf, byteRead);
            if (buf[byteRead - 1] == '\n') break;
        }
        wait(NULL);
        close(fd_1[0]);
        close(fd_2[1]);
    }
    return 0;
}
