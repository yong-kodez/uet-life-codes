#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

int main() {
    int fd = open("./Hello.txt", O_RDONLY); 
    if (fd < 0) {
        perror("Open error!");
        exit(1);
    }
    char buf[100] = {0};
    ssize_t byteRead, byteWrite;
    while ((byteRead = read(fd , buf, sizeof(buf))) > 0) {
        if ((write(1, buf, byteRead)) < 0) {
            perror("write");
            exit(1);
        }
    }
    if ((lseek(fd, 7, SEEK_SET)) < 0) {
        perror("seek");
        exit(1);
    }
    while (((byteRead = read(fd, buf, sizeof(buf))) > 0)) {
        if ((write(1, buf, byteRead)) < 0) {
            perror("write");
            exit(1);
        }
    }
    close(fd);
    return 0;
}
