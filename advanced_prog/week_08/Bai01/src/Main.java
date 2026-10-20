public class Main {
    private final double MEMBER_DISCOUNT = 0.9;
    public static void main(String[] args) {
            
    }

    // 
    public double calculateFee(String t, int h, double r, boolean m) {
        double f = h * r;
        if (m) f = f * 0.9;
        return f;
    }
    public double calculateFeeClean(int hour, double rate, boolean isMember) {
        double fee = hour * rate;
        if (isMember) fee = fee * MEMBER_DISCOUNT;
        return fee;
    }

    //
    class User {}
    class UserService {
        public User findById(int id) {}
        public void sendWelcomeEmail(User user) {}
        public void sendPasswordResetMail(User user) {}
        public void renderUserProfile(User user) {}
        public String exportUserToCsv(User user) {}
    } 

    //
    public double getArea(String shapeType, double a, double b) {
        if (shapeType.equals("rectangle")) return a * b;
        if (shapeType.equals("triangle")) return 0.5 * a * b;
        if (shapeType.equals("circle")) return 3.14159 * a * a;
        return -1;
    }

    //
    class Report {
        private String title;
        private String content;
        private String authorEmail;
        private String authorName;
        private String authorPhone;
        private String authorAddress;
    }
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
}
