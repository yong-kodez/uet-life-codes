#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "randgen.h"

#define BUFFER_SIZE 256

/* ── Khởi tạo seed ── */
void randgen_init(unsigned int seed) {
    if (seed == 0)
        srand((unsigned int)time(NULL)); // dùng thời gian hiện tại
    else
        srand(seed);
}

/* ── Sinh số ngẫu nhiên trong [min, max] ── */
int randgen_next(int min, int max) {
    if (min > max) { // đổi chỗ nếu nhập ngược
        int tmp = min; min = max; max = tmp;
    }
    return min + rand() % (max - min + 1);
}

/* ── Phân tích lệnh đặc biệt và sinh số ── 
   Định dạng lệnh:
     #5 10 100   → sinh 5 số trong [10, 100]
     /3 1 6      → sinh 3 số trong [1, 6]
*/
static void handle_command(const char *line) {
    int count, min, max;

    // Bỏ qua ký tự # hoặc / ở đầu, đọc 3 số tiếp theo
    if (sscanf(line + 1, "%d %d %d", &count, &min, &max) == 3) {
        for (int i = 0; i < count; i++) {
            printf("%d", randgen_next(min, max));
            if (i < count - 1) printf(" ");
        }
        printf("\n");
    } else {
        fprintf(stderr, "Lệnh sai định dạng. Dùng: #<số lượng> <min> <max>\n");
    }
}

/* ── Vòng lặp đọc input ── */
void randgen_run_from_input(void) {
    char line[BUFFER_SIZE];

    randgen_init(0); // tự động seed theo thời gian

    while (fgets(line, BUFFER_SIZE, stdin) != NULL) {
        // Nếu dòng bắt đầu bằng # hoặc / → xử lý lệnh
        if (line[0] == '#' || line[0] == '/') {
            handle_command(line);
        } else {
            // Pass-through: in lại đúng như nhận được
            printf("%s", line);
        }
    }
}
