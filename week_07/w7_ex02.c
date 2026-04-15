#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

static int idata = 1000;
int main() {
    int istack = 150;
    int fd = open("Hello.txt", O_RDONLY);
    if (fd < 0) {
        perror("open");
        return 1;
    }
    pid_t childPid;
    childPid = fork();

    if (childPid < 0) printf("Fork failed!\n");
    else if (childPid == 0) {
        printf("[Child] Value of idata: %d, istack: %d\n", idata, istack);
        idata -= 100; istack += 100;
        printf("[Child] New value of idata: %d, istack: %d\n", idata, istack);

        if (lseek(fd, 6, SEEK_SET) < 0) {
            perror("child seek");
            return 1;
        }
        close(fd);
    }
    else {
        int byteRead, status;
        char buf[100];
        wait(&status);
        printf("[Parent] Value of idata: %d, istack: %d\n", idata, istack);
        write(1, "[Parent] Content read from Hello.txt:\n", 38);
        while ((byteRead = read(fd, buf, sizeof(buf))) > 0) {
            if (write(1, buf, byteRead) < 0) {
                perror("parent write");
                return 1;
            }
        }
        close(fd);
    }

    return 0;
}
