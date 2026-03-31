#include <stdio.h>

int main() {
    struct Student {
        char *name;
        int age;
    };
    int len, cap = 10; char c;
    struct Student s1;
    s1.name = (char*)malloc(cap * sizeof(char));
    if (s1.name == NULL) {
        printf("MEMORY ERROR!");
        return 1;
    }
    printf("Nhap thong tin sinh vien:\n");
    printf("- Ten: ");
    
    return 0;
}
