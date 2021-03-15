#include <stdio.h>
#include <stdlib.h>

void main()
{
    int n, a ,b, c,d , sum=0;
    scanf("%d",&n);
    for(int i=0;i<=n;i++){
        char c;
        int time;
        scanf("%c%d",&c,&time);
        if(c=='A')
            a+=1;
        else if(c=='B')
            b+=1;
        else if(c=='C')
            c+=1;
        else if(c=='D')
            d+=1;
    }
    int e = a>b?a:b;
    int f = c>d?c:d;
    int l = e>f?e:f;
    int sl = e<f?e:f;
    int x = a<b?a:b;
    int y = c<d?c:d;
    int s = x<y?x:y;
    int ss = x>y?x:y;

    sum = l*100 + sl*75 + ss*50 + s*25;
    printf("%d",sum);
}
