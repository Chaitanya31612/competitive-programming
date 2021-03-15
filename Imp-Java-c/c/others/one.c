#include <stdio.h>
#include <string.h>

void swap(int *a, int *b);
int fact(int n);
void fibonacci(int n);

void main() {
    // reverse string-==========
    // char str[50], i = 0;
    // gets(str);
    // int count = strlen(str);
    // int begin = 0, end = count - 1;
    // char newstr[50];
    // for (; begin < count; begin++)
    // {
    //     newstr[begin] = str[end];
    //     end--;
    // }
    // newstr[begin] = '\0';
    // printf("%s", newstr);

    // ======swap=========
    // int a = 5;
    // int b = 10;

    // swap(&a, &b);
    // printf("%d, %d", a, b);


    // =====factorial=======
    // int n;
    // scanf("%d", &n);
    // printf("%d", fact(n));

    // =========fibonacci==========
    // printf("0 1 ");
    // fibonacci(8);

    // int arr[] = {5, 4, 5, 4, 3};
    // printf("%d", sizeof(arr)/sizeof(int));
}

void fibonacci(int n) {
    static int n1 = 0, n2 = 1, n3;
    if(n > 0) {
        n3 = n1 + n2;
        n1 = n2;
        n2 = n3;
        printf("%d ", n3);
        fibonacci(n - 1);
    }
}

int fact(int n) {
    if(n == 1) {
        return 1;
    }

    return n * fact(n - 1);
}

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}