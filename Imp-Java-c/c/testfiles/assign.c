#include <stdio.h>
#include <stdlib.h>

int binarySearch(int values[], int len, int target)
{
    int max = (len - 1);
    int min = 0;

    int middle;
    int step = 0;

    while(max>=min)
    {
        middle = (max+min) / 2;
        step++;

        if(values[middle] == target)
        {
            return middle;
        }
        else if(values[middle] > target)
        {
            max = (middle - 1);
        }
        else
        {
            min = (middle + 1);
        }
    }
    return -1;
}

void main()
{
    int values[] = {2,3,5,6,8};
    int n = sizeof(values)/sizeof(values[0]);
    int target = 5;

    int result = binarySearch(values,target,n);
    if(result == -1)
    {
        printf("Element is not present in the given array.");
    }
    else
    {
        printf("Element is present at index: %d", result);
    }
}
