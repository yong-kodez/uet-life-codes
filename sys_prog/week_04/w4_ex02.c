#include <stdio.h>
#include <stdlib.h>

int calculateSum(int n) {
    if (n <= 0) return 0;
    return n + calculateSum(n - 1);
}
int main() {
    int n;
    printf("Enter n: ");
    scanf("%d", &n);
    printf("Sum: %d\n", calculateSum(n));
    return 0;
}
