package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public int withdraw(int amountToWithdraw) {
        if (getBalance() <= -100){
            return getBalance();
        }
        super.withdraw(amountToWithdraw);
        if (getBalance() - amountToWithdraw <= -100) {
            int newBalance = getBalance();
            System.out.println(amountToWithdraw);
            System.out.println(getBalance());
            System.out.println(newBalance);
            return newBalance;
        }
        else if (getBalance() < 0 && getBalance() > -100) {
            super.withdraw(10);
            return getBalance();
        }
        else {
            int newBalance = getBalance() - amountToWithdraw;
            System.out.println(amountToWithdraw);
            System.out.println(getBalance());
            System.out.println(newBalance);
            return amountToWithdraw;
        }
    }




}
