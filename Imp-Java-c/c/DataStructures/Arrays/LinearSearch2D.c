#include <stdio.h>

void main()
{
    int i, j, item, loc = 0, loc1 = 0;
    int a[2][2];
    printf("\n\tThis Program is Used To seaech an element in 2Dimensional Array using Linear Search\n");
    printf("\n\tEneter The Value Of Array:");
    for (i = 1; i <= 2; i++)
    {
        for (j = 1; j <= 2; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    printf("\n\tEneter The Value To Be Serched:");
    scanf("%d", &item);
    for (i = 1; i <= 2; i++)
    {
        for (j = 1; j <= 2; j++)
        {
            if (item == a[i][j])
            {
                loc = i;
                loc1 = j;
                break;
            }
        }
    }
    printf("\n\tThe Item is at %d Row And %d Coloumn.", loc, loc1);
    printf("\n\n\t\tSearch Completed.");
}
