#include <stdio.h>
#include <stdlib.h>

struct node
{
    int info;
    struct node *link;
};

struct node *first = NULL, *last = NULL;
int size = 0;

void insert_end();
void insert_begin();
void insert_pos();
void display();
void delete_beg();
void delete_end();
void delete_pos();
void reverse();

void main() {
    int choice;
    printf("\n0: exit, 1: end, 2: begin, 3: pos, 4: display, 5: delete_beg, 6:delete_end, 7:delete_pos, 8: reverse\n");
    scanf("%d", &choice);
    while(choice) {
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
    struct node *newNode = malloc(sizeof(struct node));
    printf("Enter data:");
    scanf("%d", &newNode->info);
    newNode->link = NULL;
    if(first == NULL) {
        first = newNode;
    } else {
        last->link = newNode;
    }
    last = newNode;
    size++;
}

void insert_begin() {
    struct node *newNode = malloc(sizeof(struct node));
    printf("Enter begin data");
    scanf("%d", &newNode->info);
    if(first == NULL) {
        first = newNode;
        newNode->link = NULL;
    } else {
        newNode->link = first;
        first = newNode;
    }
    size++;
}

void insert_pos() {
    struct node *newNode = malloc(sizeof(struct node));
    struct node *temp = first;
    printf("Enter pos data");
    scanf("%d", &newNode->info);
    int c = 1, pos;
    printf("\nEnter position");
    scanf("%d", &pos);
    if(pos >= size) {
        printf("Overflow");
    } else {
        while(c < pos) {
            temp = temp->link;
            c++;
        }
        newNode->link = temp->link;
        temp->link = newNode;
    }
    
}

void display() {
    struct node *temp = first;
    if(first == NULL) {
        printf("\nEmpty list");
    } else {
        while(temp != NULL) {
            printf("%d->", temp->info);
            temp = temp->link;
        }
        printf("NULL\n");
    }
}

void delete_beg() {
    if(first == NULL) {
        printf("Underflow");
    } else {
        struct node *temp = first;
        first = first->link;
        free(temp);
    }
}

void delete_end() {
    if(first == NULL) {
        printf("Underflow");
    } else {
        struct node *temp = first, *ptemp;
        while(temp->link != NULL) {
            ptemp = temp;
            temp = temp->link;
        }
        if(temp == first) {
            first = NULL;
        } else {
            ptemp->link = NULL;
        }
        free(temp->link);
    }
}

void delete_pos() {
    if (first == NULL) {
        printf("Underflow");
    } else {
        struct node *temp=first, *nextNode;
        int pos, i = 1;
        printf("enter the postion");
        scanf("%d", &pos);
        if(pos > size) {
            printf("Invalid");
        } else {
            while(i < pos - 1) {
                temp = temp->link;
                i++;
            }
            nextNode = temp->link;
            temp->link = nextNode->link;
            free(nextNode);
        }
    }
}

void reverse() {
    struct node *prevnode, *currentnode, *nextnode;
    prevnode = NULL;
    currentnode = nextnode = first;
    while(nextnode != NULL) {
        nextnode = nextnode->link;
        currentnode->link = prevnode;
        prevnode = currentnode;
        currentnode = nextnode;
    }
    first = prevnode;
}