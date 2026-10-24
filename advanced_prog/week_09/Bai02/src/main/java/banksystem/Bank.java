package banksystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream; // Vi phạm: Wildcard import
import java.io.InputStreamReader;
import java.util.ArrayList; // Vi phạm: Wildcard import
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class đại diện cho một ngân hàng.
 */

public class Bank {
  private static final Logger logger = LoggerFactory.getLogger(Bank.class);
  private static final String TYPE_CHECKING = "CHECKING";
  private static final String TYPE_SAVINGS = "SAVINGS";
  private static final String ID_REGEX = "\\d{9}";
  // Vi phạm: Tên biến không rõ nghĩa, viết tắt sai chuẩn camelCase
  private List<Customer> customerList; 

  public Bank() {
    this.customerList = new ArrayList<Customer>();
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }

  // Vi phạm: Thụt đầu dòng (Indentation) lung tung và Javadoc thiếu tag @param
  /**
   * Set danh sách khách hàng.
   *
   * @param customerList danh sách khách hàng cần gán
   */
  public void setCustomerList(List<Customer> customerList) {
    if (customerList == null) {
      this.customerList = new ArrayList<Customer>();
    } else {
      this.customerList = customerList;
    }
  }

  /**
   * Hàm đọc danh sách khách hàng và tài khoản từ luồng đầu vào.
   *
   * @param inputStream nguồn đọc dữ liệu. 
   */
  public void readCustomerList(InputStream inputStream) {
    // Vi phạm: Log trực tiếp bằng System.out
    // System.out.println("DEBUG: Bat dau doc du lieu..."); 
    if (inputStream == null) {
      return;
    }

    logger.debug("Bắt đầu đọc dữ liệu");
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      Customer currentCustomer = null;

      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) {
          continue;
        }

        int lastSpace = line.lastIndexOf(' ');
        if (lastSpace <= 0) {
          continue;
        }

        String token = line.substring(lastSpace + 1).trim();
        // Vi phạm: Dùng biểu thức chính quy trực tiếp (Magic String)
        if (token.matches(ID_REGEX)) {
          String customerName = line.substring(0, lastSpace).trim();
          Long idNumber = Long.parseLong(token);
          currentCustomer = new Customer(idNumber, customerName);
          customerList.add(currentCustomer);
          logger.info("Thêm khách hàng: {}", customerName);
        } else if (currentCustomer != null) {
          parseAndAddAccount(currentCustomer, line);          
        }
      }
    } catch (IOException e) { // Vi phạm: Catch Exception chung chung
      logger.error("Lỗi I/O: ", e);
    } catch (NumberFormatException e) {
      logger.error("Lỗi khi chuyển đổi số: ", e);
    } finally {
      try {
        reader.close();  
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void parseAndAddAccount(Customer customer, String line) {
    String[] parts = line.split("\\s+");
    if (parts.length < 3) {
      return;
    }
    long accountNumber = Long.parseLong(parts[0]);
    String accountType = parts[1];
    double balance = Double.parseDouble(parts[2]);

    // Vi phạm: So sánh String dùng toán tử == (nếu lỡ tay) hoặc không xử lý hằng số
    if (TYPE_CHECKING.equals(accountType)) {
      customer.addAccount(new CheckingAccount(accountNumber, balance));
    } else if (TYPE_SAVINGS.equals(accountType)) {
      customer.addAccount(new SavingsAccount(accountNumber, balance));
    }
  }

  /**
   * Nhận về thông tin khách hàng sắp xếp theo số ID.
   */
  public String getCustomersInfoByIdOrder() {
    // Vi phạm: Dùng Anonymous class thay vì Lambda, thụt lề sai
    List<Customer> copyList = new ArrayList<Customer>(customerList);
    Collections.sort(copyList, (o1, o2) -> {
      return Long.compare(o1.getIdNumber(), o2.getIdNumber());
    });

    // Vi phạm: Cộng chuỗi (String concatenation) trong vòng lặp - Cực tệ cho performance
    // String res = "";
    return customerInfoFormat(copyList);
  }

  /**
   * Nhận về danh sách thông tin khách hàng sắp xếp theo tên.
   * Nếu trùng tên thì sắp xếp theo ID.
   */
  public String getCustomersInfoByNameOrder() {
    // Vi phạm: Logic trùng lặp nhiều với hàm trên (Code Duplication)
    List<Customer> copyList = new ArrayList<Customer>(customerList);
    Collections.sort(copyList, (c1, c2) -> {
      int res = c1.getFullName().compareTo(c2.getFullName());
      return res != 0 ? res : Long.compare(c1.getIdNumber(), c2.getIdNumber());
    });

    // Vi phạm: Dòng code quá dài, không ngắt dòng
    return customerInfoFormat(copyList);
  }

  /**
   * Duyệt qua danh sách thông tin khách hàng và nối chuỗi.
   */
  public String customerInfoFormat(List<Customer> customers) {
    StringBuilder sb = new StringBuilder();
    for (Customer customer : customers) {
      sb.append(customer.getCustomerInfo()).append("\n");
    }
    return sb.toString().trim();
  }
}
