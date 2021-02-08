#include <stdio.h>

void main() {
    int t;
    scanf("%d", &t);
    while(t-- > 0) {
        int n, k;
        scanf("%d%d", &n, &k);

        int h[n];
        for (int i = 0; i < n; i++) {
            scanf("%d", &h[i]);
        }

        int ans = 0;
        if (n == 1)
        {
            ans = -1;
        }
        else
        {
            int i = 0;
            while (k > 0)
            {
                i = 0;
                while (i < n - 1)
                {
                    if (h[i] >= h[i + 1])
                    {
                        i++;
                    }
                    else
                    {
                        h[i] = h[i] + 1;
                        k--;
                        break;
                    }
                }
                if (i == n - 1)
                {
                    ans = -1;
                    break;
                }
            }

            if (ans != -1)
            {
                ans = i + 1;
            }
        }

        printf("%d\n", ans);
}
}