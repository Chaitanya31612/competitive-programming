#include <stdio.h>

void copyStr(char s1[], char s2[])
{
    int i;
    for(i=0; s1[i]!='\0'; i++) {
        s2[i] = s1[i];
    }

    s2[i] = '\0';

    printf("\n%s\n", s2);
}

int factorial(int num)
{
    if(num <= 1) {
        return num;
    }

    return num * factorial(num-1);
}

void fibonacci(int n)
{
    static int n1=0, n2=1, n3;
    if(n>0) {
        n3 = n1 + n2;
        n1 = n2;
        n2 = n3;
        printf("%d ", n3);
        fibonacci(n-1);
    }
}

int ack(int m, int n)
{
    if(m==0)
        return n+1;
    else if(m > 0 && n == 0)
        return ack(m-1, 1);
    else if(m > 0 && n > 0)
        return ack(m-1, ack(m, n-1));
}
