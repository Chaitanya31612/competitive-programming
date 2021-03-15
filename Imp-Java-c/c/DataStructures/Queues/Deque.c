#include <stdio.h>
#include <stdlib.h>

#define N 5
int deque[N];
int front = -1, rear = -1;

void enqueueFront();
void enqueueRear();
void dequeueFront();
void dequeueRear();
void peek();
void display();

void main() {
    int choice;
    printf("\n0:exit, 1:enqueueFront, 2: enqueueRear 3:dequeue, 4: dequeueRear 5:display, 6:peek ");
    scanf("%d", &choice);
    do
    {
        switch (choice)
        {
        case 1:
            enqueueFront();
            break;
        case 2:
            enqueueRear();
            break;
        case 3:
            dequeueFront();
            break;
        case 4:
            dequeueRear();
            break;
        case 5:
            display();
            break;
        case 6:
            peek();
            break;
        default:
            break;
        }
        printf("\n0:exit, 1:enqueueFront, 2: enqueueRear 3:dequeue, 4: dequeueRear 5:display, 6:peek ");
        scanf("%d", &choice);
    } while (choice);
}

void enqueueFront() {
    int data;
    printf("enter ");
    scanf("%d", &data);
    if((front == 0 && rear == N-1) || front == rear + 1) {
        printf("Overflow");
    } else if (front == -1 && rear == -1) {
        front = rear = 0;
        deque[front] = data;
    } else if (front == 0) {
        front = N - 1;
        deque[front] = data;
    } else {
        front = front - 1;
        deque[front] = data;
    }

}

void enqueueRear() {
    int data;
    printf("enter ");
    scanf("%d", &data);
    if ((front == 0 && rear == N - 1) || front == rear + 1)
    {
        printf("Overflow");
    }
    else if (front == -1 && rear == -1)
    {
        front = rear = 0;
        deque[rear] = data;
    } else if (rear == N - 1) {
        rear = 0;
        deque[rear] = data;
    } else {
        rear = rear + 1;
        deque[rear] = data;
    }
}

void dequeueFront() {
    if (front == -1 && rear == -1)
    {
        printf("Underflow");
    } else if (front == rear) {
        front = rear = -1;
    } else if (front == N - 1) {
        front = 0;
    } else {
        front++;
    }
    
}

void dequeueRear() {
    if (front == -1 && rear == -1)
    {
        printf("Underflow");
    }
    else if (front == rear)
    {
        front = rear = -1;
    }
    else if (rear == 0)
    {
        rear = N - 1;
    }
    else
    {
        rear--;
    }
}

void display()
{
    if (front == -1 && rear == -1)
        printf("Underflow");
    else
    {
        int i = front;
        while (i != rear)
        {
            printf("%d", deque[i]);
            i = (i + 1) % N;
        }
        printf("%d", deque[rear]);
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
        printf("%d", deque[front]);
    }
}