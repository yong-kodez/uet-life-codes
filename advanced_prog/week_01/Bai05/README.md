## Bài 5: Ước số chung lớn nhất

Giải thích cách làm:
- Quy tắc tìm ước chung lớn nhất:
  - Gọi ước chung lớn nhất của a, b là d
  - Kết quả phép chia lấy dư a % b = a - n.b (n là số lần b không vượt qua a)
  - Vì a và b có UCLN là d, nên a - n.b cũng chia hết cho d
  - Tiếp tục thu nhỏ 2 biến (đệ quy) cho đến khi một biến bằng 0 (chia hết cho nhau) thì UCLN chính là biến còn lại
  (nếu b > a thì a%b = a, sau lần đệ quy đầu quay về 2 biến lớn-nhỏ thông thường)

- Xử lý trường hợp đặc biệt:
  - Nếu a, b cũng bằng 0 thì không xác định (trả về -1)
  - Nếu một trong hai số là số âm, thì phép chia dư sẽ trả về giá trị âm nên đổi giấu gcd để đúng quy ước (UCLN là số dương)
