#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int readFromKeyboard(FILE *dest);
int readFromFile(FILE *dest);

int main() {
    int cmd;
    FILE *dest = fopen("Ex2_File.txt", "w");
    if (dest == NULL) {
        perror("open");
        return 1;
    }
    while (1) {
        printf("\n--- COMMAND MENU ---\n");
        printf(" * You created a file *\n");
        printf("1. Enter contents of file by keyboard\n");
        printf("2. Read from other file and write to created file\n");
        printf("0. Exit program\n");
        printf("--> Select command: ");
        scanf("%d", &cmd);
        getchar();
        switch (cmd) {
            case 1:
                if (readFromKeyboard(dest) < 0) {
                    perror("Cmd 1");
                    fclose(dest);
                    return 1;
                } break;
            case 2:
                if (readFromFile(dest) < 0) {
                    perror("Cmd 2");
                    fclose(dest);
                    return 1;
                } break;
            case 0:
                fclose(dest);
                printf(" *** Exiting program... ***\n");
                return 0;
            default: printf(" *** Invalid command ***\n"); break;
        }
    }
    return 0;
}
int readFromKeyboard(FILE *dest) {
    char str[100];
    printf(" - Enter contents: ");
    scanf("%s", str);

    fprintf(dest, "%s", str);
    printf(" * Write complete\n");
}
int readFromFile(FILE *dest) {
    char name[100], buf[100];
    printf(" - Choose file to read: ");
    scanf("%s", name);

    FILE *source = fopen(name, "r");
    if (fscanf(source, "%s", buf) < 0) {
        perror("read");
        return -1;
    }
    if (fprintf(dest, "%s", buf) < 0) {
        perror("write");
        return -1;
    }
    printf(" * Write complete\n");
    fclose(source);
}

