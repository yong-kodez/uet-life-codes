#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int readFromKeyboard(int dest);
int readFromFile(int dest);
int main() {
    int cmd, dest;
    dest = open("Ex2_File.txt", O_RDWR | O_TRUNC | O_CREAT, 0766);
    if (dest < 0) {
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
                    close(dest);
                    return 1;
                } break;
            case 2:
                if (readFromFile(dest) < 0) {
                    perror("Cmd 2");
                    close(dest);
                    return 1;
                } break;
            case 0:
                close(dest);
                printf(" *** Exiting program... ***\n");
                return 0;
            default: printf(" *** Invalid command ***\n"); break;
        }
    }
    return 0;
}
int readFromKeyboard(int dest) {
    char buf[100];
    ssize_t byteRead;
    write(1, " - Enter contents: ", 19);
    while ((byteRead = read(0, buf, sizeof(buf))) > 0) {
        if (write(dest, buf, byteRead) < 0) {
            perror("write");
            return -1;
        } break;
    }
    printf(" * Write complete!\n");
    return 0;
}
int readFromFile(int dest) {
    char name[100], buf[100];
    ssize_t byteRead;
    int source;
    printf(" - Choose file to read: ");
    scanf("%s", name);
    source = open(name, O_RDONLY);
    if (source < 0) {
        perror("open");
        return -1;
    }
    while ((byteRead = read(source, buf, sizeof(buf))) > 0) {
        if (write(dest, buf, byteRead) < 0) {
            perror("write");
            return -1;
        }
    }
    printf(" * Write complete!\n");
    close(source);
    return 0;
}

