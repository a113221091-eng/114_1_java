public class Account {
    private static int accountCount = 0;


    private String accountNumber;

    private String ownerName;

    private double balance;

    /**
     * 建構子：初始化帳戶號碼與初始餘額
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber,  String ownerName,double initialBalance) {
        this.setAccountNumber(accountNumber);
        this.ownerName = ownerName;
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，將餘額設為0");
        }
        accountCount++;
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
     * 取得帳戶擁有者名稱
     * @return 帳戶擁有者名稱
     */

    public String getOwnerName() {
        return ownerName;
    }



    /**
     * 設定帳戶餘額
     * 此方法會將帳戶餘額設為指定值，僅允許正數。
     * 若傳入的餘額不是正數，則會拋出 IllegalArgumentException 例外。
     * @param balance 欲設定的帳戶餘額，必須為正數
     * @throws IllegalArgumentException 若餘額不是正數則拋出例外
     */
    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("餘額必須為正數");
        }
    }


    /**
     * 設定帳戶號碼
     * @param accountNumber 欲設定的帳戶號碼
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 存款方法，將指金額存入帳戶
     * @param amount
     * throws IllegalArgumentException 若金額非正數則拋出例外
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為正數");
        }
    }

    /**
     * 提款方法，從帳戶中扣除指定金額
     * @throws IllegalArgumentException 若金額不合法則拋出例外
     * @param amount 存入金額，必須為正數
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額不合法");
        }
    }
}
