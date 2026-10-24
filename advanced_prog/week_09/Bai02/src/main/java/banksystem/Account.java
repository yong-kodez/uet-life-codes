package banksystem;

import java.util.ArrayList; // Vi phạm: Wildcard import (nên import cụ thể List, ArrayList)
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Đại diện cho một tài khoản ngân hàng.
 * Lớp trừu tượng cho một số loại tài khoản.
 */
public abstract class Account {
  private static final Logger logger = LoggerFactory.getLogger(Account.class);
  // Vi phạm: Đặt tên hằng số không đúng chuẩn (phải là UPPER_SNAKE_CASE)
  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  // Vi phạm: Tên biến instance bắt đầu bằng dấu gạch dưới hoặc quá ngắn, không rõ nghĩa
  private long accountNumber; 
  private double balance; 
  protected List<Transaction> transactions; 

  // Vi phạm: Thụt lề (Indentation) không đồng nhất, không dùng 2 spaces theo chuẩn Google
  /**
   * Hàm khởi tạo với tên và tài khoản khởi tạo trước.
   *
   * @param accountNumber số tài khoản định danh cho mỗi tài khoản
   * @param balance số tiền trong tài khoản ban đầu khi khởi tạo
   */ 
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactions = new ArrayList<Transaction>();
  }

  // Vi phạm: Viết hàm trên một dòng, thiếu khoảng trắng giữa các toán tử/ngoặc
  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  protected void setBalance(double balance) {
    this.balance = balance;
  }

  public List<Transaction> getTransactionList() {
    return transactions;
  }

  /**
   * Thay đổi danh sách giao dịch.
   *
   * @param transactionList là danh sách giao dịch mới, nếu null thì khởi tạo mới
   */
  public void setTransactionList(List<Transaction> transactionList) {
    // Vi phạm: Thiếu dấu ngoặc nhọn cho câu lệnh if (mặc dù vẫn chạy đúng)
    if (transactionList == null) {
      this.transactions = new ArrayList<Transaction>();
    } else {
      this.transactions = transactionList;
    }
  }

  // Vi phạm: Thiếu Javadoc cho phương thức public <- Google Check bỏ qua
  public abstract void deposit(double amount);

  public abstract void withdraw(double amount);

  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    // Vi phạm: Whitespace quanh toán tử (amount<=0)
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  protected void doWithdrawing(double amount) throws BankException { 
    // Vi phạm: Tung ra Exception quá chung chung thay vì Exception cụ thể
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  /**
   * Thêm một giao dịch vào danh sách giao dịch.
   *
   * @param transaction giao dịch cần thêm vào
   */
  public void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactions.add(transaction);
    }
  }

  /**
   * Trả về lịch sử giao dịch dưới dạng xâu kí tự.
   *
   * @return s: chuỗi trả về tương ứng
   */
  public String getTransactionHistory() {
    // Vi phạm: Dòng code quá dài (Line length)
    // và dùng cộng chuỗi trong vòng lặp (Performance smell)
    StringBuilder sb = new StringBuilder();
    sb.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
    // String s = "Lịch sử giao dịch của tài khoản " + accountNumber + ":\n"; 
    for (int i = 0; i < transactions.size(); i++) {
      // s += transactions.get(i).getTransactionSummary(); // Vi phạm: Không dùng StringBuilder
      sb.append(transactions.get(i).getTransactionSummary());
      if (i < transactions.size() - 1) {
        // s += "\n";
        sb.append("\n");
      }
    }
    // Vi phạm: In log trực tiếp ra console để debug (Thay vì dùng Logger)
    // System.out.println("[DEBUG] Đã lấy lịch sử cho tài khoản: " + accountNumber); 
    logger.debug("Đã lấy lịch sử cho tài khoản: {}", accountNumber);
    return sb.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Account)) {
      return false;
    }
    Account other = (Account) obj;
    return this.accountNumber == other.accountNumber;
  }

  @Override
  public int hashCode() {
    // Vi phạm: Format code lộn xộn <- Google Check không báo lỗi
    return (int) (accountNumber ^ (accountNumber >>> 32));
  }
}
