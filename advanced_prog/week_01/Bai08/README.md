## Bài 8: Kiểm tra số Palindrome

Giải thích cách làm:
- Dùng một số chia hệ 10 cùng số chữ số với n để lấy chữ số đầu tiên (/divisor) bằng vòng lặp
- Mỗi vòng lặp lấy ra số đầu tiên và cuối rồi so sánh với nhau
- Giảm giá trị của n đi chữ số cuối và đầu nên div phải giảm đi 100 lần
- Xử lý đặc biệt:
  - Nếu div = 1: tương đương n có 1 chữ số -> trả về true
  - Số âm: vẫn kiểm tra phần số nếu đúng -> trả về true
  - Có số 0 ở cuối: thường trả về false vì các số 0 ở đầu sẽ bị bỏ qua
  - Có nhiều số 0 ở giữa: nếu nhiều hơn về bên phải (VD: 21002) thì xử lý bình thường, nếu nhiều hơn về bên trái (VD: 20012) thì f_digit tiếp theo sẽ nhận được 0 (1/100 = 0) đảm bảo logic đúng
