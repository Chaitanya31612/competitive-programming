#include <iostream>
#include <vector>
using namespace std;

#define double long double
#define P pair<long long int, long long int>
#define pb push_back
#define FOR(i, a, b, x) for (int i = (a); i < (b); i += (x))



int getParent(int node, int *parent) {
    if(parent[node] == node) {
        return node;
    }

    return parent[node] = getParent(parent[node], parent);
}

int main()
{
    int n, q;

    cin >> n >> q;

    vector<vector<int>> queries;
    int parent[n + 2];
    int color[n] = {};

    // initializing the parent of node till n + 1
    for (int i = 0; i < n + 2; i++) {
        parent[i] = i;
    }

    for (int i = 0; i < q; i++) {
        int l, r, c;
        cin >> l >> r >> c;
        vector<int> temp;
        temp.push_back(l);
        temp.push_back(r);
        temp.push_back(c);

        queries.push_back(temp);
    }

    for (int i = q - 1; i >= 0; i--) {
        int l = queries[i][0];
        int r = queries[i][1];
        int c = queries[i][2];

        for (int j = getParent(l, parent); j <= r; j = getParent(j, parent)) {
            color[j] = c;
            parent[j] = getParent(j + 1, parent);
        }
    }

    for (int i = 1; i <= n; i++) {
        cout << color[i] << endl;
    }

    return 0;
}