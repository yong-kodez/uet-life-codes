#include <stdio.h>

int triangle_check(int x, int y, int z) {
    if (x+y>z && x+z>y && y+z>x){
        printf("Ba canh tao thanh mot tam giac\n");
        return 1;
    } else {
        printf("Ba canh khong tao thanh mot tam giac\n");
        return 0;
    }
}
void triangle_type(int x, int y, int z) {
    if (x == y && y== z) 
        printf("Day la tam giac deu\n");
    else if  (x*x + y*y == z*z || x*x + z*z == y*y || y*y + z*z == x*x) {
        if (x == y || y == z || z == x) 
            printf("Day la tam giac vuong can\n");
        else
            printf("Day la tam giac vuong\n");
    }
    else if (x == y || y == z || z == x)
        printf("Day la tam giac can\n");
    else
        printf("Day la tam giac thuong\n");
}
int main() {
    int a, b, c;
    do {
        printf("Nhap ba canh tam giac: ");
        scanf("%d %d %d", &a, &b, &c);
    } while (a <=0 || b <= 0 || c <= 0);

    if (triangle_check(a,b,c) == 1) 
        triangle_type(a,b,c);

    return 0;
}
