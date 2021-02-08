#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void swapElements(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}
// Partition function
int partition(int arr[], int lowIndex, int highIndex)
{
    int pivotElement = arr[highIndex];
    int i = (lowIndex - 1);
    for (int j = lowIndex; j <= highIndex - 1; j++)
    {
        if (arr[j] <= pivotElement)
        {
            i++;
            swapElements(&arr[i], &arr[j]);
        }
    }
    swapElements(&arr[i + 1], &arr[highIndex]);
    return (i + 1);
}
// QuickSort Function
void quickSort(int arr[], int lowIndex, int highIndex)
{
    if (lowIndex < highIndex)
    {
        int pivot = partition(arr, lowIndex, highIndex);
        // Separately sort elements before & after partition
        quickSort(arr, lowIndex, pivot - 1);
        quickSort(arr, pivot + 1, highIndex);
    }
}
// Function to print array
void printArray(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
        printf("%d ", arr[i]);
}


void main() {
    int t, n;
    scanf("%d%d", &t, &n);

    while(t-- > 0) {
        int a[n];
        for(int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }

        quickSort(a, 0, n - 1);

        int ax = a[0], az = a[n - 1];
        int key = (ax + az) / 2;
        int ay;

        if (n % 2 == 0)
        {
            int x = n / 2;
            int y = x - 1;

            int c1 = abs(ax - a[x]) + abs(a[x] - az) + abs(az - ax);
            int c2 = abs(ax - a[y]) + abs(a[y] - az) + abs(az - ax);

            if (c1 > c2)
            {
                ay = x;
            }
            else
            {
                ay = y;
            }
        }
        else
        {
            ay = a[(n - 1) / 2];
        }

        long ans = abs(ax - ay) + abs(ay - az) + abs(az - ax);
        printf("%d\n", ans);
    }
}