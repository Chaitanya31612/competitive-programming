#include <stdio.h>

void quickSort();
int partition();
void swap();
void QuickSort();

void main() {
    printf("Quick sort\n");
    int a[5], temp, j;
    for (int i = 0; i < 5; i++)
    {
        scanf("%d", &a[i]);
    }
    // int a = 32, b = 54;
    // swap(&a, &b);
    // printf("%d %d",a, b);
    quickSort(a, 0, 4);
    // QuickSort(a, 0 , 4)
    // sorted
    for (int i = 0; i < 5; ++i)
    {
        printf("%d ", a[i]);
    }
}

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void quickSort(int a[], int lb, int ub) {
    if(lb < ub) {
        int loc = partition(a, lb, ub);

        quickSort(a, lb, loc - 1);
        quickSort(a, loc + 1, ub);
    }
}

int partition(int a[], int lb, int ub) {
    int pivot = a[lb];
    int start = lb;
    int end = ub;

    while(start < end) {
        while(start < pivot) {
            start++;
        }
        while(end > pivot) {
            end--;
        }

        if(start < end) {
            swap(&a[start], &a[end]);
        }
    }
    swap(&a[lb], &a[end]);

    return end;
}

/* Quick Sort taking first element as pivot element*/
void QuickSort(int *arr, int start, int last)
{
    int i = start + 1, j = last, temp;
    if (i > j)
        return;
    while (i <= j)
    {
        if (arr[i] < arr[start])
        {
            i++;
        }
        if (arr[j] > arr[start])
        {
            j--;
        }
        if (i <= j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    temp = arr[start];
    arr[start] = arr[j];
    arr[j] = temp;

    QuickSort(arr, start, j - 1);
    QuickSort(arr, j + 1, last);
}