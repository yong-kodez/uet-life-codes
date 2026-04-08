#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf(" * Need 3 arguments, have %d\n", argc);
        exit(1);
    }
    int dest;
    dest = open(argv[2], O_WRONLY | O_TRUNC | O_CREAT, 0744);
    if (dest < 0) {
        perror("open");
        exit(1);
    }

    int len = strlen(argv[1]);
    argv[1][len] = '\n';
    argv[1][len + 1] = '\0';
    if (write(dest, argv[1], len + 1) < 0) {
        perror("write");
        exit(1);
    }
    
    close(dest);
    return 0;
}
