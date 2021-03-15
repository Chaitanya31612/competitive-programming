#include <stdio.h>

void main() {
	int a[10]={6,12,0,18,11,99,55,45,34,2};
	int n = 10;
	int temp;

	for(int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; ++j)
		{
			if(a[j] > a[j + 1]) {
				temp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = temp;
			}
		}
	}

	for (int i = 0; i < n; i++)
      printf("%d\t", a[i]);
}