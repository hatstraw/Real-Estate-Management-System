/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

/**
 *
 * @author hatst
 */
public class Property {

    private String type;
    private String desc;
    private String address;
    private int sqFeet;
    private double price;
    private String amneties;
    private double leasePrice;
    private double rentPrice;
    private propertyTaxRate tax;


    public Property(String type, String desc, String address, int sqFeet, double price, String amneties, double leasePrice, double rentPrice) {
        this.type = type;
        this.desc = desc;
        this.address = address;
        this.sqFeet = sqFeet;
        this.price = price;
        this.amneties = amneties;
        this.leasePrice = leasePrice;
        this.rentPrice = rentPrice;
        this.tax = new propertyTaxRate();
    }

    @Override
    public String toString() {
        return "Property type \t\t: " + this.type + " \nDescription \t\t: " + this.desc + "\nAddress \t\t: " + this.address
                + "\nSquareFeet \t\t: " + this.sqFeet + " square feet " + "\nPrice \t\t\t: RM" + String.format("%.2f", this.price) + "\nAmneties \t\t: " + this.amneties
                + "\nLease Price\t\t: RM" + String.format("%.2f", this.leasePrice) + "\nRent Per Room(Price) \t: RM" + String.format("%.2f", this.rentPrice)
                + "\nProperty Tax \t\t: RM" + String.format("%.2f", this.tax.calcTax(sqFeet));
    }

    ////////// GETTERS & SETTERS \\\\\\\\\\

    public double getPrice() {
        return price;
    }

    public void setLeasePrice(double leasePrice) {
        this.leasePrice = leasePrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

}
