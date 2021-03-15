/*#include <stdio.h>

void merge(int array[],int s, int e)
{
    int mid = (s+e)/2;
    int i=s;
    int j = mid + 1;
    int k = s;
    int temp[100];
    while(i<=mid && j<=e){
        if(array[i]<array[j]){
            temp[k++] = array[i++];
        } else {
            temp[k++] = array[j++];
        }
    }
        while(i<=mid)
            temp[k++] = array[i++];
        while(j <= e)
            temp[k++] = array[j];
        for(int a=s; a<=e; a++){
            array[a] = temp[a];
        }
}

void mergeSort(int array[], int s, int e)
{
    if(s >= e){
        return;
    }

    int mid = (s + e)/2;
    mergeSort(array, s, mid);
    mergeSort(array, mid+1, e);

    merge(array, s, e);
}

void main()
{
    int array[] = {9, 5, 1, 4, 3};
    int size = sizeof(array) / sizeof(array[0]);

    mergeSort(array, 0, size-1);
    for (int i = 0; i < size; i++) {
    printf("%d ", array[i]);
  }
}*/

/*
#include <stdio.h>

void swap(int *a, int *b) {
  int t = *a;
  *a = *b;
  *b = t;
}

int partition(int array[], int low, int high) {

  int pivot = array[high];
  int i = (low - 1);

  for (int j = low; j < high; j++) {
    if (array[j] <= pivot) {
      i++;
      swap(&array[i], &array[j]);
    }
  }

  swap(&array[i + 1], &array[high]);
  return (i + 1);
}

void quickSort(int array[], int low, int high) {
  if (low < high) {
    int pi = partition(array, low, high);
    quickSort(array, low, pi - 1);
    quickSort(array, pi + 1, high);
  }
}

void printArray(int array[], int size) {
  for (int i = 0; i < size; ++i) {
    printf("%d  ", array[i]);
  }
  printf("\n");
}

// Driver code
int main() {
  int data[] = {8, 7, 2, 1, 0, 9, 6};
  int n = sizeof(data) / sizeof(data[0]);
  quickSort(data, 0, n - 1);
  printf("Sorted array in ascending order: \n");
  printArray(data, n);
}
*/

#include <stdio.h>

  void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
  }

  void heapify(int arr[], int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest])
      largest = left;

    if (right < n && arr[right] > arr[largest])
      largest = right;

    if (largest != i) {
      swap(&arr[i], &arr[largest]);
      heapify(arr, n, largest);
    }
  }

  void heapSort(int arr[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(arr, n, i);

    for (int i = n - 1; i >= 0; i--) {
      swap(&arr[0], &arr[i]);
      heapify(arr, i, 0);
    }
  }

  void printArray(int arr[], int n) {
    for (int i = 0; i < n; ++i)
      printf("%d ", arr[i]);
    printf("\n");
  }

  int main() {
    int arr[] = {1, 12, 9, 5, 6, 10};
    int n = sizeof(arr) / sizeof(arr[0]);

    heapSort(arr, n);

    printf("Sorted array is \n");
    printArray(arr, n);
  }
