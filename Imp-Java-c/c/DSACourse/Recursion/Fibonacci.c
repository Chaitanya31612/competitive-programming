#include <stdio.h>

int F[10]; // array for memoization technique which is storing known value and time is n + 1 i.e O(n)

int fibIterative(int n) {
    // * time O(n)
    int a = 0, b = 1, s, i;
    if(n <= 1)
        return n;

    for (i = 2; i <= n; i++) {
        s = a + b;
        a = b;
        b = s;
    }
    return s;
}

int fib(int n) {
    // * time O(2^n) 
    if(n <= 1)
        return n;
    return fib(n - 2) + fib(n - 1);
}

int fibMemoization(int n) {
    if(n <= 1) {
        F[n] = n;
        return F[n];
    }

    if(F[n - 2] == -1)
        F[n - 2] = fibMemoization(n - 2);
    if(F[n - 1] == -1)
        F[n - 1] = fibMemoization(n - 1);

    F[n] = F[n - 2] + F[n - 1];
    
    return F[n - 2] + F[n - 1];
}



void main() {
    printf("%d", fib(7));
    printf("\n%d", fibIterative(7));

    for (int i = 0; i < 10; i++)
        F[i] = -1; // because 0 is a fibonacci term

    printf("\n%d", fibMemoization(5));
}