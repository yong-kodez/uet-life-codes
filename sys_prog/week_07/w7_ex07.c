#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
#include <dirent.h>
#include <stdlib.h>
#include <signal.h>

pid_t pid;

void sig_handler(int sig);

int main() {
    pid = fork();
    if (pid < 0) {
        printf("Fork error!");
    } else if (pid == 0) {
        int count = 1;
        while (1) {
            DIR *dp = opendir(".");
            if (dp == NULL) {
                perror("open dir");
                return 1;
            }
            printf("\n * Checking...attempt %d:\n", count);
            struct dirent *files;
            while ((files = readdir(dp)) != NULL) {
                printf("%s ", files->d_name);
            } printf("\n");
            count++;
            if (closedir(dp) < 0){
                perror("close dir");
                return 1;
            }
            sleep(60);
        }
    } else {
        signal(SIGINT, sig_handler);
        wait(NULL);
    }
}
void sig_handler(int sig) {
    kill(pid, SIGKILL);
    printf("\nProgram is terminated by user\n");
    exit(0);
}
