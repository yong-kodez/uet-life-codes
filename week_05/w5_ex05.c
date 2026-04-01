#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    struct Student {
        char *name;
        int age;
    };
    int len;
    struct Student s1;
    s1.name = (char*)malloc(30 * sizeof(char));
    if (s1.name == NULL) {
        printf("MEMORY ERROR!");
        return 1;
    }
    printf("Nhap thong tin sinh vien:\n");
    printf("- Ten: ");
    fgets(s1.name, 30, stdin);
    len = strlen(s1.name);
    *(s1.name + len - 1) = '\0';
    printf("- Tuoi: ");
    scanf(" %d", &s1.age);
    printf("---Thong tin sinh vien---\n");
    printf("- Ten: %s\n", s1.name);
    printf("- Tuoi: %d\n", s1.age);
    free(s1.name);
    return 0;
}
