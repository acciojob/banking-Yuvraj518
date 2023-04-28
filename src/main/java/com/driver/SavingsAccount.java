package com.driver;

public class SavingsAccount extends BankAccount{
    private static final double minBalance = 0;
    double rate;
    double maxWithdrawalLimit;
    private double numberOfWithdrawal;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,minBalance);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;
        numberOfWithdrawal=0;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getNumberOfWithdrawal() {
        return numberOfWithdrawal;
    }

    public void setNumberOfWithdrawal(double numberOfWithdrawal) {
        this.numberOfWithdrawal = numberOfWithdrawal;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(numberOfWithdrawal>=maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(getBalance()<amount){
            throw new Exception("Insufficient Balance");
        }
        numberOfWithdrawal++;
        super.setBalance((super.getBalance()-amount));
        return;
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return super.getBalance()+(super.getBalance()*years*rate);
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        return super.getBalance()+(Math.pow(1+rate/times,times*years));
    }

}
