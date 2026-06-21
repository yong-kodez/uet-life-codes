#include <stdio.h>

void processString(char *str, int *vowels, int *consonants) {
    for (str; *str != '\0'; str++) {
        if ((*str >= 'A' && *str <= 'Z') ||
            (*str >= 'a' && *str <= 'z')) {
            if (*str == 'a' || *str == 'u' || *str == 'e' 
                || *str == 'o' || *str == 'i')
                *vowels += 1;
            else *consonants += 1;
         }
    }
}
void reverseString(char *str) {
    char *endptr = str;
    while (*endptr != '\n') {
        endptr++;
    } endptr--;
    while (endptr - str > 0) {
        char temp = *str;
        *str = *endptr;
        *endptr = temp;
        str++; endptr--;
    }
}
int main() {
    char str[100];
    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);

    int vowels = 0, consonants = 0;
    processString(str, &vowels, &consonants);
    printf("Vowels: %d, Cons: %d\n", vowels, consonants);

    reverseString(str);
    printf("Rev: %s\n", str);

    return 0;
}
