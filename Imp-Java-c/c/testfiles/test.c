#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void isPalindrome();

void main()
{
    char str[100];
    gets(str);
    isPalindrome(str);
}

void isPalindrome(char str[])
{
    int len = strlen(str);
    for(int i=0; i<len/2; i++) {
        if(str[i] != str[len - i - 1]) {
            printf("%s is not palindrome\n", str);
            return;
        }
    }
    printf("%s is palindrome\n", str);
}
