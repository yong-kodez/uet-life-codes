## Bài 10: Tìm số lớn thứ 2 trong mảng

Giải thích cách làm:
- Khởi tạo biến largest và sec_largest lần lượt là giá trị đầu tiên của mảng và nhỏ nhất của kiểu Integer
- Sử dụng biến found mỗi khi gán giá trị vào sec_largest để báo hiệu đã tìm được
- Duyệt lần lượt qua các giá trị trong mảng
- Nếu có giá trị lớn hơn largest thì lưu lại vào largest, giá trị cũ (lớn nhất trước đó) lưu vào sec_largest
- Sau vòng lặp kiểm tra nếu found là false -> trả về -1, không thì trả về sec_largest
- Xử lý đặc biệt:
  - Mảng ít hơn 2 phần tử -> trả về -1
  - Nhiều phần tử giống nhau: xử lý đúng logic trên
