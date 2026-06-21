#include <stdio.h>

void grade_sort(float grade) {
    if (grade > 10 || grade < 0) {
        printf("Diem khong hop le");
    } else if (grade >= 8.5) {
        printf("Diem: %.2f, hoc luc: Gioi\n", grade);
    } else if (grade >= 7.0) {
        printf("Diem: %.2f, hoc luc: Kha\n", grade);
    } else if (grade >= 5.0) {
        printf("Diem: %.2f, hoc luc: Trung binh\n", grade);
    } else {
        printf("Diem: %.2f, hoc luc: Yeu\n", grade);
    }
}
int main() {
    float grade;
    printf("Nhap diem trung binh: ");
    scanf("%f", &grade);
    grade_sort(grade);

    return 0;
}
