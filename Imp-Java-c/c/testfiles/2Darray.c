#include <stdio.h>
#include <stdlib.h>

void print(int);
void main()
{
    int A[2][2] = {1,2,4,6};
    int B[2][2] = {4,5,8,9};
    int arr[3] = {1,2,3};
    print(arr);
    /*for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            printf("%d ",A[i][j] + B[i][j]);
        }
        printf("\n");
    }*/

}
print(int *array)
{
    for(int i=0;i<3;i++){
        printf("%d\n",*(array+i));
    }
}
