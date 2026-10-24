package banksystem;

import java.util.Locale;

/**
 * Đại diện cho một giao dịch.
 */

public class Transaction {
  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /**
   * Hàm khởi tạo đầy đủ tham số.
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getInitialBalance() {
    return initialBalance;
  }

  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  public double getFinalBalance() {
    return finalBalance;
  }

  public void setFinalBalance(double finalBalance) {
    this.finalBalance = finalBalance;
  }

  // Vi phạm: Thiếu Javadoc cho phương thức public (Google Style cực kỳ khắt khe lỗi này)
  // Vi phạm: Tên phương thức không tuân thủ camelCase (có dấu gạch dưới)
  // Vi phạm: Tên tham số 't' quá ngắn, không rõ nghĩa
  /**
   * Lấy loại hóa đơn dưới dạng chuỗi.
   */
  public static String getTypeString(int type) {
    switch (type) {
      // Vi phạm: Thụt lề (Indentation) sai chuẩn, không nhất quán
      case TYPE_DEPOSIT_CHECKING: // Vi phạm: Magic Number '1' thay vì dùng TYPE_DEPOSIT_CHECKING
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING: // Vi phạm: Magic Number '2'
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS: // Vi phạm: Magic Number '3'
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS: 
        return "Rút tiền tiết kiệm";
      default:
        return "Không rõ";
    }
  }

  /**
   * Tổng kết các giao dịch.
   */
  public String getTransactionSummary() {
    // Vi phạm: Logging lộn xộn, dùng trực tiếp System.out, format tùy tiện
    // System.out.println(">>> [LOGGING] summary process started for type: " + this.type);

    // Vi phạm Cực nặng: Dòng code siêu dài (Line Length > 200 ký tự)
    // Vi phạm: Thiếu khoảng trắng (Whitespace) quanh các toán tử '+'
    // Vi phạm: Không sử dụng biến tạm, nhồi nhét mọi logic format vào một dòng
    // Vi phạm: Gọi trực tiếp hàm Locale.US nhiều lần thay vì hằng số hoặc format chung
    String typeString = getTypeString(type);
    return String.format(
        Locale.US,
        "- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f",
        typeString,
        initialBalance,
        amount,
        finalBalance
    );
  }
}
