#include <stdio.h>
#include <stdlib.h>

#define N 5
int queue[N];
int front = -1, rear = -1;

void enqueue();
void dequeue();
void peek();
void display();

void main()
{
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
    int data;
    printf("Enter ");
    scanf("%d", &data);
    if(front == -1 && rear == -1) {
        front = rear = 0;
        queue[rear] = data;
    } else if ((rear + 1) % N == front) {
        printf("Overflow");
    } else {
        rear = (rear + 1) % N;
        queue[rear] = data;
    }
}

void dequeue() {
    if(front == -1 && rear == -1)
        printf("Underflow");
    else if(front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % N;
    }
}

void display() {
    if (front == -1 && rear == -1)
        printf("Underflow");
    else {
        int i = front;
        while (i != rear) {
            printf("%d", queue[i]);
            i = (i + 1) % N;
        }
        printf("%d", queue[rear]);
    }
}

void peek()
{
    if (front == -1 && rear == -1)
    {
        printf("Underflow");
    }
    else
    {
        printf("%d", queue[front]);
    }
}