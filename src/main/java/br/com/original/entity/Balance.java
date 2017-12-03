package br.com.original.entity;

/**
 * Created by @cardosomarcos on 03/12/17
 */
public class Balance {

    private double current_balance;
    private double available_limit;
    private double current_limit;

    public double getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(double current_balance) {
        this.current_balance = current_balance;
    }

    public double getAvailable_limit() {
        return available_limit;
    }

    public void setAvailable_limit(double available_limit) {
        this.available_limit = available_limit;
    }

    public double getCurrent_limit() {
        return current_limit;
    }

    public void setCurrent_limit(double current_limit) {
        this.current_limit = current_limit;
    }
}
