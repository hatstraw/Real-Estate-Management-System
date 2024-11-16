/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hatst
 */
abstract public class User extends UserInterface implements Login {

    private String username;
    private String password;
    private String name;
    private String number;
    private String email;
    private Agreement agreement;

    public User(String username, String password, String name, String number, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.number = number;
        this.email = email;
    }

    @Override
    public int logout(String username) {
        return 0;
    }

    public void loginValidity() {
        
        boolean status = (super.getCurrentUser() instanceof Agent && super.getCurrentUser() instanceof Buyer);
        // check if someone
        if(status){
            return;
        }

        System.out.println("\nPlease login with the credentials to use the system as " + this.getClass().getSimpleName() + "...");

        for (int i = 3; i >= 0; i--) {
            int statusCode = login();

            if (statusCode == 1) {
                System.out.println("You got " + i + " tries left.\n");
            } else if (statusCode == 0) {
                return;
            }
        }

        System.out.println("\nSystem is forcibly exited due to wrong login more than 3 times.");
        System.out.println("Going to see some scary red lines...");
        System.exit(1);
    }

    public void displayProperty(ArrayList<Property> Kl_property) {

        int counter = 1;
        
        System.out.println("Currently Available Properties in KL : ");
        System.out.println("======================================");

        for (Property prop : Kl_property) {
            System.out.println("===============Property : " + counter + " ===================");
            System.out.println(prop);
            System.out.println("===============================================");
            counter++;
        }

        System.out.println("Total of " + Kl_property.size() + " properties found !!!\n");

    }

    public void searchProperty(ArrayList<Property> Kl_property, String searchQuery) {

        int found_props = 0, counter = 1;

        for (int i = 0; i < Kl_property.size(); i++) {
            if (Kl_property.get(i).getAddress().contains(searchQuery)) {
                System.out.println("===============Property : " + counter + " ===================");
                System.out.println(Kl_property.get(i).toString());
                System.out.println("===============================================");
                found_props++;
                counter++;
            }
        }

        System.out.println("Total of " + found_props + " properties found !!!\n");

    }

    ////////// GETTERS & SETTERS \\\\\\\\\\
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
