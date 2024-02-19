package study.asoostale.hexagonal;

import lombok.Builder;

import java.math.BigDecimal;

public class BankAccount {
    private Long id;
    private BigDecimal balance; // 잔액

    @Builder
    public BankAccount(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }



    public boolean withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) <= 0) {
            return false;
        // 잔액이 음수면 인출 실패
        }

        // 잔액에서 - amount
        balance = balance.subtract(amount);
        return true;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
