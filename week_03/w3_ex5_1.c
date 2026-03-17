#include <stdio.h>

long fibo(int n) {
    if (n <= 1) return n;
    return fibo(n-1) + fibo(n-2);
} 
int main() {
    int n;
    printf("Nhap so nguyen duong n: ");
    scanf("%d",&n);
    
    printf("So Fibonacci thu %d la: %ld\n", n, fibo(n));
    return 0;
}
