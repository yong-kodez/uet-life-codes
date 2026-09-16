## Bài 6: Kiểm tra số nguyên tố

Giải thích cách làm:
- Với mỗi số i là ước của n thì cũng có ước n/i và điểm giữa của các ước đó là i=n/i (nếu chính phương)
- Duyệt các giá trị từ 2 (ước nhỏ nhất có thể) đến căn bậc 2 của n
- Mỗi vòng kiểm tra nếu n chia hết cho i có thể kết luận không phải là số nguyên tố
- Xử lý đặc biệt: nếu n < 2 thì trả về false ngay
