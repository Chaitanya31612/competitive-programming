#include <stdio.h>
#include <stdlib.h>

struct book
{
    char name[10];
    char author[10];
    int callNo;
};

display(struct book *bptr)
{
    printf("%s %s %d", bptr->name, bptr->author, bptr->callNo);
}

int main()
{
   char str[100], str2[100], str3[100];
   //gets(str);
   //gets(str2);
   //reverse(str);
   //printf("%d\n", len(str));
   //compareStrings(str, str2);
   //copyStr(str, str3);
   printf("%d\n", factorial(10));
   //printf("%d %d ", 0, 1);
   fibonacci(10);
   //printf("\n%d " ,ack(1, 2));
   struct book b1 = {"Let us C", "YPK", 101};
   display(&b1);
}
