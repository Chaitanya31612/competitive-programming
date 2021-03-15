#include <stdio.h>
#include <stdlib.h>

void main() {
    // int a = 5;
    // int *p = &a;
    // printf("%u", p);
    // printf("\n%d", *p);

    int a[] = {6, 1, 4, 3, 4};
    int *q = a;
    int b[5];
    int *p = b;
    for (int i = 0; i < 5; i++) {
        printf("%d", *(q + i));
    }
    printf("\n%d\n%d", a[2], 2 [a]);
    printf("\n%u", a + 1);
    printf("\n%u", &a + 1);
    printf("\n%u", &a[0] + 1);
    for (int i = 0; i < 5; i++)
    {
        scanf("%d", &(p[i]));
    }
    for (int i = 0; i < 5; i++)
    {
        printf("%d", *(b + i));
    }
}