#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
    int size = strlen(str);
    for (int i = 0; i < (size)/2; i++) {
        char temp = *(str + i);
        *(str + i) = *(str + (size - 1 - i));
        *(str + (size - 1 - i)) = temp;
    } 
}
int main() {
    char *str = NULL;
    printf("Enter a string: ");
    scanf("%m[^\n]s", &str);
    
    int vowels = 0, consonants = 0;
    processString(str, &vowels, &consonants);
    printf("Vowels: %d, Cons: %d\n", vowels, consonants);

    reverseString(str);
    printf("Rev: %s\n", str);

    free(str);
    return 0;
}
