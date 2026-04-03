#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};
void printList(struct Node *list);
void freeList(struct Node *list);
void addNode(struct Node *list, int val);
void removeNode(struct Node *list, int val);

int main() {
    int cmd, val;
    struct Node *firstNode = (struct Node *)calloc(1, sizeof(struct Node));
    firstNode->next = NULL;
    if (firstNode == NULL) {
        printf("*** INIT NODE ERROR ***");
        return 1;
    }
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
                printList(firstNode); break;
            case 2:
                printf(" - Nhap gia tri them vao: ");
                scanf("%d", &val);
                addNode(firstNode, val); break;
            case 3:
                printf(" - Nhap gia tri can xoa: ");
                scanf("%d", &val);
                removeNode(firstNode, val); break;
            case 0:
                printf("*** Thoat chuong trinh...***\n"); 
                freeList(firstNode); return 0;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }
    }
    return 0;
}
void printList(struct Node *list) {
    if (list->next == NULL) {
        printf(" - Chua co phan tu nao !\n");
        return;
    } else {
        list = list->next;
    }
    printf(" - Danh sach: [ ");
    printf("%d", list->data);
    while (list->next != NULL) {
        list = list->next;
        printf(" -> %d", list->data);
    }
    printf(" ]\n");
}
void freeList(struct Node *list) {
    struct Node *freePtr = list, *guide = list;
    while (guide->next != NULL) {
        guide = guide->next;
        free(freePtr);
        freePtr = guide;
    }
    free(guide);
}
void addNode(struct Node *list, int val) {
    while (list->next != NULL) {
        list = list->next;
    }
    struct Node *newNode = (struct Node *)calloc(1, sizeof(struct Node));
    if (newNode == NULL) {
        printf("*** ADD NODE ERROR ***");
        return;
    }
    list->next = newNode;
    newNode->data = val;
    newNode->next = NULL;
    printf(" + Them gia tri %d thanh cong !\n", val);
}
void removeNode(struct Node *list, int val) {
    while (list->next != NULL) {
        if ((list->next)->data == val) {
            struct Node *temp = list->next;
            list->next = (list->next)->next;
            free(temp);
            printf(" + Xoa thanh cong gia tri %d (dau tien) !\n", val);
            return;
        }
        list = list->next;
    }
    printf(" !!! Khong tim thay gia tri %d\n", val);
}
