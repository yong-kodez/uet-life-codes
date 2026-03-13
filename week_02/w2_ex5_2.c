#include <stdio.h>

int main() {
    int k;
    do {
        printf("Nhap do dai canh K >= 3: ");
        scanf("%d", &k);
    } while (k < 3);
    for (int i = 1; i <= k; i++) {
        for (int j = 1; j <= k; j++) {
            if (i==1 || j==1 || i==k || j==k 
                || i==j || j==k-i+1) 
                printf("* ");
            else printf("  ");
        }
        printf("\n");
    }
    return 0;
}
