#include <stdio.h>
#include <stdlib.h>

struct tNode {
    int data;
    struct tNode *left;
    struct tNode *right;
};

// stack
struct sNode {
    struct tNode *t;
    struct sNode *next;
};
struct sNode *s = NULL;
int size = 0;

void push();
struct tNode *pop();
struct tNode *create();
void inorder();
void preorder();
void postorder();

void main()
{
    struct tNode *root = NULL;
    root = create();
    printf("%u, %d", root, root->data);
    // preorder(root);
    inorder(root);
    // postorder(root);
}

void inorder(struct tNode *root) {

}

void push(struct tNode *t)
{
    struct sNode *new_tNode = malloc(sizeof(struct sNode));
    new_tNode->t = t;
    new_tNode->next = s;
    s = new_tNode;
    size++;
}

struct tNode *pop() {
    if(size == 0) {
        printf("Underflow");
    } else {
        
    }
}

struct tNode *create()
{
    int x;
    struct tNode *newNode = malloc(sizeof(struct tNode));
    printf("Enter data, -1: exit");
    scanf("%d", &x);
    if (x == -1)
    {
        return NULL;
    }

    newNode->data = x;
    printf("\nenter left child of %d", x);
    newNode->left = create();
    printf("\nenter right child of %d", x);
    newNode->right = create();
    return newNode;
}