#include <stdio.h>

int fact(int n)
{
    if (n <= 1)
    {
        return 1;
    }

    return fact(n - 1) * n; // * time O(n) space O(n)
}

int C(int n, int r) {
    //* n!/r!*(n-r)!
    int a, b, c;
    a = fact(n);
    b = fact(r);
    c = fact(n - r);

    return a / (b * c);
}

int CPascalTriangle(int n, int r) {
    // * nCr = n-1Cr-1 + n-1Cr
    if(r == 0 || n == r) {
        return 1;
    }
    return CPascalTriangle(n - 1, r - 1) + CPascalTriangle(n - 1, r);
}

void main() {
    printf("%d ", C(5, 2));
    printf("%d ", CPascalTriangle(5, 2));
}