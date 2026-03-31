#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    struct Student {
        char *name;
        int age;
    };
    char c; int len;
    struct Student s1;
    s1.name = (char*)malloc(20 * sizeof(char));
    if (s1.name == NULL) {
        printf("MEMORY ERROR!");
        return 1;
    }
    printf("Nhap thong tin sinh vien:\n");
    printf("- Ten: ");
    fgets(s1.name, sizeof(s1.name), stdin);
    len = strlen(s1.name);
    s1.name[len - 1] = '\0';
    printf("%s %d", s1.name, len);
    
    return 0;
}
