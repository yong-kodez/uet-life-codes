#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum {NORMAL=0, WARNING, ERROR} Status;
typedef struct {
    float temperature;
    int timestamp;
    Status status;
} SensorData;

void getData(SensorData *data, int size);
void printTable(SensorData *data, int idx);
void printData(SensorData *data, int size);
float average(SensorData *data, int size);
void maxTemp(SensorData *data, int size);
void countStatus(SensorData *data, int size);
void sortByTime(SensorData *data, int size);
int cmpFunc(const void *a, const void *b);

int main() {
    int cmd = 0, n;
    printf("Nhap so du lieu: ");
    scanf("%d", &n);
    SensorData *list = (SensorData *)calloc(n ,sizeof(SensorData));
    while (1) {
        printf("\n=== SENSOR MANAGEMENT MENU ===\n");
        printf("1. Nhap danh sach du lieu\n");
        printf("2. In du lieu\n");
        printf("3. Nhiet do trung binh\n");
        printf("4. Gia tri nhiet do lon nhat\n");
        printf("5. Dem so lan cam bien tung trang thai\n");
        printf("6. Sap xep du lieu theo thoi gian\n");
        printf("0. Thoat chuong trinh\n");
        printf("--> Lua chon thao tac: ");
        scanf("%d", &cmd);
        switch (cmd) {
            case 1: getData(list, n); break;
            case 2: printData(list, n); break;
            case 3: printf("-> Nhiet do trung binh: %f\n", average(list, n)); break;
            case 4: maxTemp(list, n); break;
            case 5: countStatus(list, n); break;
            case 6: sortByTime(list, n); break;
            case 0: printf("*** Thoat chuong trinh...***\n"); free(list); return 0;
            default: printf("*** Lua chon khong hop le ***\n"); break;
        }
    }
    free(list);
    return 0;
}
void getData(SensorData *data, int size) {
    printf("\n * Nhap du lieu:\n");
    for (int i = 0; i < size; i++) {
        printf(" - Data #%d:\n", i + 1);
        printf("\t+ Nhiet do: ");
        scanf("%f", &(data[i].temperature));
        printf("\t+ Moc thoi gian (so nguyen): ");
        scanf("%d", &(data[i].timestamp));
        printf("\t+ Trang thai (NORMAL/WARNING/ERROR): ");
        char input[10];
        scanf("%s", input);
        if (strcasecmp(input, "NORMAL") == 0) {
            data[i].status = NORMAL;
        } else if (strcasecmp(input, "WARNING") == 0) {
            data[i].status = WARNING;
        } else if (strcasecmp(input, "ERROR") == 0) {
            data[i].status = ERROR;
        } else {
            data[i].status = ERROR;
            printf("\t ! Khong hop le, mac dinh status = ERROR\n");
        }
    }
}
void printTable(SensorData *data, int idx) {
    if (idx == -1) printf("%-10s | %-12s | %-10s\n", "TIMESTAMP", "TEMPERATURE", "STATUS");
    else {
        char *stat_table[] = {"NORMAL", "WARNING", "ERROR"};
        printf("%-10d | %-12f | %-10s\n", data[idx].timestamp, data[idx].temperature, stat_table[data[idx].status]);
    }
}
void printData(SensorData *data, int size) {
    printf("\n--- SENSOR DATAS ---\n");
    printTable(data, -1);
    for (int i = 0; i < size; i++) {
        printTable(data, i);
    }
}
float average(SensorData *data, int size) {
    float sum = 0;
    for (int i = 0; i < size; i++) {
        sum += data[i].temperature;
    }
    return (sum/size);
}
void maxTemp(SensorData *data, int size) {
    float max = data[0].temperature;
    for (int i = 0; i < size; i++) {
        if (data[i].temperature > max) 
            max = data[i].temperature;
    }
    printf("\n-> Nhiet do lon nhat: %f", max);
    printf("\n--- HIGHEST TEMPERATURE DATAS ---\n");
    printTable(data, -1);
    for (int i = 0; i < size; i++) {
        if (data[i].temperature == max)
            printTable(data, i);
    }
}
void countStatus(SensorData *data, int size) {
    char *stat_table[] = {"NORMAL", "WARNING", "ERROR"};
    int stat_counts[] = {0, 0, 0};
    for (int i = 0; i < size; i++) {
        switch (data[i].status) {
            case NORMAL: stat_counts[0] += 1; break;
            case WARNING: stat_counts[1] += 1; break;
            case ERROR: stat_counts[2] += 1; break;
        }
    }
    printf(" - So lan cam bien tung trang thai:\n");
    for (int i = 0; i < 3; i++) {
        printf(" + %s: %d\n", stat_table[i], stat_counts[i]);
    }
}
void sortByTime(SensorData *data, int size) {
    qsort(data, size, sizeof(SensorData), cmpFunc);
    printf("\n--- AFTER SORTED ---\n");
    printTable(data, -1);
    for (int i = 0; i < size; i++) {
        printTable(data, i);
    }
}
int cmpFunc(const void *a, const void *b) {
    SensorData *A = (SensorData *)a;
    SensorData *B = (SensorData *)b;
    return (A->timestamp) - (B->timestamp);
}
