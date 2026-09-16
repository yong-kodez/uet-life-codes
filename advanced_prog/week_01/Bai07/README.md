## Bài 7: Đảo ngược số nguyên

Giải thích cách làm:
- Lần lượt lấy chữ số cuối cùng của n bằng phép chia dư cho 10 cho đến khi n = 0
- Mỗi vòng gấp 10 res lên và cộng chữ số đó vào và loại bỏ chữ số cuối của n bằng chia nguyên cho 10
- Xử lý đặc biệt:
  - Số âm: vì phép chia dư trả về giá trị âm nên phép cộng digit vẫn đúng
  - Quá giới hạn: thiết lập giới hạn trên và dưới là khoảng MAX_VALUE và MIN_VALUE của Integer chia 10 trước khi nhân res lên nếu vượt quá thì sẽ tràn số (trả về 0) 
