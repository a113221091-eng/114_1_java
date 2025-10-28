import java.util.Scanner;

public class Account {
    // 帳戶餘額
    private double balance;
    // 帳號
    private String accountNumber;

    /**
     * 建構子：初始化帳號與餘額
     * @param accountNumber 帳號
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        try {
            this.setAccountNumber(accountNumber);
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始化帳戶時發生錯誤：" + e.getMessage());
            this.balance = 0; // 若初始化錯誤，設為0
        }
    }

    public Account(){
        this("000000",0.0);
    }

    public Account(String accountNumber){
        this(accountNumber,0.0);
    }

    // 取得帳號
    public String getAccountNumber() {
        return accountNumber;
    }

    // 取得餘額
    public double getBalance() {
        return balance;
    }

    // 設定帳號
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // 設定餘額，防止負數
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("餘額不能為負數。");
        }
        this.balance = balance;
    }

    /**
     * 存款方法
     * @param amount 存款金額
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("存款金額必須大於零。");
        }
    }

    /**
     * 多幣別存款方法
     * @param amount 存款金額
     * @param currency 幣別（USD、EUR、JPY）
     */
    public void deposit(double amount, String currency) {
        double exchangeRate = 1.0; // 預設匯率為1.0
        switch (currency.toUpperCase()) {
            case "USD":
                exchangeRate = 35.0; // 1 USD = 35 TWD
                break;
            case "EUR":
                exchangeRate = 38.0; // 1 EUR = 38 TWD
                break;
            case "JPY":
                exchangeRate = 0.25; // 1 JPY = 0.25 TWD
                break;
            default:
                System.out.println("不支援的貨幣類型。");
                return;
        }
        this.deposit(amount * exchangeRate);
    }

    /**
     * 多筆金額存款
     * @param amounts 多筆金額
     */
    public void deposit(double... amounts) {
        double total = 0;
        for (double amount : amounts) {
            if (amount > 0) {
                total += amount;
            } else {
                throw new IllegalArgumentException("存款金額必須為正數。");
            }
        }
        this.deposit(total);
    }

    /**
     * 提款方法
     * @param amount 提款金額
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額無效或超過餘額。");
        }
    }
}
