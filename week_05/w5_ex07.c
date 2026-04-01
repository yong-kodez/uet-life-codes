#include <stdio.h>

struct Node {
    int data;
    struct Node *next;
};
void printList(struct Node *llist);
void addNode(struct Node *llist, struct Node *newNode);
void removeNode(struct Node *llist, int val);

int main() {
    int cmd;
    struct Node *llist;
    while (1) {
        printf("\n--- MENU ---\n");
        printf("1. In danh sach\n");
        printf("2. Them mot phan tu\n");
        printf("3. Xoa mot phan tu\n");
        printf("0. Thoat chuong trinh\n");
        printf("-> Lua chon thao tac: ");
        scanf("%d", &cmd);
        switch (cmd) {
            case 1: 
                printList(llist); break;
            case 2: 
                struct Node *tempNode;
                addNode(llist, tempNode); break;
            case 3:
            case 0: printf("*** Thoat chuong trinh...***\n"); return 0;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }
    }
    return 0;
}
void printList(struct Node *llist) {
    if (llist->next == NULL) {
        printf(" %d", llist->data);
    } else {
        printf(" %d", llist->data);
        printList(llist->next);
    }
}
void addNode(struct Node *llist, struct Node *newNode) {
    struct Node *temp = llist;
    printf("Nhap gia tri them vao: ");
    scanf("%d", &newNode->data);
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
    newNode->next = NULL;
}
void removeNode(struct Node *llist, int val) {
    struct Node *temp = llist;
    while (temp->data != val) {
        temp = temp->next;
    }
    while (temp->next != NULL) {
        *temp = *(temp->next);
    }
}
