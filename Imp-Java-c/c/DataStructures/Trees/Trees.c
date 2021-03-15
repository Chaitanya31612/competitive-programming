#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *left, *right;
};

struct node *create();
void preorder(struct node *root);
void inorder(struct node *root);
void postorder(struct node *root);

void main() {
    struct node *root = NULL;
    root = create();
    // printf("%u, %d", root, root->data);
    preorder(root);
    inorder(root);
    postorder(root);
}

struct node *create() {
    int x;
    struct node *newNode = malloc(sizeof(struct node));
    printf("Enter data, -1: exit");
    scanf("%d", &x);
    if(x == -1) {
        return NULL;
    }

    newNode->data = x;
    printf("\nenter left child of %d", x);
    newNode->left = create();
    printf("\nenter right child of %d", x);
    newNode->right = create();
    return newNode;
}

void preorder(struct node *root) {
    if(root == NULL) {
        return;
    }

    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}

void inorder(struct node *root)
{
    if (root == NULL)
    {
        return;
    }

    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}

void postorder(struct node *root)
{
    if (root == NULL)
    {
        return;
    }

    postorder(root->left);
    postorder(root->right);
    printf("%d ", root->data);
}