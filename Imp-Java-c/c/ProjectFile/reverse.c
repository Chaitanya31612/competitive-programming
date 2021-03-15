#include <stdio.h>
#include <string.h>

void reverse(char str[])
{
    int begin, end, count=0;
    char s[100];

    // length
    while(str[count] != '\0') {
        count++;
    }

    end = count - 1;
    for(begin = 0; begin<count; begin++) {
        s[begin] = str[end];
        end--;
    }

    s[begin] = '\0';
    printf("%s\n", s);

}
