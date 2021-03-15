#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

void main()
{
    int x = 5 , y;
    y = x++ * x++;
    printf("y = %d\n x = %d",y,x);
}
