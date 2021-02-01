#include <stdio.h>

void main()
{
    int n, k;
    scanf("%d %d", &n, &k);
    int a[n + 1];

    for (int i = 1; i <= n; i++)
        scanf("%d", &a[i]);

    int ans = 0;

    if (a[k] <= 0)
    {
        ans = 0;
    }
    else
    {
        ans += k;
        int i = k;
        while (a[++i] == a[k] && i <= n)
        {
            ans++;
        }
    }

    printf("%d", ans);
}
