#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Student {
    char *name;
    int age;
};
int main() {
    int cap = 10;
    struct Student s1;
    s1.name = (char*)malloc(cap * sizeof(char));
    if (s1.name == NULL) {
        printf("MEMORY ERROR!");
        return 1;
    }
    printf("Nhap thong tin sinh vien:\n");
    printf("- Ten: ");
    fgets(s1.name, cap, stdin);
    while (*(s1.name + strlen(s1.name) - 1) != '\n') {
        cap += 10;
        char *temp = (char*)realloc(s1.name, cap * sizeof(char));
        if (temp == NULL) {
            free(s1.name);
            printf("*** NAME MEMORY ERROR ***\n");
            return 1;
        }
        s1.name = temp;
        fgets(s1.name + strlen(s1.name), 10 + 1, stdin);
    }
    *(s1.name + strlen(s1.name) - 1) = '\0';
    printf("- Tuoi: ");
    scanf(" %d", &s1.age);

    printf("\n--- Thong tin sinh vien ---\n");
    printf("- Ten: %s\n", s1.name);
    printf("- Tuoi: %d\n", s1.age);

    free(s1.name);
    return 0;
}
