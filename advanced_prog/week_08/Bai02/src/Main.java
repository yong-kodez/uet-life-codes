public class Main {
    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;

    private static final long PERSONAL_DEDUCTION = 11000000;
    private static final long TAX_BRACKET_1 = 5000000;
    private static final long TAX_BRACKET_2 = 10000000;
    private static final double TAX_RATE_1 = 0.05;
    private static final double TAX_RATE_2 = 0.10;
    private static final long TAX_BASE_2 = 250000;
    private static final long TAX_BASE_3 = 750000;

    public static void main(String[] args) {
        String name = "tony";
        double baseSalary = 28000000;
        int workDays = 24;
        int totalDays = 28;
        double taxRate = 0.15;
        double bonus = 2000000;

        printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);
        printPayrollClean(name, baseSalary, workDays, totalDays, taxRate, bonus);
    }

    public static void printPayroll(String name, double baseSalary,
                             int workDays, int totalDays,
                             double taxRate, double bonus) {
        System.out.println("=== BẢNG LƯƠNG ===");
        System.out.println("Nhân viên: " + name);

        double actualSalary = baseSalary * workDays / totalDays;

        double insurance = actualSalary * 0.08 + actualSalary * 0.015;

        double taxableIncome = actualSalary - insurance - 11000000;
        double tax = 0;
        if (taxableIncome > 0) {
            if (taxableIncome <= 5000000) tax = taxableIncome * 0.05;
            else if (taxableIncome <= 10000000) tax = 250000 + (taxableIncome - 5000000) * 0.10;
            else tax = 750000 + (taxableIncome - 10000000) * taxRate;
        }

        double netSalary = actualSalary - insurance - tax + bonus;

        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
    }

    public static void printPayrollClean(String name, double baseSalary,
                                  int workDays, int totalDays,
                                  double taxRate, double bonus) {
        double actualSalary = calculateActualSalary(baseSalary, workDays, totalDays);
        double insurance = calculateInsurance(actualSalary);
        double tax = calculateTax(actualSalary, insurance, taxRate);
        double netSalary = calculateNetSalary(actualSalary, insurance, tax, bonus);
        
        System.out.println("=== BẢNG LƯƠNG (SAU REFACTOR) ===");
        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
    }

    public static double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * workDays / totalDays;
    }
    public static double calculateInsurance(double actualSalary) {
        double socialInsurace = actualSalary * SOCIAL_INSURANCE_RATE;
        double healthInsurance = actualSalary * HEALTH_INSURANCE_RATE;
        return socialInsurace + healthInsurance;
    }
    public static double calculateTax(double actualSalary, double insurance, double taxRate) {
        double taxableIncome = actualSalary - insurance - PERSONAL_DEDUCTION;
        double tax = 0;

        if (taxableIncome > 0) {
            if (taxableIncome <= TAX_BRACKET_1) {
                tax = taxableIncome * TAX_RATE_1;
            } else if (taxableIncome <= TAX_BRACKET_2) {
                tax = TAX_BASE_2 + (taxableIncome - TAX_BRACKET_1) * TAX_RATE_2;
            } else {
                tax = TAX_BASE_3 + (taxableIncome - TAX_BRACKET_2) * taxRate;
            }
        }
        return tax;
    }
    public static double calculateNetSalary(double actualSalary, double insurance, double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;    
    }
}
