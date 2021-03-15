#include <stdio.h>
#include <stdlib.h>

void main() {
    // ------------compile time ================
    // int a[5] = {1, 2, 3, 4, 5};
    // for (int i = 0; i < 5; i++) {
    //     printf("%d", a[i]);
    // }
    // printf("\n");

    // --------------run time--------------------
    // int b[5];
    // for (int j = 0; j < 5; j++)
    // {
    //     printf("Enter item: ");
    //     scanf("%d", &b[j]);
    //     printf("%d\n", b[j]);
    // }

    // -------------insertion algorithm-------------
    // int a[10], size, num, pos;
    // printf("Enter the size");
    // scanf("%d", &size);
    // if(size > 10) {
    //     printf("Overflow");
    //     exit(1);
    // } else {
    //     for (int i = 0; i < size; i++)
    //     {
    //         scanf("%d", &a[i]);
    //     }
    //     scanf("%d %d", &num, &pos);
    //     for (int i = size-1; i >= pos; i--)
    //     {
    //         a[i + 1] = a[i];
    //     }
    //     a[pos] = num;
    //     size++;
    //     for (int i = 0; i < size; i++)
    //     {
    //         printf("%d\n", a[i]);
    //     }
    // }

    // ----------deletion----------------
    int a[10], size, num, pos;
    printf("Enter the size");
    scanf("%d", &size);
    if (size > 10)
    {
        printf("Overflow");
        exit(1);
    }
    else
    {
        for (int i = 0; i < size; i++)
        {
            scanf("%d", &a[i]);
        }
        scanf("%d", &pos);
        for (int i = pos; i < size; i++)
        {
            a[i] = a[i + 1];
        }
        size--;
        for (int i = 0; i < size; i++)
        {
            printf("%d\n", a[i]);
        }
    }
}