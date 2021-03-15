#include <stdio.h>

int power(int m, int n) {
    if(n == 0) {
        return 1;
    }
    return power(m, n - 1) * m;
}

int powerImprove(int m, int n) {
    //* if n is even divide the power in half and multiply inside 2^8=(2*2)^4, for odd take one outside 2^9=2*(2*2)^4

    // Base condition
    if(n == 0) {
        return 1;
    }

    // condition
    if(n % 2 == 0) {
        return powerImprove(m * m, n / 2);
    } else {
        return m * powerImprove(m * m, (n - 1) / 2);
    }
}

int powerIterative(int m, int n) {
    int i = 1, ans = 1;
    while(i <= n) {
        ans = ans * m;
        i++;
    }
    return ans;
}

void main() {
    printf("%d", power(2, 5));
    printf("\n%d", powerImprove(2, 10));
    printf("\n%d", powerIterative(2, 10));
}