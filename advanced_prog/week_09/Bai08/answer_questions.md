### Ý nghĩa của thư mục target:

- Là thư mục đầu ra mặc định do Maven tạo để chứa tất cả các sản phẩm sau quá trình build
- Chứa mã bytecode đã biên dịch (target/classes), báo cáo kiểm thử (target/surefire-reports),
và các file đóng gói (.jar, .war)
- Có thể xóa an toàn bằng lệnh mvn clean

### Ý nghĩa của pha package trong Maven Lifecycle:
- Là một phase trong vòng đời của Maven.
- Nhiệm vụ chính: Gom toàn bộ mã nguồn đã biên dịch và kiểm thử thành công, sau đó đóng
gói thành các loại định dạng (khai báo trong <packaging>, mặc định jar).
