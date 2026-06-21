#include <stdio.h>

struct Point {
    float x, y;
};
void Move(struct Point *init, struct Point *shift) {
    init -> x += shift -> x;
    init -> y += shift -> y;
}
int main() {
    struct Point init, shift;
    printf("Initial point (x,y): ");
    scanf("%f %f", &init.x, &init.y);

    printf("Shift coordinate: ");
    scanf("%f %f", &shift.x, &shift.y);

    Move(&init, &shift);
    printf("New point: (%.2f,%.2f)\n", init.x, init.y);
    return 0;
}
