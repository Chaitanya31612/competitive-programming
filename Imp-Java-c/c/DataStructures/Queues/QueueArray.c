#include <stdio.h>
#include <stdlib.h>
#define N 5
int queue[N];
int front = -1, rear = -1;

void enqueue();
void dequeue();
void peek();
void display();

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
    int x;
    printf("Enter");
    scanf("%d", &x);
    if(rear == N - 1) {
        printf("Overflow");
    } else if (front == -1 && rear == -1) {
        front = rear = 0;
    } else {
        rear = rear + 1;
    }

    queue[rear] = x;
}

void dequeue() {
    if(front == -1) {
        printf("Underflow");
    } else if(front == rear) {
        front = rear = -1;
    } else {
        front = front + 1;
    }
}

void peek() {
    if(front == -1) {
        printf("Underflow");
    } else {
        printf("%d", queue[front]);
    }
}

void display() {
    if(front == -1) {
        printf("Underflow");
    } else {
        for (int i = front; i <= rear; i++)
        {
            printf("%d,", queue[i]);
        }
        
    }
}