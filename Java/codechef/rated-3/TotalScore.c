#include <stdio.h>


int main()
{
    int t;
    scanf("%d", &t);
    while(t-- > 0) {
        int n, k;
        scanf("%d %d\n", &n, &k);
        long int A[k];
        for (int i = 0; i < k; i++) {
            scanf("%d", &A[i]);
        }
        
        // int ans[n];
        // for (int i = 0; i < n; i++)
        // {
        //     ans[i] = 0;
        // }
        // scanf("");
        for (int i = 0; i < n; i++) {
            char S[k];
            scanf("%s", &S);
            // printf("%s\n", S);
            // printf("i = %d, k = %d, S = %s", i, k, S);
            long long tot = 0;
            for (int j = 0; j < k; j++) {
                // int c = charToInt(S[j]);
                if(S[j] == '1') {
                    // ans[i] += A[j];
                    tot += A[j];
                }
            }
            printf("%d\n", tot);
            // printf("%d\n", ans[i]);
        }
        // for (int i = 0; i < n; i++) {
        //     printf("%d\n", ans[i]);
        // }
    }

    return 0;
}
