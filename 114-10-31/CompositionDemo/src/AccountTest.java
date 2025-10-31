import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>();
        Account acc1 = new Account("A001", "Alice", 5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", "Bob", 3000);
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", "Charlie", -100);
        addCustomer(customers, acc3);

        operation(customers);
    }

    public static void operation(List<Account> customers){
        Scanner scanner = new Scanner(System.in);
        Account selectedAccount = null;
        while(true) {
            menu();
            System.out.print("請選擇功能(1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除換行符號
            switch (choice) {
                case 1:
                    System.out.print("輸入帳戶號碼: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("輸入持有人名稱: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("輸入初始餘額: ");
                    double initialBalance = scanner.nextDouble();
                    Account newAccount = new Account(accountNumber, ownerName, initialBalance);
                    addCustomer(customers, newAccount);
                    break;
                case 2:
                    System.out.print("輸入要查詢的帳戶號碼: ");
                    String searchAccountNumber = scanner.nextLine();
                    selectedAccount = customerInAction(customers, searchAccountNumber);
                    printCustomerInfo(selectedAccount);
                    break;
                case 3:
                    System.out.println("\n所有客戶帳戶資訊");
                    printCustomerAccounts(customers);
                    break;
                case 4:
                    System.out.print("輸入要刪除的帳戶號碼: ");
                    String deleteAccountNumber = scanner.nextLine();
                    deleteCustomer(customers, deleteAccountNumber);
                    break;
                case 5:
                    System.out.println("離開系統");
                    return;
                case 6:
                    System.out.print("輸入帳戶號碼: ");
                    String depositAcc = scanner.nextLine();
                    Account depAccount = customerInAction(customers, depositAcc);
                    if(depAccount != null){
                        System.out.print("輸入存款金額: ");
                        double depAmount = scanner.nextDouble();
                        depAccount.deposit(depAmount);
                    }
                    break;
                case 7:
                    System.out.print("輸入帳戶號碼: ");
                    String withdrawAcc = scanner.nextLine();
                    Account witAccount = customerInAction(customers, withdrawAcc);
                    if(witAccount != null){
                        System.out.print("輸入提款金額: ");
                        double witAmount = scanner.nextDouble();
                        witAccount.withdraw(witAmount);
                    }
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入");
            }
        }
    }

    public static Account customerInAction(List<Account> customers, String accountNumber){
        for (Account account : customers) {
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        System.out.println("查無此帳戶號碼: " + accountNumber);
        return null;
    }

    public static void addCustomer(List<Account> customers, Account newAccount) {
        customers.add(newAccount);
        System.out.println("成功新增客戶: " + newAccount.getAccountNumber());
    }
    public static void deleteCustomer(List<Account> customers, String accountNumber) {
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getAccountNumber().equals(accountNumber)){
                Account removedAccount = customers.remove(i);
                System.out.println("成功刪除客戶: " +  removedAccount.getAccountNumber() + " (" + removedAccount.getOwnerName() + ")");
                return;
            }
        }
        System.out.println("查無此帳戶號碼: " + accountNumber);
    }
    public static void printCustomerAccounts(List<Account> customers) {
        for (Account customer : customers) {
            printCustomerInfo(customer);
        }
    }

    public static void printCustomerInfo(Account account) {
        if(account == null){
            System.out.println("無法列印帳戶資訊，帳戶不存在");
            return;
        }
        System.out.println(account.toString());
    }

    public static void menu() {
        System.out.println("\n功能選單:");
        System.out.println("(1) 新增客戶");
        System.out.println("(2) 列印指定客戶帳戶資訊");
        System.out.println("(3) 顯示所有客戶帳戶資訊");
        System.out.println("(4) 刪除客戶帳戶");
        System.out.println("(5) 離開");
        System.out.println("(6) 存款");
        System.out.println("(7) 提款");
    }
}
