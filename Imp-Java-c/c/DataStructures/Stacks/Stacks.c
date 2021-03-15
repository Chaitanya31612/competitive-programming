#include <stdio.h>
#include <stdlib.h>
#define MAX 6

void push();
void pop();
void display();
int stack[MAX], TOP = -1;

void main() {
    int choice;
    printf("\n0:exit, 1:push, 2:pop, 3:display ");
    scanf("%d", &choice);
    do
    {
        switch (choice)
        {
        case 1:
            push();
            break;
        case 2:
            pop();
            break;
        case 3:
            display();
            break;
        default:
            break;
        }
        printf("\n0:exit, 1:push, 2:pop, 3:display ");
        scanf("%d", &choice);
    } while (choice);
}

void push() {
    if(TOP == MAX) {
        printf("Overflow");
    } else {
        int item;
        printf("Enter data");
        scanf("%d", &item);
        TOP = TOP + 1;
        stack[TOP] = item;
    }
}

void pop() {
    int temp;
    if(TOP < 0) {
        printf("Underflow");
    } else {
        temp = stack[TOP];
        TOP = TOP - 1;
    }
}

void display() {
    int temp = TOP;
    if(TOP == -1)
        printf("NO Data");
    else {
        printf("\nTOP->");
        for (int i = TOP; i >= 0; i--) {
            printf("%d->", stack[i]);
        }
    }
}