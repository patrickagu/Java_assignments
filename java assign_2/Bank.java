package assignment2;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public static enum BranchLocations {
        NEW_YORK, LONDON, TOKYO, PARIS, SYDNEY
    };
    private String bankName;
    private BranchLocations branchLocation;
    private List<Account> accounts;

    // the default constructor
    public Bank() {
        this.bankName = "Bank";
        this.branchLocation = BranchLocations.NEW_YORK;
        this.accounts = new ArrayList<>();
    }
    // constructor with 2 parameters
    public Bank(String bankName, String branchLocation) {
        this();
        setBankName(bankName);
        setBranchLocation(branchLocation);
    }

    public String getBankName() {
        return bankName;
    }

    public boolean setBankName(String bankName) {
        if (isValidBankName(bankName)) {
            this.bankName = bankName;
            return true;
        }
        return false;
    }

    public boolean setBranchLocation(String branchLocation) {
        try {
            BranchLocations location = BranchLocations.valueOf(branchLocation.toUpperCase());
            this.branchLocation = location;
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public String getBranchLocation() {
        return branchLocation.name();
    }

    public boolean setBranchLocation(BranchLocations branchLocation) {
        this.branchLocation = branchLocation;
        return true;
    }

    public Account getAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return new Account();
    }

    // Add account
    public boolean addAccount(Account account) {
        if (account == null || getAccountByNumber(account.getAccountNumber()).getAccountNumber() != 10000) {
            return false;
        }
        accounts.add(account);
        return true;
    }

    public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
        // Check if account number already exists
        if (getAccountByNumber(accountNumber).getAccountNumber() != 10000) {
            return false;
        }

        // create new account
        Account newAccount = new Account();
        boolean valid = newAccount.setAccountNumber(accountNumber)
                && newAccount.setAccountName(accountName)
                && newAccount.setAccountBalance(accountBalance);

        if (!valid) {
            return false;
        }

        accounts.add(newAccount);
        return true;
    }

    // view account
    public Account viewAccount(int accountNumber) {
        return getAccountByNumber(accountNumber);
    }

    public Account viewAccount(byte index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return new Account();
    }

    // modify account
    public boolean modifyAccount(int accountNumber, String accountName) {
        Account account = getAccountByNumber(accountNumber);
        if (account.getAccountNumber() == 10000) return false;
        return account.setAccountName(accountName);
    }

    public boolean modifyAccount(int accountNumber, double accountBalance) {
        Account account = getAccountByNumber(accountNumber);
        if (account.getAccountNumber() == 10000) return false;
        return account.setAccountBalance(accountBalance);
    }

    public boolean modifyAccount(int accountNumber, String accountName, double accountBalance) {
        Account account = getAccountByNumber(accountNumber);
        if (account.getAccountNumber() == 10000) return false;
        boolean nameValid = account.setAccountName(accountName);
        boolean balanceValid = account.setAccountBalance(accountBalance);
        if (!nameValid || !balanceValid) {
            account.setAccountName(account.getAccountName());
            account.setAccountBalance(account.getAccountBalance());
            return false;
        }
        return true;
    }

    public boolean modifyAccount(byte index, String accountName) {
        Account account = viewAccount(index);
        if (account.getAccountNumber() == 10000) return false;
        return account.setAccountName(accountName);
    }

    public boolean modifyAccount(byte index, double accountBalance) {
        Account account = viewAccount(index);
        if (account.getAccountNumber() == 10000) return false;
        return account.setAccountBalance(accountBalance);
    }

    public boolean modifyAccount(byte index, String accountName, double accountBalance) {
        Account account = viewAccount(index);
        if (account.getAccountNumber() == 10000) return false;
        boolean nameValid = account.setAccountName(accountName);
        boolean balanceValid = account.setAccountBalance(accountBalance);
        if (!nameValid || !balanceValid) {
            account.setAccountName(account.getAccountName());
            account.setAccountBalance(account.getAccountBalance());
            return false;
        }
        return true;
    }

    // Delete account
    public boolean deleteAccount(int accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        if (account.getAccountNumber() == 10000) return false;
        return accounts.remove(account);
    }

    public boolean deleteAccount(byte index) {
        if (index >= 0 && index < accounts.size()) {
            accounts.remove(index);
            return true;
        }
        return false;
    }

    // method to validate bank name
    private boolean isValidBankName(String name) {
        // must be at least 8 characters
        if (name == null || name.length() < 8) return false;

        // it can contain letters, up to 3 numbers, space etc
        return name.matches("^[a-zA-Z&]+([ ]?[a-zA-Z0-9&]*)(\\d{0,2}[a-zA-Z&]*)$") &&
                name.chars().filter(Character::isDigit).count() <= 3;
    }
}
