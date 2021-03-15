#include <stdio.h>
char *binbin(int n);
int main()
{
 int a,x,r,c=0;
 char *bin;
 a = 3;
 x = 4;
 printf(" %s %3d\n",binbin(a),a);
 printf("^ %s %3d\n",binbin(x),x);
 r = a ^ x;
 printf("= %s %3d\n",binbin(r),r);
 bin = binbin(r);
 for(int i=0;i<8;i++)
    printf("%c ",*(bin+i));
 for(int i=0;i<8;i++)
 {
     if(*(bin+i)=='1')
        c++;
 }
 printf("\n%d",c);
 //printf("%c",*(bin+6));
 return(0);
}
char *binbin(int n)
{
 static char bin[9];
 int x;
 for(x=0;x<8;x++)
 {
 bin[x] = n & 0x80 ? '1' : '0';
 n <<= 1;
 }
 bin[x] = NULL;
 return(bin);
}
