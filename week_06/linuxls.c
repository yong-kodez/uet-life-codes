#include <stdio.h>
#include <dirent.h>

int main(int argc, char*argv[]) {
    DIR *dirp = opendir(argv[1]);
    if (dirp == NULL) {
        perror("open");
        return -1;
    }

    struct dirent *files;
    while ((files = readdir(dirp)) != NULL) {
        printf("%ld %s\n", files->d_ino, files->d_name);
    }

    if (closedir(dirp) < 0) {
        perror("close");
        return -1;
    }
    return 0;
}
