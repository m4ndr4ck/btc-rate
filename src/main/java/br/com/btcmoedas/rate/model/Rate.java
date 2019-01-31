package br.com.btcmoedas.rate.model;

public class Rate {

    double value;

    public Rate withValue(double value){
        this.setValue(value);
        return this;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
