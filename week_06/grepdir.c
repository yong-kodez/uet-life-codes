#include <stdio.h>
#include <dirent.h>
#include <string.h>

void grepPrint(char fileName[], char word[]);

int main(int argc, char *argv[]) {
    DIR *dirp = opendir(argv[2]);
    if (dirp == NULL) {
        perror("open dir");
        return 1;
    }
    char files[100];
    struct dirent *dirEnt;
    
    printf(" * Files contain %s:\n", argv[1]);
    while ((dirEnt = readdir(dirp)) != NULL) {
        grepPrint(dirEnt->d_name, argv[1]);
    }
    return 0;
}
void grepPrint(char fileName[], char word[]) {
    FILE *fp = fopen(fileName, "r");
    char cont[100];
    int lineNum = 1, wlineCount = 0;
    while (fgets(cont, sizeof(cont), fp) != NULL) {
        if (strstr(cont, word) != NULL) {
            wlineCount += 1;
            if (wlineCount == 1)
                printf("%s (lines:", fileName);
            else
                printf(" %d", lineNum);
        }
        lineNum += 1;
    }
    if (wlineCount > 0) printf(")\n");
    fclose(fp);
}
