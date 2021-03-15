#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
    struct node *prev;
};

struct node *head = NULL, *last = NULL;
int size=0;

void insert_end();
void insert_begin();
void insert_pos();
void display();
void delete_beg();
void delete_end();
void delete_pos();
void reverse();
void insertAtPos();
void insertAfterPos();

void main() {
    int choice;
    printf("\n0: exit, 1: end, 2: begin, 3: pos, 4: display, 5: delete_beg, 6:delete_end, 7:delete_pos, 8: reverse\n");
    scanf("%d", &choice);
    while (choice)
    {
        switch (choice)
        {
        case 1:
            insert_end();
            break;
        case 2:
            insert_begin();
            break;
        case 3:
            insert_pos();
            break;
        case 4:
            display();
            break;
        case 5:
            delete_beg();
            break;
        case 6:
            delete_end();
            break;
        case 7:
            delete_pos();
            break;
        case 8:
            reverse();
            break;
        default:
            break;
        }
        printf("\n0: exit, 1: end, 2: begin, 3: pos, 4: display, 5: delete_beg, 6:delete_end, 7:delete_pos, 8: reverse\n");
        scanf("%d", &choice);
    }
}

void insert_end() {
    struct node *newNode;
    newNode = (struct node *)malloc(sizeof(struct node));
    printf("\nEnter data");
    scanf("%d", &newNode->data);
    newNode->prev = NULL;
    newNode->next = NULL;
    if(head == NULL) {
        head = newNode;
    } else {
        last->next = newNode;
        newNode->prev = last;
    }
    last = newNode;
    size++;
}

void insert_begin() {
    struct node *newNode;
    newNode = (struct node *)malloc(sizeof(struct node));
    printf("\nEnter data");
    scanf("%d", &newNode->data);
    newNode->prev = NULL;
    if(head == NULL) {
        head = newNode;
        newNode->next = NULL;
    } else {
        head->prev = newNode;
        newNode->next = head;
        head = newNode;
    }
    size++;
}

void insert_pos() {
    int choice;
    printf("1: at, 2: after");
    scanf("%d", &choice);
    switch (choice)
    {
    case 1:
        insertAtPos();
        break;

    case 2:
        insertAfterPos();
        break;

    default:
        break;
    }
}

void insertAtPos() {
    printf("Enter pos");
    int pos, i = 1;
    scanf("%d", &pos);
    if(pos < 1 || pos > size) {
        printf("invalid pos");
    } else if (pos == 1) {
        insert_begin();
    } else {
        struct node *newNode, *temp = head;
        newNode = (struct node *)malloc(sizeof(struct node));
        printf("Enter pos data");
        scanf("%d", &newNode->data);
        while (i < pos - 1)
        {
            temp = temp->next;
            i++;
        }
        newNode->next = temp->next;
        newNode->prev = temp;
        temp->next = newNode;
        newNode->next->prev = newNode;
    }
}

void insertAfterPos() {
    printf("Enter pos");
    int pos, i = 1;
    scanf("%d", &pos);
    if (pos < 1 || pos > size)
    {
        printf("invalid pos");
    }
    else
    {
        struct node *newNode, *temp = head;
        newNode = (struct node *)malloc(sizeof(struct node));
        printf("Enter pos data");
        scanf("%d", &newNode->data);
        while (i < pos)
        {
            temp = temp->next;
            i++;
        }
        newNode->next = temp->next;
        newNode->prev = temp;
        temp->next = newNode;
        newNode->next->prev = newNode;
    }
}

void delete_beg() {
    struct node *temp;
    if(head == NULL) {
        printf("Link is empty");
    } else {
        temp = head;
        head = head->next;
        head->prev = NULL;
        free(temp);
    }
}

void delete_end() {
    struct node *temp;
    if(last == NULL) {
        printf("Link is empty");
    } else {
        last->prev->next = NULL;
        temp = last;
        last = last->prev;
        free(temp);
    }
}

void delete_pos() {
    struct node *temp = head;
    int pos, i = 1;
    printf("enter pos");
    scanf("%d", &pos);
    while(i < pos) {
        temp = temp->next;
        i++;
    }
    temp->prev->next = temp->next;
    temp->next->prev = temp->prev;
    free(temp);
}

void reverse() {
    struct node *currentNode, *nextNode;
    currentNode = head;
    while (currentNode != NULL)
    {
        nextNode = currentNode->next;
        currentNode->next = currentNode->prev;
        currentNode->prev = nextNode;
        currentNode = nextNode;
    }
    currentNode = head;
    head = last;
    last = head;
}

void display()
{
    struct node *temp = head;
    if (head == NULL)
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