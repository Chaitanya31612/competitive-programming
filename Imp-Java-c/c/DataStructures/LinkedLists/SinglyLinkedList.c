#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
};

struct node *start;
int count = 0;

void insert_begin(int data);
void insert_end(int data);
void printList();
int getCount();
void insert_pos();

void main() {
    int data, choice;
    while(choice) {
        scanf("%d", &data);
        insert_begin(data);
        // struct node *newNode, *temp;
        // newNode = (struct node *)malloc(sizeof(struct node));
        // newNode->data = data;
        // newNode->next = NULL;
        // if(start == NULL) {
        //     start = temp = newNode;
        // } else {
        //     temp->next = newNode;
        //     temp = newNode;
        // }
        count++;
        printf("Continue? 0, 1 = ");
        scanf("%d", &choice);
    }
    printList();

    // insert_pos();
}

void insert_begin(int data) {
    struct node *newNode;
    newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = data;
    count++;
    if(start == NULL) {
        start = newNode;
        start->next = NULL;
        return;
    }
    newNode->next = start;
    start = newNode;
}

void insert_end(int data) {
    // struct node *newNode, *temp;
    // newNode = (struct node *)malloc(sizeof(struct node));
    // newNode->data = data;
    // newNode->next = NULL;
    // if(start == NULL) {
    //     start = temp = newNode;
    // } else {
    //     temp->next = newNode;
    //     temp = newNode;
    // }
    struct node *newNode, *temp;
    newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = data;
    newNode->next = NULL;
    temp = start;
    if (start == NULL)
    {
        start = newNode;
    }
     else {
        while (temp != NULL)
        {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

void insert_pos() {
    // inserting after a given position, pos is 1 for 1st node
    struct node *newData, *temp;
    int pos, item;
    printf("\nEnter the position");
    scanf("%d", &pos);
    if (pos > count)
    {
        printf("Invalid position, count %d", count);
    }
    else
    {
        temp = start;
        printf("hello %d", temp);
        for (int i = 1; i < pos; i++)
        {
            temp = temp->next;
        }
        printf("hello2nd %d", temp);
        printList();
        scanf("%d", &item);
        newData->data = item;
        printList();
        printf("%d", item);
        newData->next = temp->next;
        printList();
        temp->next = newData;
        printf("Hello");
        printList();
    }
}

void printList() {
    struct node *temp;
    temp = start;
    printf("HEAD-> ");
    while(temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL");
}

int getCount() {
    return count;
}