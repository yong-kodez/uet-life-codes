#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int id;
    int age;
    float score;
    char name[30];
} Student;
void getStudents(Student *class, int size);
void printTable(Student *class, int idx);
void printClass(Student *class, int size);
void menuFind(Student *class, int size);
void findById(Student *class, int size, int id);
void findByMax(Student *class, int size);
void menuScore(Student *class, int size);
void updateScore(Student *class, int size, int id);
float average(Student *class, int size);
void menuSort(Student *class, int size);
void sortByGradeDown(Student *class, int size);
void sortByAlphabet(Student *class, int size);

int main() {
    int size, cmd;
    printf("Nhap si so lop: ");
    scanf("%d", &size);
    Student *class = (Student*)malloc(size * sizeof(Student));
    getStudents(class, size);
    while (1) {
        printf("\n=== MENU QUAN LY ===\n");
        printf("1. In danh sach sinh vien\n");
        printf("2. Tim kiem sinh vien\n");
        printf("3. Cap nhat diem\n");
        printf("4. Sap xep danh sach\n");
        printf("5. Tinh diem trung binh\n");
        printf("0. Thoat chuong trinh\n");
        printf("--> Chon thao tac: ");
        scanf("%d", &cmd);
        switch (cmd) {
            case 1: printClass(class, size); break;
            case 2: menuFind(class,size); break;
            case 3: menuScore(class, size); break;
            case 4: menuSort(class, size); break;
            case 5: 
                float avg = average(class, size);
                if (avg < 0) printf("!!! Chua nhap diem cho lop\n");
                else printf("-> Diem trung binh (cua cac ban da co diem) la: %.2f\n", avg);
                break;
            case 0: printf("*** Thoat chuong trinh...***\n"); free(class); return 0;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }
    }
    free(class);
    return 0;
}
// Hàm nhập thông tin sinh viên
void getStudents(Student *class, int size) {
    for (int i = 0; i < size; i++) {
        getchar();
        class[i].id = i + 1;
        printf("- Sinh vien ID %d:\n", i+1);
        printf("\t+ Ten: ");
        fgets(class[i].name, sizeof(class[i].name), stdin);
        *(class[i].name + strlen(class[i].name) - 1) = '\0';
        printf("\t+ Tuoi: ");
        scanf("%d", &class[i].age);
        printf("\t+ Diem: ");
        scanf("%f", &class[i].score);
    }
}
void menuScore(Student *class, int size) {
    int subCmd, id;
    while (1) {
        printf("\n--- MENU NHAP DIEM ---\n");
        printf("1. Nhap diem theo id\n");
        printf("2. Nhap diem cho ca lop\n");
        printf("0. Quay ve\n");
        printf("--> Chon thao tac: ");
        scanf("%d", &subCmd);
        switch (subCmd) {
            case 1: 
                printf("ID sinh vien muon cap nhat: ");
                scanf("%d", &id);
                updateScore(class, size, id); break;
            case 2: 
                updateScore(class, size, -1); break;
            case 0: return;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }
    }
}
void updateScore(Student *class, int size, int id) {
    if (id == -1) {
        printf("- Cap nhat diem cho ca lop:\n");
        for (int i = 0; i < size; i++) {
            printf("\tID %d: ", class[i].id);
            scanf("%f", &class[i].score);
        }
    } else {
        printf("- Cap nhat diem cho ID %d: ", id);
        for (int i = 0; i < size; i++) {
            if (class[i].id == id) 
                scanf("%f", &class[i].score);
        }
    }
}
// Các hàm in
void printTable(Student *class, int idx) {
    if (idx == -1) printf("%-3s | %-30s | %-5s | %-7s\n", "ID", "HO VA TEN", "TUOI", "DIEM");
    else printf("%-3d | %-30s | %-5d | %-7f\n", class[idx].id, class[idx].name, class[idx].age, class[idx].score);
}
void printClass(Student *class, int size) {
    printf("\n--- DANH SACH LOP ---\n");
    printTable(class, -1);
    for (int i = 0; i < size; i++) {
        printTable(class, i);
    }
}
// Các hàm tìm kiếm
void menuFind(Student *class, int size) {
    int subCmd, id;
    while (1) {
        printf("\n--- MENU TIM KIEM ---\n");
        printf("1. Tim theo ID\n");
        printf("2. Tim sinh vien diem cao nhat\n");
        printf("0. Quay ve\n");
        printf("--> Chon thao tac: ");
        scanf("%d", &subCmd);
        switch (subCmd) {
            case 1: 
                printf("Nhap ID sinh vien muon tim: ");
                scanf("%d",&id);
                findById(class, size, id); break;
            case 2: findByMax(class, size); break;
            case 0: return;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }

    }
}
void findById(Student *class, int size, int id) {
    int found = 0;
    printf("\n+++ SINH VIEN CO ID %d+++\n", id);
    printTable(class, -1);
    for (int i = 0; i < size; i++) {
        if (class[i].id == id)  {
            printTable(class, i);
            found = 1;
        }
    }
    if (found == 0) printf("!!! Khong tim thay sinh vien\n");
}
void findByMax(Student *class, int size) {
    float max_grade = class[0].score;
    for (int i = 1; i < size; i++) 
        if (class[i].score > max_grade) max_grade = class[i].score;
    if (max_grade == -1.0) {
        printf("*** Chua nhap diem cho sinh vien ***\n");
        return;
    }
    printf("\n+++ DANH SACH SINH VIEN DIEM CAO NHAT +++\n");
    printTable(class, -1);
    for (int i = 0; i < size; i++) 
        if (class[i].score == max_grade) printTable(class, i);
}
// Tính điểm trung bình
float average(Student *class, int size) {
    float sum = 0, count = 0;
    for (int i = 0; i < size; i++) {
        if (class[i].score < 0)
            continue;
        sum += class[i].score;
        count += 1;
    }
    return (sum / count);
}
// Sắp xếp
void menuSort(Student *class, int size) {
    int subCmd;
    while (1) {
        printf("\n--- MENU SAP XEP---\n");
        printf("1. Theo bang chu cai\n");
        printf("2. Theo diem giam dan\n");
        printf("0. Quay ve\n");
        printf("--> Chon thao tac: ");
        scanf("%d", &subCmd);
        switch (subCmd) {
            case 1: 
                sortByAlphabet(class, size);
                printClass(class, size);
                break;
            case 2: 
                sortByGradeDown(class, size);
                printClass(class, size);
                break;
            case 0: return;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }

    }
}
void sortByAlphabet(Student *class, int size) {
    Student temp;
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (strcmp(class[j].name, class[j+1].name) > 0) {
                temp = class[j];
                class[j] = class[j+1];
                class[j+1] = temp;
            }
        }
    }
}
void sortByGradeDown(Student *class, int size) {
    Student temp;
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (class[j].score < class[j+1].score) {
                temp = class[j];
                class[j] = class[j+1];
                class[j+1] = temp;
            }
        }
    }
}
