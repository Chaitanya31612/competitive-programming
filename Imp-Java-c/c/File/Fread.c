#include <stdio.h>

void FRead()
{
    int num;
    FILE *fptr;

    if((fptr = fopen("D:\\newprogram.txt","r")) == NULL){
        printf("Error!");
        exit(1);
    }

    fscanf(fptr, "%d", &num);
    printf("value of n = %d", num);
    fclose(fptr);
}
