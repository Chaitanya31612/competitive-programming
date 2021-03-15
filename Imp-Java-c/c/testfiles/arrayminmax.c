#include <stdio.h>
#include <stdlib.h>

void main()
{
    int arr[10] , i , min , max;
    for(i=0;i<10;i++){
        printf("Enter values of an array");
        scanf("%d",&arr[i]);
    }
    min = arr[0];
    for(i=0;i<10;i++){
        if(arr[i] < min)
            min = arr[i];
    }

    max = arr[0];
    for(i=0;i<10;i++){
        if(arr[i] > max)
            max = arr[i];
    }

    printf("The minimum number from the array is %d and the maximum is %d",min,max);
}
