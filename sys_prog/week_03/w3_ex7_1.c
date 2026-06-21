#include <stdio.h>

int strlen(char string[]) {
    int wcount = 0;
    char *ptr = string;
    while (*ptr != '\0') {
        wcount += 1;
        ptr += 1;
    }
    return wcount;
}
int strcmp(char s1[], char s2[]) {
    char *ptr1 = s1, *ptr2 = s2;
    while (*ptr2 != '\0' || *ptr1 != '\0') {
        if (*ptr1 != *ptr2) return 0;
        ptr1 += 1;
        ptr2 += 1;
    }
    return 1;
}
void strcpy(char s2[], char s1[]) {
    char *ptr1 = s1, *ptr2 =s2;
    while (*ptr1 != '\0') {
        *ptr2 = *ptr1;
        ptr1 += 1;
        ptr2 += 1;
    }
    *(ptr2 + 1) = '\0';
}
void strcat(char s1[], char s2[]) {
    char *ptr1 = s1, *ptr2 =s2;
    ptr1 = s1 + strlen(s1);
    while (*ptr2 != '\0') {
        *ptr1 = *ptr2;
        ptr1 += 1;
        ptr2 += 1;
    }
    *(ptr1 + 1) = '\0';
}

int main() {
    char s1[100], s2[100], str1[100], str2[100], string1[100], string2[100];
    printf("Nhap chuoi s1: ");
    scanf("%s", s1);
    printf("Nhap chuoi s2: ");
    scanf("%s", s2);

    printf("Do dai chuoi s1: %d\n", strlen(s1));
    if (strcmp(s1,s2) == 1) printf("Hai chuoi giong nhau\n");
    else printf("Hai chuoi khac nhau\n");
    
    printf("Nhap chuoi str1: ");
    scanf("%s", str1);
    strcpy(str2,str1);
    printf("Chuoi str2 copy tu str1: %s\n", str2);

    printf("Nhap chuoi string1, string2: ");
    scanf("%s %s", string1, string2);
    strcat(string1,string2);
    printf("Noi 2 chuoi str1 va str2: %s\n", string1);

}
