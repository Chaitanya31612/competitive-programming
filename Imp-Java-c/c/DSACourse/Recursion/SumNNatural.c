#include <stdio.h>

int sum(int n) {
    if(n == 0) {
        return 0;
    }
    return sum(n - 1) + n; // * Time O(n) Space O(n)
}

int sumIterate(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i;
    }
    return sum; // * Time O(n) Space O(1)
} 

int sumFormula(int n) {
    return n * (n + 1) / 2; // * Time O(1) Space O(1)
}

void main() {
    printf("%d", sum(5));
    printf("\n%d", sumIterate(5));
    printf("\n%d", sumFormula(5));
}