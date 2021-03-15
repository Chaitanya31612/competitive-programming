#include <stdio.h>
#include <stdlib.h>

void main()
{
  int A[10],i , j , n ,temp , flag;
  printf("Enter the number of elements = ");
  scanf("%d",&n);
  printf("Enter the elements = ");
  for(i=0;i<n;i++){
    scanf("%d",&A[i]);
  }

  for(i=0;i<(n-1);i++){
        flag =0;
    for(j=0;j<(n-1-i);j++){
        if(A[j]>A[j+1]){
        temp = A[j];
        A[j] = A[j+1];
        A[j+1] = temp;
        flag=1;
        }
    }
    if(flag==0){
      for(i=0;i<n;i++){
        printf("%d ",A[i]);
      }
    }
  }

}

