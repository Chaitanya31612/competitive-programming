#include <stdio.h>

void bubblesort()
{
    int array[] = {4, 1, 6, 2, 8, 7};

    for(int i=0; i<6; i++){
        for(int j = 0; j < 6; j++){
            if(array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
    for(int i=0; i<6; i++)
    {
        printf("%d ", array[i]);
    }
}
