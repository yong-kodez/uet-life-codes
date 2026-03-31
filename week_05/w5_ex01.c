#include <stdio.h>

struct Point {
    int x, y;
};
void Move(struct Point *init, struct Point *shift) {
    init -> x += shift -> x;
    init -> y += shift -> y;
}
int main() {
    struct Point init, shift;
    printf("Initial point (x,y): ");
    scanf("%d %d", &init.x, &init.y);

    printf("Shift coordinate: ");
    scanf("%d %d", &shift.x, &shift.y);

    Move(&init, &shift);
    printf("New point: (%d,%d)\n", init.x, init.y);
    return 0;
}
