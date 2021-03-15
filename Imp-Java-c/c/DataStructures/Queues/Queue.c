#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
};

struct node *front = NULL, *rear = NULL;

void enqueue();
void dequeue();
void display();
void peek();

void main() {
    int choice;
    printf("\n0:exit, 1:enqueue, 2:dequeue, 3:display, 4:peek ");
    scanf("%d", &choice);
    do
    {
        switch (choice)
        {
        case 1:
            enqueue();
            break;
        case 2:
            dequeue();
            break;
        case 3:
            display();
            break;
        case 4:
            peek();
            break;
        default:
            break;
        }
        printf("\n0:exit, 1:enqueue, 2:dequeue, 3:display, 4:peek ");
        scanf("%d", &choice);
    } while (choice);
}

void enqueue() {
    struct node *newNode = malloc(sizeof(struct node));
    printf("Enter");
    scanf("%d", &newNode->data);
    newNode->next = NULL;
    if(front == NULL && rear == NULL) {
        front = newNode;
    } else {
        rear->next = newNode;
    }
    rear = newNode;
}

void dequeue() {
    if(front == NULL && rear == NULL) {
        printf("Underflow");
    } else {
        struct node *temp = front;
        front = front->next;
        free(temp);
    }
}

void display()
{
    struct node *temp = front;
    if (front == NULL)
    {
        printf("\nEmpty list");
    }
    else
    {
        while (temp != NULL)
        {
            printf("%d->", temp->data);
            temp = temp->next;
        }
        printf("NULL\n");
    }
}

void peek() {
    if(front == NULL) {
        printf("empty");
    } else {
        printf("%d", front->data);
    }
}