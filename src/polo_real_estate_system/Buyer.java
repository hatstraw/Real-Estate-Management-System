/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author hatst
 */
public class Buyer extends User {

    private String buyerID;
    private double budget;
    private String preferredLocation;

    public Buyer(String username, String password, String name, String number, String email, Double budget, String preferredLocation) {
        super(username, password, name, number, email);
        this.buyerID = username.charAt(0) + "" + name.charAt(name.length() - 1) + "cust-01";
        this.budget = budget;
        this.preferredLocation = preferredLocation;
    }

    public Buyer() {
        super("Naim", "123", "Naim Sha", "+60-179234123", "naim@gmail.com");
        this.buyerID = "NScust-01";
        this.preferredLocation = "Kuala Lumpur";
    }

    @Override
    public int login() {

        System.out.print("Enter username : ");
        String username = super.getScan().nextLine();

        if (username.equalsIgnoreCase(super.getUsername())) {
            System.out.print("Enter password : ");
            String pwd = super.getScan().nextLine();
            if (pwd.equals(super.getPassword())) {
                System.out.println("\nCongratz !!! You logged in.");
                return 0;
            } else {
                System.out.println("\nWrong password !!!");
            }
        } else {
            System.out.println("\nNo such user exist here !!!");
        }

        return 1;
    }



    @Override
    public String toString() {
        return "\nHey,  " + super.getUsername() + " !!! You are currently logged in as " + this.getClass().getSimpleName()
                + " with ID of - " + this.getBuyerID() + ".";
    }

    ////////// GETTERS & SETTERS \\\\\\\\\\
    public String getBuyerID() {
        return buyerID;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public double getBudget() {
        return budget;
    }

}
