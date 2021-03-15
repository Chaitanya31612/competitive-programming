#include <stdio.h>
#include <stdlib.h>

struct Array {
    int *A;
    int size; // max size
    int length; // no of element present
};

void Display(struct Array arr) {
    printf("\nElements are\n");
    // for (int i = 0; i < arr.length; i++)
    //     printf("%d ", arr.A[i]);
}

void main() {
    struct Array arr;
    printf("Enter the size of array ");
    scanf("%d", &arr.size);

    printf("Enter length ");
    scanf("%d", &arr.length);

    int n;
    printf("Enter the elements\n");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d\n", &arr.A[i]);
    }
    arr.length = n;

    Display(arr);
}