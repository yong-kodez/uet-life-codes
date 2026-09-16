## Bài 4: Tìm số Fibonacci thứ n

Giải thích cách làm:
- Khai báo 2 giá trị đầu tiên trong dãy Fibonacci (0 và 1) và kết quả số tiếp theo `res`
- Kiểm tra các điều kiện ban đầu nếu n âm (trả về -1) hay 2 số đầu tiên (0 và 1)
- Vòng lặp n-1 lần (vì n=2 chỉ cần thực hiện phép tính 1 lần) để tính toán lần lượt các số tiếp theo trong dãy
- Ở mỗi vòng lặp kiểm tra nếu `res` vượt quá `Long.MAX_VALUE`có khoảng giá trị -2^31 đến 2^31-1 nên nếu tràn số sẽ xuất hiện giá trị âm
- Lưu lại các giá trị 2 số gần nhất vào 2 biến a, b cho các vòng lặp tiếp theo
