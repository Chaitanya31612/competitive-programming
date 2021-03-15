#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char mstrncat(char *dest,char *src , int num)
{
    char *ptr = dest + strlen(dest);

    while(*src != '\0' && num--)
        *ptr++ = *src++;

    *ptr = '\0';
    return *ptr;
}

void main()
{
    char dest[25] = "Chaitanya ";
    char src[] = "Guptaji";

    mstrncat(dest,src,5);

    puts(dest);
}
