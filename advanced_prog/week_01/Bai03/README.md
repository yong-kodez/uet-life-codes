## Bài 3: Phân tích Object

1. a) BankAccount
  - Trạng thái: gồm accountNumber, ownerName, balance ở trạng thái mặc định bằng 0.0
  - Hành vi: mở tài khoản (openAccount), gửi tiền (deposit), rút tiền (withdraw)
  - Định danh: đối tượng myAccount được khởi tạo trên vùng nhớ Heap (tên gọi tham chiếu myAccount ở trên vùng Stack)

2. b) SmartFan
  - Trạng thái: gồm brand, isPowerOn, speedLevel với các giá trị mặc định lần lượt là "Xiaomi", false, 0
  - Hành vi: turnOn, turnOff, setSpeed
  - Định danh: hai đối tượng livingRoomFan và bedroomFan là hai đối tượng khác nhau, nằm ở hai vị trí khác nhau trên heap
