package com.company.synchronizedkeyword;

public class BankObject {

    private int accountNo;
    private volatile int amount;

    public BankObject(int accountNo, int amount) {
        this.accountNo = accountNo;
        this.amount = amount;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BankObject{" +
                "accountNo=" + accountNo +
                ", amount=" + amount +
                '}';
    }
}
