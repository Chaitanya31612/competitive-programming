#include <stdio.h>
#include <stdlib.h>

void ReadFile();
void WriteFile();

void main() {
    // ReadFile();
    WriteFile();
}

void WriteFile() {
    int num;
    FILE *fptr;
    fptr = fopen("new.txt", "a");
    for (int i = 0; i < 10; i++)
    {
        fprintf(fptr, "%d", i);
    }
    fclose(fptr);
}

void ReadFile() {
    int num;
    FILE *fptr;

    if((fptr = fopen("new.txt", "r")) == NULL) {
        printf("Error");
        exit(1);
    }

    fscanf(fptr, "%d", &num);
    printf("%d", num);
    fclose(fptr);
}