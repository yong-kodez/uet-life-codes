#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    if (argc < 3) {
        printf(" * Need 3 arguments, have %d\n", argc);
        exit(1);
    }
}
