#include <stdio.h>

int BinarySearch();
void InsertionSort();

void main() {
    // printf("%d", BinarySearch());
    InsertionSort();
}

void InsertionSort() {
    int arr[] = {4, 2, 1, 7, 3, 6, 5};
    int size = sizeof(arr) / sizeof(int);

    for (int i = 1; i < size; i++)
    {
        int key = arr[i];
        int j = i - 1;
        while(j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }

    for (int i = 0; i < size; i++)
    {
        printf("%d", arr[i]);
    }
    
    
}

int BinarySearch() {
    int arr[] = {1, 4, 5, 6, 8, 10};
    int target = 8;
    int size = sizeof(arr) / sizeof(int);
    int max = size - 1;
    int min = 0;

    while(max >= min) {
        int middle = (max + min) / 2;
        if(arr[middle] == target) {
            return middle;
        } else if (arr[middle] > target)
        {
            max = middle - 1;
        } else if (arr[middle] < target)
        {
            min = middle + 1;
        }        
        
    }
    return -1;
}