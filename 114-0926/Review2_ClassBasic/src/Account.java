import java.util.Scanner;

public class Account {
    private String accountNumber;
    private double balance;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 建構子：初始化帳戶號碼與初始餘額
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber, double initialBalance) {
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，將餘額設為0");
            this.balance = 0; // 若初始餘額不合法，則設為0
        }

    }

    /**
     * 取得帳戶號碼
     * @return 帳戶號碼
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 取得帳戶餘額
     * @return 帳戶餘額
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 取得合法金額，最多重試3次
     * @param amount 初始金額
     * @param type 1:設定餘額 2:存款 3:提款
     * @return 合法金額
     * @throws IllegalArgumentException 若3次都不合法
     */
    private double getValidAmount(double amount, int type) {
        int attempts = 0;
        while (attempts < 3) {
            boolean valid = false;
            switch (type) {
                case 1: // 設定餘額
                    valid = amount > 0;
                    if (!valid) System.out.println("帳戶餘額必須為正數，請重新輸入：");
                    break;
                case 2: // 存款
                    valid = amount > 0;
                    if (!valid) System.out.println("存款餘額必須為正數，請重新輸入：");
                    break;
                case 3: // 提款
                    valid = amount > 0 && amount <= balance;
                    if (!valid) System.out.println("提取金額不合法，請重新輸入：");
                    break;
            }
            if (valid) return amount;
            // 重新輸入
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
            } else {
                scanner.next();
                amount = -1;
            }
            attempts++;
        }
        throw new IllegalArgumentException(type==1 ? "帳戶餘額必須為正數" : type==2 ? "存款餘額必須為正數" : "提取金額不合法");
    }

    /**
     * 設定帳戶餘額
     * 此方法會將帳戶餘額設為指定值，僅允許正數。
     * 若傳入的餘額不是正數，則會拋出 IllegalArgumentException 例外。
     * @param balance 欲設定的帳戶餘額，必須為正數
     * @throws IllegalArgumentException 若餘額不是正數則拋出例外
     */
    public void setBalance(double balance) {
        this.balance = getValidAmount(balance, 1);
    }



    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 存款方法，將指金額存入帳戶
     * @param amount
     * throws IllegalArgumentException 若金額非正數則拋出例外
     */
    public void deposit(double amount) {
        double validAmount = getValidAmount(amount, 2);
        balance += validAmount;
    }

    /**
     * 提款方法，從帳戶中扣除指定金額
     * @throws IllegalArgumentException 若金額不合法則拋出例外
     * @param amount 存入金額，必須為正數
     */
    public void withdraw(double amount) {
        double validAmount = getValidAmount(amount, 3);
        balance -= validAmount;
    }
}