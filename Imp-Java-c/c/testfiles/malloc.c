#include <stdio.h>
#include <stdlib.h>

void main()
{
    int size;
    char *text = NULL;

    printf("Enter the limit of the string\n");
    scanf("%d",&size);

    text = (char *)malloc(size*sizeof(char));

    if(text != NULL)
    {
        printf("Enter some text\n");
        scanf(" ");
        gets(text);
        printf("You just entered\n");
        puts(text);
    }

    free(text);
    text = NULL;
}
