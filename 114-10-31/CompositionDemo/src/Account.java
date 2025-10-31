import java.time.LocalDateTime;

public class Account {
    private static int accountCount = 0;
    private String accountNumber;
    private String ownerName;
    private double balance;
    private Date openingDate;
    private Time2 openingTime;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        LocalDateTime now = LocalDateTime.now();
        this.setAccountNumber(accountNumber);
        this.ownerName = ownerName;
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，將餘額設為0");
            this.balance = 0;
        }
        accountCount++;
        this.openingDate = new Date(now.getMonthValue(), now.getDayOfMonth(), now.getYear());
        this.openingTime = new Time2(now.getHour(), now.getMinute(), now.getSecond());
    }

    public Account(String accountNumber, double initialBalance) {
        this(accountNumber, "未知", initialBalance);
    }

    public Account(){
        this("未知","未知",0);
    }

    public Account(String accountNumber){
        this(accountNumber,"未知",0);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("餘額必須為正數");
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為正數");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額不合法");
        }
    }

    public String toString() {
        return String.format("帳戶號碼: %s, 持有人: %s, 餘額: %.2f, 開戶日期: %s, 開戶時間: %s",
                accountNumber, ownerName, balance, openingDate.toString(), openingTime.toString());
    }
}