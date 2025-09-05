package assignment2;

public class Account {
    // private variables
    private int accountNumber;
    private double accountBalance;
    private String accountName;

    // the default constructor
    public Account() {
        this.accountName = "Account";
        this.accountNumber = 10000;
        this.accountBalance = 0.0;
    }

    // constructor with 3 arguments
    public Account(int accountNumber, double accountBalance, String accountName) {
        setAccountNumber(accountNumber);
        setAccountBalance(accountBalance);
        setAccountName(accountName);
    }

    public String getAccountName() {
        return accountName;
    }

    public boolean setAccountName(String accountName) {
        if (isValidAccountName(accountName)) {
            this.accountName = accountName;
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean setAccountNumber(int accountNumber) {
        if (isValidAccountNumber(accountNumber)) {
            this.accountNumber = accountNumber;
            return true;
        }
        return false;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public boolean setAccountBalance(double value) {
        if (isValidAccountBalance(value)) {
            // round the balance to 2 decimal places
            this.accountBalance = Math.round(value * 100) / 100.0;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return accountNumber == account.accountNumber &&
                Double.compare(account.accountBalance, accountBalance) == 0 &&
                accountName.equals(account.accountName);
    }

    // return a string summary of the account
    @Override
    public String toString() {
        return "Account Name: " + accountName +
                ", Account Number: " + accountNumber +
                ", Balance: " + String.format("%.2f", accountBalance);
    }

    // validation methods
    private boolean isValidAccountName(String name) {
        // account name must be at least 4 characters
        if (name == null || name.length() < 4) return false;
        
        // it can only contain letters, hyphens, one space or one quote
        return name.matches("^[a-zA-Z-]+([' ]?[a-zA-Z-]+)*$");
    }

    private boolean isValidAccountNumber(int number) {
        // to convert to string to check the length of account number
        String numStr = Integer.toString(number);
        // must be between 5 and 9 digits
        return numStr.length() >= 5 && numStr.length() <= 9;
    }

    private boolean isValidAccountBalance(double balance) {
        // to check 2 decimal places
        return Math.abs(balance * 100 - Math.round(balance * 100)) < 0.001;
    }
}
