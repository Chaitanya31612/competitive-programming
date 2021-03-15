#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *tail = NULL;
int size = 0;

void createCLL();
void displayCLL();
void insert_beg();
void insert_end();
void insert_pos();
void del_beg();
void del_end();
void del_pos();
void reverse();

void main() {
    int choice;
    printf("1:create, 2:display, 3: insert beg, 4: insert_end, 5:insertpos, 6:delbeg, 7:delend, 8:delpos, 9: reverse");
    scanf("%d", &choice);
    while(choice) {
        switch (choice)
        {
        case 1:
            createCLL();
            break;
        case 2:
            displayCLL();
            break;
        case 3:
            insert_beg();
            break;
        case 4:
            insert_end();
            break;
        case 5:
            insert_pos();
            break;
        case 6:
            del_beg();
            break;
        case 7:
            del_end();
            break;
        case 8:
            del_pos();
            break;
        case 9:
            reverse();
            break;
        default:
            break;
        }
        printf("1:create, 2:display, 3: insert beg, 4: insert_end, 5:insertpos, 6:delbeg, 7:delend, 8:delpos, 9: reverse");
        scanf("%d", &choice);
    }
}

// void createCLL() {
//     struct node *newNode = malloc(sizeof(struct node));
//     printf("enter the data");
//     scanf("%d", &newNode->data);
//     if(head == NULL) {
//         head = tail = newNode;
//     } else {
//         tail->next = newNode;
//         tail = newNode;
//     }
//     tail->next = head;
// }

// * circular linked list with only tail pointer

void createCLL() 
{
    struct node *newNode = malloc(sizeof(struct node));
    printf("enter the data");
    scanf("%d", &newNode->data);
    if (tail == NULL)
    {
        tail = newNode;
        tail->next = newNode;

    }
    else
    {
        newNode->next = tail->next;
        tail->next = newNode;
        tail = newNode;
    }
    size++;
}

void displayCLL() {
    struct node *temp;
    if(tail == NULL)
        printf("Underflow");
    else {
        temp = tail->next;
        while(temp->next != tail->next) {
            printf("%d->", temp->data);
            temp = temp->next;
        }
        printf("%d\n", temp->data);
    }
}

void insert_beg() {
    struct node *newNode = malloc(sizeof(struct node));
    printf("Enter data");
    scanf("%d", &newNode->data);
    if(tail == NULL) {
        tail = newNode;
        tail->next = newNode;
    } else {
        newNode->next = tail->next;
        tail->next = newNode;
    }
    size++;
}

void insert_end()
{
    struct node *newNode = malloc(sizeof(struct node));
    printf("Enter data");
    scanf("%d", &newNode->data);
    if (tail == NULL)
    {
        tail = newNode;
        tail->next = newNode;
    }
    else
    {
        newNode->next = tail->next;
        tail->next = newNode;
        tail = newNode;
    }
    size++;
}

void insert_pos() {
    struct node *newNode, *temp;
    int pos, i = 1;
    printf("Enter pos");
    scanf("%d", &pos);
    if(pos < 0 || pos > size) {
        printf("Invalid");
    } else if (pos == 1) {
        insert_beg();
    } else {
        newNode = (struct node *)malloc(sizeof(struct node));
        printf("Enter data");
        scanf("%d", &newNode->data);
        temp = tail->next;
        while(i < pos-1) { // * given position is starting from 1
            temp = temp->next;
            i++;
        }
        newNode->next = temp->next;
        temp->next = newNode;
    }
    size++;
}

void del_beg() {
    struct node *temp;
    if(tail == NULL)
        printf("Underflow");
    else if (tail->next == tail)
    {
        temp = tail;
        tail == NULL;
        free(temp);
    }
    
    else {
        temp = tail->next;
        tail->next = temp->next;
        free(temp);
    }
    size--;
}

void del_end() {
    struct node *current, *previous;
    current = tail->next;
    if(tail == NULL) {
        printf("Underflow");
    } else if (current->next == current) {
        free(current);
        tail = NULL;
    } else {
        while(current->next != tail->next) {
            previous = current;
            current = current->next;
        }
        previous->next = tail->next;
        tail = previous;
        free(current);
    }
    size--;
}

void del_pos() {
    int pos, i = 1;
    printf("enter pos");
    scanf("%d", &pos);
    if (pos < 1 || pos > size) {
        printf("Invalid position");
    } else if (pos == 1) {
        del_beg();
    } else {
        struct node *current, *nextNode;
        current = tail->next;
        while(i < pos - 1) {
            current = current->next;
            i++;
        }
        nextNode = current->next;
        current->next = nextNode->next;
        free(nextNode);
    }
}

void reverse() {
    if(tail == NULL) {
        printf("Not valid");
    } else {
        struct node *current, *previous, *nextNode;
        current = tail->next;
        nextNode = current->next;
        while (current != tail)
        {
            previous = current;
            current = nextNode;
            nextNode = current->next;
            current->next = previous;
        }
        nextNode->next = tail;
        tail = nextNode;
    }
}