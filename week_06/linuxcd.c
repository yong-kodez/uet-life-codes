#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    int dest;
    char cwd[100];
    if ((dest = chdir(argv[1])) == 0) {
        getcwd(cwd, sizeof(cwd));
        printf(" * Change directory success!\n");
        printf("   Current directory: %s\n", cwd);
    } else {
        perror(" * Change dir");
        return 1;
    }
    return 0;

} 
