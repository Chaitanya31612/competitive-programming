#include <iostream>
using namespace std;
#include <vector>
#define ll long long
#define mod 1000000000

ll k;
vector<ll> b, c;


vector<vector<ll>> multiply(vector<vector<ll>> A, vector<vector<ll>> B) {
    vector<vector<ll>> C(k + 1, vector<ll>(k + 1));

    for (int i = 1; i <= k; i++) {
        for (int j = 1; j <= k; j++) {
            for (int x = 1; x <= k; x++) {
                C[i][j] = (C[i][j] + (A[i][x] * B[x][j]) % mod) % mod;
            }
        }
    }

    return C;
}


vector<vector<ll>> pow(vector<vector<ll>> A, ll p) {
    if(p == 1) {
        return A;
    }

    // p is odd
    if(p&1) {
        return multiply(A, pow(A, p - 1));
    } else {
        vector<vector<ll>> X = pow(A, p / 2);
        return multiply(X, X);
    }
}


ll compute(ll n) {
    // base case
    if(n == 0) {
        return 0;
    }

    // asked from given values
    if(n <= k) {
        return b[n - 1];
    }

    // f1 vector with 1 indexing
    vector<ll> F1(k + 1);
    for (int i = 1; i <= k; i++) {
        F1[i] = b[i - 1];
    }

    // transformation matrix
    vector<vector<ll>> T(k + 1, vector<ll>(k + 1));

    for (int i = 1; i <= k; i++) {
        for (int j = 1; j <= k; j++) {
            // not in last row
            if(i < k) {
                if(j == i + 1) {
                    T[i][j] = 1;
                } else {
                    T[i][j] = 0;
                }
                continue;
            }

            // last row
            T[i][j] = c[k - j];
        }
    }


    // 3. find T^n-1
    T = pow(T, n - 1);

    // 4. multiply T^n-1 with F1 and return first column
    ll ans = 0;
    for (int i = 1; i <= k; i++) {
        ans = (ans + (T[1][i] * F1[i]) % mod) % mod;
    }

    return ans;
}

int main(int argc, char const *argv[])
{
    ll t, num;
    cin >> t;

    while(t--) {
        cin >> k;

        // init vector f1
        for (int i = 1; i <= k; i++) {
            cin >> num;
            b.push_back(num);
        }

        // coefficients vector
        for (int i = 0; i < k; i++) {
            cin >> num;
            c.push_back(num);
        }

        ll n;
        cin >> n;
        cout << compute(n) << endl;

        b.clear();
        c.clear();
    }

    return 0;
}
