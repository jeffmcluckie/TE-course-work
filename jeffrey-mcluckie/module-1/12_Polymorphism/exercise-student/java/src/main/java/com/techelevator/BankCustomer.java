package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable{
    private String name;
    private String address;
    private List<Accountable> accounts = new ArrayList<>();
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Accountable[] getAccounts() {
        return accounts.toArray(Accountable[]::new);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);
        }

        public boolean isVip() {
        int sum =0;
            for (Accountable sumAccounts : accounts) {
                sum += sumAccounts.getBalance();
            }
            if(sum >= 25000){
                return true;
            }
            else return false;
        }

    @Override
    public int getBalance() {
        return 0;
    }
}






