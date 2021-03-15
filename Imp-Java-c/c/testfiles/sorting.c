#include <stdio.h>

int main(void) {
	// your code goes here
	int T;
	scanf("%d\n",&T);

	while(T--)
	{
	    int N , M , m=0;
	    scanf("%d%d\n",&N,&M);
	    int F[N] , P[N] , S[N];

	    for(int i=0;i<N;i++)
	    scanf("%d",&F[i]);

	    for(int i=0;i<N;i++)
	    scanf("%d",&P[i]);

	   // for(int i=0;i<N;i++)
	   // {
	   //     for(int j=i+1;j<N;j++)
	   //     {
	   //         if(F[i]>F[j])
	   //         {
	   //             int temp , temp2;
	   //             temp = F[i];
	   //             F[i] = F[j];
	   //             F[j] = temp;
	   //             temp2 = P[i];
	   //             P[i] = P[j];
	   //             P[j] = temp2;
	   //         }
	   //     }
	   // }

// 	    for(int i=0;i<N;i++)
// 	{
// 	    printf("%d ",F[i]);

// 	}
// 	printf("\n");
// 	    for(int i=0;i<N;i++)
// 	{
// 	    printf("%d ",P[i]);

// 	}
// 	printf("\n");

	int sum1=0 , sum2=0 , sum3=0 , sum4=0;

	for(int i=0;i<N;i++)
	{
	    if(F[i]==1)
	    sum1+=P[i];

	    else if(F[i]==2)
	    sum2+=P[i];

	    else if(F[i]==3)
	    sum3+=P[i];

	    else if(F[i]==4)
	    sum4+=P[i];
	}
	int Sums[50] = {sum1,sum2,sum3,sum4};
// 	Sums[0] = sum1;
// 	Sums[1] = sum2;
// 	Sums[2] = sum3;
	int min= Sums[0];
    for(int i=1;i<M;i++)
    {
        if(min>Sums[i] && Sums[i]!=0)
        min=Sums[i];
    }
    printf("%d\n",min);


// 	printf("%d %d %d\n",sum1,sum2,sum3);
// 	if(sum1<sum2)
// 	{
// 	   if(sum1!=0)
// 	    printf("%d\n",sum1);
// 	    else
// 	    printf("%d\n",sum2);
// 	}

// 	else if(sum2<sum1)
// 	{
// 	    if(sum2!=0)
// 	    printf("%d\n",sum2);
// 	    else
// 	    printf("%d\n",sum1);
// 	}

	   // for(int i=0;i<N;i++)
	   // {
	   //     int sum=P[i];
	   //     for(int j=i+1;j<N;j++)
	   //     {
	   //        // int c;
	   //         for(int k=0;k<i;k++)
	   //         {

    // 	            if(F[i+1]==F[k])
    // 	            {
    // 	                sum = S[k];
    // 	               // c = k;
    // 	                break;
    // 	            }
	   //         }
	   //        // printf("%d\n",c);
    // 	            if(F[i] == F[j])
    // 	            {
    // 	                sum += P[j];
    // 	            }

	   //     }
	   //     S[m] = sum ;
	   //    // if(m<M)
	   //     m++;

	   // }
	   // for(int i=0;i<N;i++)
	   // printf("%d ",S[i]);

	   // int min= S[0];
	   // for(int i=1;i<N;i++)
	   // {
	   //     if(min>S[i] && S[i]!=0)
	   //     min=S[i];
	   // }
	   // printf("%d\n",min);
	}
	return 0;
}

