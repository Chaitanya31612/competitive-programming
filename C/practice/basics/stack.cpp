#include <iostream>
using namespace std;
#include <stack>
#include <cstring>

int main() {
    stack<string> s;

    s.push("Apple");
    s.push("Mango");
    s.push("Pineapple");

    while(!s.empty()) {
        cout << s.top() << endl;
        s.pop();
    }
}