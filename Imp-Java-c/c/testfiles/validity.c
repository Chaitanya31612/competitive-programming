#include <stdio.h>

void main()
{
    int a , b , c;
    scanf("%d%d%d",&a,&b,&c);

    if((a+b+c)== 180)
    {
        printf("Triangle is valid");
    }
    else{
        printf("Invalid");
    }
}
