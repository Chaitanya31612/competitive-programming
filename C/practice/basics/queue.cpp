#include <iostream>
using namespace std;
#include <queue>

int main(int argc, char const *argv[])
{
    queue<int> q;

    for (int i = 1; i <= 5; i++) {
        q.push(i);
    }

    while(!q.empty()) {
        cout << q.front() << endl;
        q.pop();
    }
}
