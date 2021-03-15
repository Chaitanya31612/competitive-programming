#include <stdio.h>
#include <stdlib.h>

int fun(int n) {
    static int x = 0;
    if(n > 0) {
        // return fun(n - 1) + n; // *first problem
        x++;
        return fun(n - 1) + x; // in this case the final value of x will be added as it will be done at returning time
    }
    return 0;
}

void main() {
    int r;
   
    r = fun(5);
    printf("%d", r);
}