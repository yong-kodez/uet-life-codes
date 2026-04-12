#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf(" * Need 3 arguments, have %d\n", argc);
        return 1;
    }
    int dest = open(argv[2], O_WRONLY | O_TRUNC | O_CREAT, 0644);
    if (dest < 0) {
        perror("open");
        return 1;
    }
    int len = strlen(argv[1]);
    if (write(dest, argv[1], len) < 0) {
        perror("write");
        return 1;
    }
    if (write(dest, "\n", 1) < 0) {
        perror("write");
        return 1;
    }
    close(dest);
    return 0;
}
