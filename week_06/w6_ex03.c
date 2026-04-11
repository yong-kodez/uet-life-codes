#include <stdio.h>
#include <sys/stat.h>

int main() {
    char name[50];
    struct stat statbuf;
    printf(" - Enter file's name: ");
    scanf("%s", name);
    if (stat(name, &statbuf) == 0) {
        printf(" + Size of %s: %ld\n", name, statbuf.st_size);
        printf(" + Access modes:\n\tDec: %d\n\tBin: %b\n\tOct: %o\n", statbuf.st_mode, statbuf.st_mode, statbuf.st_mode);
    } else perror("stat");
    return 0;
}

