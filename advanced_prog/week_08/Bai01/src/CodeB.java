// Code Smell: God Class - một class ôm quá nhiều việc
// 
// Tại sao là vấn đề: Khi cần thay đổi bất kỳ logic nào đều cần sửa class này, có thể dẫn đến lỗi các phần khác
// 
// Kỹ thuật Refactor: chia thành các lớp chuyên biệt
class User {}
class UserService {
    public User findById(int id) {}
    public void sendWelcomeEmail(User user) {}
    public void sendPasswordResetMail(User user) {}
    public void renderUserProfile(User user) {}
    public String exportUserToCsv(User user) {}
} 

// Sau khi Refactor
class UserServiceClean {
    public User findById(int id) {}
}
class UserEmailService {
    public void sendWelcomeEmail(User user) {}
    public void sendPasswordResetMail(User user) {}
}
class UserProfileRender {
    public void renderUserProfile(User user) {}
}
class UserExporter {
    public String exportUserToCsv(User user) {}
}
