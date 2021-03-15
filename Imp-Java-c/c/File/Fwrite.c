#include <stdio.h>

void fOpen()
{
    int num;
    FILE *fptr;

    fptr = fopen("D:\\newprogram.txt","w");
    if(fptr == NULL)
   {
      printf("Error!");
      exit(1);
   }

   printf("Enter num: ");
   scanf("%d",&num);

   fprintf(fptr,"%d",num);
   fclose(fptr);
}
