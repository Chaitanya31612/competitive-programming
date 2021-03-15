#include <stdio.h>
#include <stdlib.h>

struct ListNode
{
    int data;
    struct ListNode *next;
} **head;

int ListLength(struct ListNode *head) {
    struct ListNode *current = head;
    int count = 0;

    while(current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}

void InsertInLinkedList(struct ListNode **head, int data, int position) {
    int k = 1;
    struct ListNode *p, *q, *newNode;
    // newNode = (ListNode *) malloc(sizeof(struct ListNode));
     if(!newNode) {
         printf("Memory Error");
         return;
     }
    newNode->data = data;
    p = *head;
    // beginning
    if(position = 1) {
        newNode->next = p;
        *head = newNode;
    } else {
        while((p!=NULL) && (k<=position)){
            k++;
            q = p;
            p = p->next;
        }
        q->next = newNode;
        newNode->next = p;
    }
}

void main()
{
    // printf("%d", ListLength(head));
    printf("hello");
    // InsertInLinkedList(head, 10, 1);
    // printf("hello");
    // InsertInLinkedList(head, 80, 1);
    // // printf("%d", ListLength(head));
    // InsertInLinkedList(head, 30, 2);
    // // printf("%d", ListLength(head));
    // InsertInLinkedList(head, 10, 3);
    // printf("%d", ListLength(a));
}
