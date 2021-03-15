#include <stdio.h>

void main()
{
    int i ,n ,r , rev=0;
    scanf("%d",&n);
    while(n)
    {
        r = n%10;
        rev = rev*10 + r;
        n /= 10;
    }
    printf("%d",rev);


    /*int i, n;
    scanf("%d",&n);
    for(i=1;i<=10;i++){
        printf("%d X %d = %d\n",n,i,(n*i));
    }*/

}
