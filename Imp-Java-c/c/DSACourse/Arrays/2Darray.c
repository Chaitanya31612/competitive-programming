#include <stdio.h>
#include <stdlib.h>

void main() {
    int *B[3];

    B[0] = (int *)malloc(4 * sizeof(int));
    B[1] = (int *)malloc(4 * sizeof(int));
    B[2] = (int *)malloc(4 * sizeof(int));

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++)
            printf("%d ", B[i]);
        printf("\n");
    }
    printf("\n");

    int **C;
    C = (int **)malloc(3 * sizeof(int *));
    C[0] = (int *)malloc(4 * sizeof(int));
    C[1] = (int *)malloc(4 * sizeof(int));
    C[2] = (int *)malloc(4 * sizeof(int));

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 4; j++)
            printf("%d ", C[i]);
        printf("\n");
    }
}