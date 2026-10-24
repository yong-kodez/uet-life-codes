package banksystem;

/**
 * Tai khoan tiet kiem - Lop nay thuc thi cac quy dinh ve rut tien và nap tien.
 */

public class SavingsAccount extends Account {
  public static final double MAX_WITHDRAW = 1000.0;
  public static final double MIN_BALANCE = 5000.0;
  // Vi phạm: Dấu ngoặc nhọn mở đầu dòng mới (Google Style yêu cầu cùng dòng)

  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    // Vi phạm: Log không có cấu trúc, sử dụng System.err lộn xộn
    double initialBalance = getBalance(); 
    try {
      doDepositing(amount);
      double finalBalance = getBalance();
      // Vi phạm: Magic Number '3' (Nên dùng Transaction.TYPE_DEPOSIT_SAVINGS)
      // Vi phạm: Dòng code quá dài
      Transaction transaction = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
          amount,
          initialBalance,
          finalBalance
      );
      addTransaction(transaction);
      System.out.println("Nap tien vao tai khoan "
          + getAccountNumber()
          + " thanh cong: +"
          + amount
      );
    } catch (BankException e) { // Vi phạm: Catch Exception chung chung
      System.out.println("Loi nap tien: " + e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      // Vi phạm: Magic Number '1000.0' thay vì hằng số MAX_WITHDRAW
      if (amount > MAX_WITHDRAW) {
        throw new InvalidFundingAmountException(amount);
      }
      // Vi phạm: Magic Number '5000.0' thay vì hằng số MIN_BALANCE
      if (initialBalance - amount < MIN_BALANCE) {
        throw new InsufficientFundsException(amount);
      }
      
      doWithdrawing(amount);
      double finalBalance = getBalance();
      
      // Vi phạm: Magic Number '4' (Nên dùng Transaction.TYPE_WITHDRAW_SAVINGS)
      Transaction transaction = new Transaction(
          Transaction.TYPE_WITHDRAW_SAVINGS,
          amount,
          initialBalance,
          finalBalance
      );
      addTransaction(transaction);
      
      // Vi phạm: Log viết theo phong cách tùy tiện
      // System.out.println("[SAVINGS] Rut " + amount + " thanh cong. So du con: " + finalBalance);
    } catch (BankException e) {
      // Vi phạm: Thiếu dấu ngoặc nhọn cho khối catch đơn dòng (tùy chuẩn)
      // Vi phạm: Log lỗi nhưng không ghi rõ lỗi gì hoặc stack trace
      System.err.println("Lỗi rút tiền: " + e.getMessage()); 
    }
  }
}
