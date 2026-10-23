### Cho calculateDiscount(double price, String memberType) với đặc tả sau:

- price < 0: ném IllegalArgumentException
 
- memberType là GUEST: không có chiết khấu (0%)
 
- memberType là MEMBER: chiết khấu 5% nếu price < 100, chiết khấu 10% nếu price >= 100
 
- memberType là VIP: chiết khấu 15% nếu price < 100, chiết khấu 20% nếu price >= 100
 
- memberType khác: ném IllegalArgumentException

### Answers
1. Các lớp tương đương cho tham số Price:
  - Lớp tương đương không hợp lệ: ném IllegalArgumentException
    EC1: price < 0
  - Lớp tương đương hợp lệ:
    EC2: 0 <= price < 100
    EC3: price >= 100

2. Bảng test case đầy đủ
| Mã TC  | Mô tả | price | memberType | Kết quả mong đợi |
|--------|-------|-------|------------|------------------|
|TC_EP_01| Giá âm | -10 | "MEMBER" | ném IllegalArgumentException |
|TC_EP_02| Khách giá thấp | 50 | "GUEST" | 0 |
|TC_EP_03| Thành viên thường giá thấp | 50 | "MEMBER" | 5 |
|TC_EP_04| Thành viên thường giá cao | 120 | "MEMBER" | 10 |
|TC_EP_05| Thành viên VIP giá thấp | 50 | "VIP" | 15 |
|TC_EP_06| Thành viên VIP giá cao | 120 | "VIP" | 20 |
|TC_EP_07| Loại thành viên không hợp lệ | 100 | "DIAMOND" | ném IllegalArgumentException |

3. Các giá trị biên cần test khi áp dụng BVA
- Biên dưới price=0:
  - min- : -0.01
  - min : 0.0 
  - min+ : 0.01
- Biên trên price=100:
  - max- : 99.99
  - max : 100.0
  - max+ : 100.01

4. Bộ test 2-way combinatorial
| Mã TC | price | memberType | Kết quả mong đợi |
| --- | --- | --- | --- |
| TC_2W_01 | -10.0 | "GUEST" | ném IllegalArgumentException |
| TC_2W_02 | -10.0 | "MEMBER" | ném IllegalArgumentException |
| TC_2W_03 | -10.0 | "VIP" | ném IllegalArgumentException |
| TC_2W_04 | -10.0 | "INVALID" | ném IllegalArgumentException |
| TC_2W_05 | 50.0 | "GUEST" | 0 |
| TC_2W_06 | 50.0 | "MEMBER" | 5 |
| TC_2W_07 | 50.0 | "VIP" | 15 |
| TC_2W_08 | 50.0 | "INVALID" | ném IllegalArgumentException |
| TC_2W_09 | 150.0 | "GUEST" | 0 |
| TC_2W_10 | 150.0 | "MEMBER" | 10 |
| TC_2W_11 | 150.0 | "VIP" | 20 |
| TC_2W_12 | 150.0 | "INVALID" | ném IllegalArgumentException |
