#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    int priority;
    struct node *next;
};

struct node *first = NULL, *rear = NULL;

void insert();
void delete();

void main() {
    int choice;
    printf("1: insert, 2: delete, 3: display");
    scanf("%d", &choice);
    while (choice)
    {
        switch (choice)
        {
        case 1:
            insert();
            break;
        case 2:
            delete();
            break;
        case 3:
            display();
            break;
        default:
            break;
        }

        printf("1: insert, 2: delete, 3: display");
        scanf("%d", &choice);
    }
    
}

