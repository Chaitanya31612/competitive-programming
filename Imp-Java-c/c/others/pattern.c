#include <stdio.h>

void main() {
    // int k = 1;
    // for (int i = 0; i < 4; i++) {
    //     for (int j = 0; j <= i; j++) {
    //         printf("%d ", k);
    //         k++;
    //     }
    //     printf("\n");
    // }


    // for (int i = 1; i <= 4; i++)
    // {
    //     for (int j = 1; j <= i; j++)
    //     {
    //         printf("%d ", j);
    //     }
    //     printf("\n");
    // }

    // int k = 1;
    // for (int i = 0; i < 4; i++)
    // {
    //     for (int j = 0; j <= i; j++)
    //     {
    //         printf("%d ", k);
    //     }
    //     printf("\n");
    //     k++;
    // }

    // int  k = 1;
    // for (int i = 0; i <= 4; i++)
    // {
    //     for (int j = 0; j <= i; j++)
    //     {
    //         printf("* ");
    //     }
    //     printf("\n");
    // }

    int k = 1;

    for (int i = 0; i < 5; i++){
        for (int k = 0; k < (5 - i); k++) {
            printf(" ");
        } 

            for (int j = 0; j <= i; j++)
            {
                printf("* ");
            }
        printf("\n");


    }
}