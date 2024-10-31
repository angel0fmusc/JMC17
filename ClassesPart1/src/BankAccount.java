public class BankAccount {
    private int accountNumber;
    private int accountBalance;
    private String customerName;
    private String customerEmail;
    private String phoneNumber;

    public BankAccount(int accountNumber, int accountBalance, String customerName,
                       String customerEmail, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String customerEmail, String phoneNumber){
        this((int) (Math.random() * 90000), 0, customerName, customerEmail, phoneNumber);

    }



    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(int amount){
        if(amount < 0) {
            System.out.println("Cannot deposit a negative amount");
            return;
        }
        this.accountBalance += amount;
        System.out.println("Your current account balance is: $" + this.accountBalance);
    }

    public void withdrawFunds(int amount){
        if((this.accountBalance-amount) < 0){
            System.out.println("You do not have enough funds in this account to withdraw $" + amount);
            return;
        }
        this.accountBalance -= amount;
        System.out.println("You new balance is: $" + this.accountBalance);
    }
}
