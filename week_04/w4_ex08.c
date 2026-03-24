#include <stdio.h>
#include <stdlib.h>

void processString(char *str, int *vowels, int *consonants) {
    for (str; str != '\0'; str++) {
        if (*str == 'a' || *str == 'u' || *str == 'e 
            || *str == 'o' || *str == 'i') 
            *vowels += 1;

    }
}
void reverseString(char *str) {

}
int main() {
    
    return 0;
}
