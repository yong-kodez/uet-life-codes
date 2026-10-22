// Code Smell:
// - Data Clumps: cụm dữ liệu
// - Primitive Obsession: dùng nhiều kiểu nguyên thủy
//
// Tại sao là vấn đề: Các thuộc tính có cùng tiền tố author luôn đi kèm với nhau để
// biểu diễn Tác giả, việc để rời rạc trong lớp Report làm phình to lớp này và gây
// trùng lặp code nếu các lớp khác cũng cần lưu thông tin tác giả
//
// Kỹ thuật Refactor: Tách lớp, gom nhóm các thuộc tính của tác giả thành một lớp
// AuthorInfo riêng biệt
class Report {
    private String title;
    private String content;
    private String authorEmail;
    private String authorName;
    private String authorPhone;
    private String authorAddress;
}

// Sau khi Refactor 
class ReportClean {
    private String title;
    private String content;
    private AuthorInfo authorInfo;
}
class AuthorInfo {
    private String email;
    private String name;
    private String phone;
    private String address;
}
