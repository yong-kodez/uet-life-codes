#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf(" * Need 3 arguments, have %d\n", argc);
        exit(1);
    }
    FILE *fb = fopen(argv[2], "r");
    if (fb == NULL) {
        perror("open");
        return 1;
    }
    char line[100];
    int lineNum = 1;
    while (fgets(line, sizeof(line), fb) > 0) {
        if (strstr(line, argv[1]) != NULL) {
            printf("(%d): %s", lineNum, line);
        }
        lineNum +=1;
    }
}
