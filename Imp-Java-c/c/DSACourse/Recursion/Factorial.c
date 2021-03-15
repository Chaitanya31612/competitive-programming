#include <stdio.h>

int fact(int n) {
    if(n <= 1) {
        return 1;
    }

    return fact(n - 1) * n; // * time O(n) space O(n)
}

int factIterative(int n) {
    int ans = 1;
    for (int i = 1; i <= n; i++) {
        ans = ans * i;
    }
    return ans; // * time O(n) space O(1)
}

void main() {
    printf("%d", fact(5));
    printf("\n%d", factIterative(5));
}