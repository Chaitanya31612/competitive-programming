#include <iostream>
#include <algorithm>
using namespace std;


bool compare(int a, int b) {
    return a > b;
}

int main() {
    int n, key;
    cin >> n >> key;

    int a[n];
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        a[i] = x;
    }

    // sort(a, a + n, compare);
    sort(a, a + n);

    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }

    cout << endl;
    // to find occurence in sorted array
    // upper gives greater index
    int upper = upper_bound(a, a + n, key) - a;
    int lower = lower_bound(a, a + n, key) - a;

    cout << "Number of occurences " << upper - lower;
}