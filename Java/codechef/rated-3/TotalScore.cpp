#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    while (t-- > 0)
    {
        int n, k;
        cin >> n >> k;

        long int A[k];
        for (int i = 0; i < k; ++i)
        {
            cin >> A[i];
        }

        long int ans[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 0;
        }

        for (int i = 0; i < n; i++)
        {
            string s;
            cin >> s;
            long long total = 0;

            for (int j = 0; j < s.size(); j++)
            {
                if (s[j] == '1')
                    ans[i] += A[j];
            }

            cout << ans[i] << endl;
        }
    }
}