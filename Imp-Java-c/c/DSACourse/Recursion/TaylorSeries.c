#include <stdio.h>

// Sin Series
double s(int x, int n) {
    static double P = 1, f = 1;
    double r;

    if(n == 0)
        return x;
    r = s(x, n - 1);
    P = P * (-1 * x * x);
    f = f * (n + 1) * (n + 2);
    return r + P / f;
}

// Exponential series
double e(int x, int n) {
    // * time O(n2)
    // for number of multiplications 1(0) + x/1(0) + x2/2(2) + x3/3!(4) ... 2 + 4 + 6 + ....
    static double P = 1, f = 1;
    double r;

    if(n == 0) {
        return 1;
    } 
    r = e(x, n - 1);
    P = P * x;
    f = f * n;
    return r + P / f;
}

double eHorner(double x, double n) {
    // * time O(n)
    // for number of multiplications 1 + x/1 [ 1 + x/2 [ 1 + x/3 [ 1 + x/4 ] ] ] -- for n = 4 multiplications = 4 i.e (n)

    static double s;

    if(n == 0) {
        return s;
    }
    s = 1 + (x / n) * s;
    return eHorner(x, n - 1);
}

double eHornerIterative(double x, double n) {
    // * time O(n)
    // for number of multiplications 1 + x/1 [ 1 + x/2 [ 1 + x/3 [ 1 + x/4 ] ] ] -- for n = 4 multiplications = 4 i.e (n)
    double s = 1;
    for (; n > 0; n--) {
        s = 1 + (x / n) * s;
    }
    return s;
}

void main() {
    printf("%lf ", s(1, 4));
    printf("%lf ", e(2, 10));
    printf("%lf ", eHorner(2, 10));
    printf("%lf ", eHornerIterative(2, 10));
}