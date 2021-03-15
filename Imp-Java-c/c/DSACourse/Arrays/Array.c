#include <stdio.h>
#include <stdlib.h>

void main() {
    int *p, *q;
    p = (int *)malloc(5 * sizeof(int)); // array is declared in heap and only the address is stored in stack as p
    p[0] = 1;
    p[1] = 2;
    p[2] = 3;
    p[3] = 4;
    p[4] = 5;

    for (int i = 0; i < 5; i++) {
        printf("%d \n", p[i]);
    }

    int n;
    scanf("%d", &n);
    int *A;
    A = (int *)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        A[i] = i + 1;
        printf("%d ", A[i]);
    }
}