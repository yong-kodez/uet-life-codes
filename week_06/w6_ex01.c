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
        write(1, buf, sizeof(buf));
    }
    printf("\n");
    off_t offset;
    if ((offset = lseek(fd, 7, SEEK_SET)) < 0) {
        perror("seek");
        exit(1);
    }
    char buf[100] = {0};
    while ((byteRead = read(fd , buf, sizeof(buf))) > 0) {
        write(1, buf, sizeof(buf));
    }
    return 0;
}
