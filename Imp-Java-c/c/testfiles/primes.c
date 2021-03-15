#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void main()
{
    int p , i;
    int primes[50] = {0};
    int primeIndex = 2;

    bool isPrime ;

    primeIndex = 2;

    primes[0] =2;
    primes[1] = 3;

    for(i=5; i<=100;i++)
    {
        isPrime = true;

        for(i=1; isPrime && p/primes[i] >= primes[i] ;i++)
            if(p % primes[i] == 0)
                isPrime = false;


        if(isPrime)
        {
            primes[primeIndex] = p;
            ++primeIndex;
        }
    }

    for(i=0;i<primeIndex;i++)
    {
        printf("%d ",primes[i]);
    }
}
