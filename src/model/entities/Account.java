package model.entities;

import model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number,String holder,Double balance,Double withdrawLimit) {
        this.balance = balance;
        this.holder = holder;
        this.number = number;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double value) {
        balance += value;
    }
    public void withdraw(double value) {
       if(value < withdrawLimit) {
           balance -= value;
       }
       if(value > balance) {
           throw new DomainException("Not enough money!");
       }
       else {
           throw new DomainException("Withdraw limit exceeded!");
       }
    }

    @Override
    public String toString() {
        return "$" + balance;
    }
}
