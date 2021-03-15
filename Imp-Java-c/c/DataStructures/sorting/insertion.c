#include <stdio.h>
#include <stdlib.h>

void main() {
	printf("Insertion\n");
	int a[5], temp, j;
	for(int i = 0; i < 5; i++) {
		scanf("%d", &a[i]);
	}

	for(int i = 1; i < 5; i++) {
		temp = a[i];
		j = i - 1;

		while((temp < a[j] && j >= 0)) {
			a[j + 1] = a[j];
			j = j - 1;
		}
		a[j + 1] = temp;
		for (int i = 0; i < 5; ++i)
		{
			printf("%d ", a[i]);
		}
		printf("\n");
	}


	// sorted
	for (int i = 0; i < 5; ++i)
	{
		printf("%d ", a[i]);
	}
}