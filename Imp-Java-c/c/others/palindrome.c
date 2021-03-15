#include <stdio.h>
#include <string.h>

void isPalindrome(char str[]);

void main() {
    char str[100];
    gets(str);
    isPalindrome(str);
}

void isPalindrome(char str[]) {
    int len = strlen(str);
    for (int i = 0; i < len / 2; i++) {
        if(str[i] != str[len - i - 1]) {
            printf("Not Palindrome");
            return;
        }
    }
        printf("Palindrome");
}