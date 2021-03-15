#include <stdio.h>
#include <stdlib.h>

void main()
{
    struct book
    {
        char name;
        float price;
        int pages;
    }b1;

    printf("Enter name , price and pages of book\n");
    scanf("%c%f%d", &b1.name , &b1.price , &b1.pages );

    printf("\nYou entered \n");
    printf("%c   %.2f   %d",b1.name, b1.price , b1.pages);

}
