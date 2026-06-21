#include <stdio.h>
#include <stdlib.h>

void increment(int n) {
    n = n + 1;
}
void realIncrement(int *n) {
    *n = *n + 1;
}
int main() {
    int value = 10;
    printf("Value: %d\n", value);
    increment(value);
    printf("increment: %d\n", value);
    realIncrement(&value);
    printf("realIncrement: %d\n", value);
    return 0;
}
