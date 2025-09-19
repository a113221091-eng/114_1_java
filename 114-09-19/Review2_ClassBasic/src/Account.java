public class Account {
    // 帳戶號碼
    private String accountNumber;
    // 帳戶餘額
    private double balance;

    // 建構子，初始化帳戶號碼與初始餘額
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // 取得帳戶號碼
    public String getAccountNumber() {
        return accountNumber;
    }

    // 取得帳戶餘額
    public double getBalance() {
        return balance;
    }

    // 存款方法，金額必須大於0
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為正數");
        }
    }
}