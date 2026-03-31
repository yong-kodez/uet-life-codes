#include <stdio.h>

typedef struct {
    int id;
    int age;
    float score;
    char name[];
} Student;
int findMax(Student class[]) {
    float maxScore = class[0].score;
    for (int i = 1; i < size; i++) {
        if (class[i].score > maxScore) {
            maxScore = class[i].score;
        }
    }
    return maxScore;
}
int main() {
    int size, cmd;
    printf("Class size: ");
    scanf("%d", &size);

    Student class[size];
    while (cmd == 0) {
        printf("=== CLASS MANAGEMENT ===");
        printf("1. In danh sach\n");
        printf("2. Tim kiem sinh vien\n");
        printf("3. Cap nhat diem\n");
        printf("4. Tinh diem trung binh\n");
        printf("0. Thoat chuong trinh\n");
        printf("Chon chuc nang: ");
        scanf("%d", &cmd);
        
    }
    return 0;
}
