package dev.personal;

public class Money {
    int amount;
    String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return getCurrencyCode().equals(money.getCurrencyCode());
    }

    @Override
    public int hashCode() {
        return getCurrencyCode().hashCode();
    }
}
