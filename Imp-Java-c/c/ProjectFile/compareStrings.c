#include <stdio.h>

int len(char str[])
{
    int count = 0;
    while(str[count] != '\0'){
        count++;
    }
    return count;
}

void compareStrings(char s1[], char s2[])
{
    int c = 0;
    while(s1[c] == s2[c]){
        if(s1[c] == '\0' || s2[c] == '\0')
        break;
        c++;
    }

    if(s1[c]=='\0' && s2[c]=='\0'){
        printf("they are equal");
    } else
    printf("Not equal");
}
