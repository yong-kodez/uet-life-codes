// Code Smell:
// - Poor Naming: Các biến t, h, r, m, f viết tắt làm khó hiểu
// - Unused Parameter: Tham số String t hoàn toàn không được sử dụng.
// - Magic Number: 0.9 xuất hiện trực tiếp trong phép tính mà không có giải thích   
// 
// Tại sao là vấn đề: Làm giảm khả năng đọc hiểu và gây khó khăn khi cần bảo trì
// 
// Kỹ thuật Refactor: 
// - Đổi tên biến/tham số cho có ý nghĩa
// - Xóa tham số thừa t
// - Thay thế số 0.9 bằng hằng số có tên rõ ràng
public double calculateFee(String t, int h, double r, boolean m) {
    double f = h * r;
    if (m) f = f * 0.9;
    return f;
}

// Sau khi Refactor
private final double MEMBER_DISCOUNT = 0.9;
public double calculateFeeClean(int hour, double hourlyRate, boolean isMember) {
    double fee = hour * hourlyRate;
    if (isMember) fee = fee * MEMBER_DISCOUNT;
    return fee;
}
