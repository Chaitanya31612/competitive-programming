#include <stdio.h>

void main()
{
    int base = 6;

    printf("%d",nsquares(base));
}

int nsquares(int base)
{
    base = (base -2);

    base/=2;

    return base*(base+1)/2;
}
