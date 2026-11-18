### 1. Ngoại lệ xảy ra khi chạy 2 CommandServer cùng cổng

- Ngoại lệ: BindException
- Nguyên nhân: Tại một thời điểm, một cổng TCP chỉ được phép gán cho duy nhất một tiến trình lắng nghe, nếu có server thứ hai cố chiếm thì sẽ bị từ chối

### 2. Sự khác biệt về TCP và UDP

- TCP là giao thức kết nối:
  - Trước khi gửi dữ liệu, Client thực hiện kết nối bắt tay với Server
  - Nếu Server tắt thì bắt tay thất bại và ném ra lỗi
- UDP là giao thức phi kết nối
  - UDP không có bước bắt tay xác nhận kết nối
  - Lệnh `send` chỉ đẩy dữ liệu ra mạng rồi kết thúc thành công, không báo lỗi chương trình
