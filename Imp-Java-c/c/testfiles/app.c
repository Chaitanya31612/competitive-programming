#include <stdio.h>

int main(void) {
	// your code goes here
	int T;
	scanf("%d",&T);

	while(T--)
	{
	    int N;
	    scanf("%d",&N);
	    int A[N];
	    for(int i=0;i<N;i++)
	    scanf("%d",&A[i]);

	    int j=0, D[20];

	    for(int i=0;i<20;i++)
	    D[i] = 0;

	    int c=0;
	    for(int i=0;i<N;i++)
	    {
	        if(A[i] == 1)
	        {
	           D[j]=i;
	           j++;
	           c++;
	        }
	    }
	   // for(int i=0;i<sizeof(D)/4;i++)
	   // printf("%d\n",D[i]);
	   int count=0;
	   for(int i=0;i<20;i++)
	   {
	       if(i != 19)
	       {
            if(D[i+1]-D[i] == 6)
            count++;
	       }
	   }
	   //printf("%d %d",count,c);
	   if(count == c-1)
	   printf("YES\n");
	   else
	   printf("NO\n");
	}
	return 0;
}

