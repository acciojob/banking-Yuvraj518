package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name,double balance,double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum<0 || (digits*9)<sum){
            throw new Exception("Account Number can not be generated");
        }
        String acNo="";
        boolean flag=true;
        while(flag) {
            Random rand = new Random();
            int remaningSum = sum;
            int n;
            for (int i = 0; i < digits; i++) {
                int getMin = Math.min(remaningSum + 1, 10);
                n = rand.nextInt(getMin);
                acNo += String.valueOf(n);
                remaningSum-=n;
            }
            if(remaningSum==0){flag=false;}
        }
        return acNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
        return;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance<amount || (balance-amount)<minBalance){
            throw new Exception("Insufficient Balance");
        }
        balance-=amount;
        if(balance<minBalance){
            System.out.println();
        }
        return;
    }

}