#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>

int main() {
    char name[50];
    int fd;
    struct stat statbuf;
    printf(" - Enter file's name: ");
    scanf("%s", name);
    if (stat(name, &statbuf) == 0) {
        printf(" + Size of %s: %ld\n", name, statbuf.st_size);
        printf(" + Access modes: %b\n", statbuf.st_mode);
    } else perror("stat");
    return 0;
}
