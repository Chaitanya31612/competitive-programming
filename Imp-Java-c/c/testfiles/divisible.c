#include <stdio.h>

void main()
{
    int num;
    scanf("%d",&num);

    if(num%5==0 && num%11==0)
    {
        printf("Number is divisible by 5 and 11");
    }
    else
        printf("Not divisible");
}
