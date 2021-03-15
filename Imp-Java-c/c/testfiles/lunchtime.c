#include <stdio.h>

char *binbin(int n)
{
     static char bin[9];
     int x;
     for(x=0;x<8;x++)
     {
     bin[x] = n & 0x80 ? '1' : '0';
     n <<= 1;
     }
     bin[x] = NULL;
     return(bin);
}

int main(void) {
	// your code goes here
	int T;
	scanf("%d\n",&T);

	while(T--)
	{
	    long int N , Q;
	    int even=0 , odd=0 , count=0;
	    char *b;
	    scanf("%ld%ld",&N,&Q);
	    long int A[N] , B[N] , P[Q];

	    for(int i=0;i<N;i++)
	    scanf("%ld",&A[i]);

	    for(int i=0;i<Q;i++)
	    scanf("%ld",&P[i]);

	    for(int i=0;i<Q;i++)
	    {
	        for(int j=0;j<N;j++)
	        {
	            B[j] = P[i] ^ A[j];
	        }
	       for(int k=0;k<N;k++)
	       {
	           b=binbin(B[k]);
	           for(int a=0;a<8;a++)
	           {
	               if(*(b+a)=='1')
	               count++;
	           }
	           //printf("%d ",count);
	           if(count%2==0)
                even++;
               else
                odd++;

                count=0;
	       }
	       printf("\n%d %d",even,odd);
           even=0;
           odd=0;
	}
	}
	return 0;
}

