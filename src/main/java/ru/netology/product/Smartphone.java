package ru.netology.product;


public class Smartphone extends Product {

    private String vendor;


    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }
}
