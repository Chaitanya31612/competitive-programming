#include <iostream>
using namespace std;
#include <cstring>
#include <algorithm>

bool compare(string a, string b) {
    return a.length() > b.length();
}

int main() {
    string s1 = "Hello";
    cout << s1 << endl;

    // string s2;
    // getline(cin, s2);
    // cout << s2;

    string arr[] = {"Apple", "Bananaaaaa", "Mango", "Guava"};

    // this will sort lexiographically
    // sort(arr, arr + 4);

    // for sorting according to length
    sort(arr, arr + 4, compare);

    for (int i = 0; i < 4; i++) {
        cout << arr[i] << ", ";
    }
}