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
public class Seller extends User {

    private String sellerID;
    private Scanner scan;

    public Seller(String username, String password, String name, String number, String email) {
        super(username, password, name, number, email);
        this.sellerID = username.charAt(0) + "" + name.charAt(name.length() - 1) + "Sell-01";
    }

    public Seller() {
        super("Adam", "123", "Adam Raja", "+60-179234123", "adam@gmail.com");
        this.sellerID = "AASell-01";
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

    public void addProperty(ArrayList<Property> Kl_property) {
        //TODO: Append to csv file
        this.scan = new Scanner(System.in);

        String type, desc, address, bathNum, roomNum, carParkNum, amneties;
        int sqFeet = 0, option = 0;
        double price = 0, leasePrice = 0, rentPrice = 0;

        System.out.print("Property type : ");
        type = scan.nextLine();
        System.out.print("Description : ");
        desc = scan.nextLine();
        System.out.print("Address : ");
        address = scan.nextLine();
        System.out.print("Square Feet : ");
        sqFeet = Integer.parseInt(scan.nextLine());
        System.out.print("Price : ");
        price = Double.parseDouble(scan.nextLine());
        System.out.println("Amneties : ");
        System.out.print("\tNo of bathroom : ");
        bathNum = scan.nextLine();
        System.out.print("\tNo of Car Parks : ");
        carParkNum = scan.nextLine();
        System.out.print("\tNo of Rooms : ");
        roomNum = scan.nextLine();
        System.out.println("Furnishing : ");

        do {
            System.out.print("\t 1) Fully Furnished OR 2) Partly Furnished : ");
            option = Integer.parseInt(scan.nextLine());
        } while (option != 1 && option != 2);

        amneties = bathNum + " - Bathroom \n\t\t  " + carParkNum + " - Car Parks \n\t\t  " + roomNum + " - Rooms \n\t\t  " + "Furnishing: " + option;

        System.out.print("leasePrice : ");
        leasePrice = Double.parseDouble(scan.nextLine());
        System.out.print("rentPrice : ");
        rentPrice = Double.parseDouble(scan.nextLine());

        Kl_property.add(new Property(type, desc, address, sqFeet, price, amneties, leasePrice, rentPrice));
    }

    public void deleteProperty(ArrayList<Property> Kl_property) {
        //To clear the Scanner object, we can re-instantiate the object again
        this.scan = new Scanner(System.in);

        int found_props = 0, id = 0;
        ArrayList<Integer> foundProperty = new ArrayList<>();

        System.out.print("\nProperties to delete from (address) : ");
        String searchQuery = scan.nextLine();

        System.out.println("==============================================");
        for (int i = 1; i <= Kl_property.size() - 1; i++) {
            if (Kl_property.get(i).getAddress().contains(searchQuery)) {
                System.out.println("===============Property : " + i + " ===================");
                foundProperty.add(i);
                System.out.println(Kl_property.get(i).toString());
                System.out.println("===============================================");

                found_props++;
            }
        }

        System.out.println("Total of " + found_props + " properties found !!!\n");

        do {
            System.out.println("Please choose one of the above listed properties to delete : ");
            id = scan.nextInt();
        } while (!(foundProperty.contains(id)));

        Kl_property.remove(id);
        System.out.println("The property is successfully deleted.");

    }

    public void updateProperty(ArrayList<Property> Kl_property) {
        //To clear the Scanner object, we can re-instantiate the object again
        this.scan = new Scanner(System.in);

        int found_props = 1, id = 0;
        double updateValue = 0;
        ArrayList<Integer> foundProperty = new ArrayList<>();

        System.out.print("\nProperties to update from (address) : ");
        String searchQuery = scan.nextLine();
        System.out.println("Categories to update : ");
        System.out.println("\t1)Price \n\t2)Lease \n\t3)Rent");
        int searchCat = Integer.parseInt(scan.nextLine());

        System.out.println("==============================================");
        for (int i = 0; i <= Kl_property.size() - 1; i++) {
            if (Kl_property.get(i).getAddress().contains(searchQuery)) {
                System.out.println("===============Property : " + i + " ===================");
                foundProperty.add(i);
                System.out.println(Kl_property.get(i).toString());
                System.out.println("===============================================");

                found_props++;
            }
        }
 
        System.out.println("Total of " + found_props + " properties found !!!\n");

        do {
            System.out.println("Please choose one of the above listed properties to update : ");
            id = scan.nextInt();
        } while (!(foundProperty.contains(id)));

        switch (searchCat) {
            case 1:
                System.out.println("Enter new price for the property : ");
                updateValue = scan.nextDouble();
                Kl_property.get(id).setPrice(updateValue);
                break;
            case 2:
                System.out.println("Enter new lease for the property : ");
                updateValue = scan.nextDouble();
                 Kl_property.get(id).setLeasePrice(updateValue);
                break;
            case 3:
                System.out.println("Enter new rent for the property : ");
                updateValue = scan.nextDouble();
                 Kl_property.get(id).setRentPrice(updateValue);
                break;
            default:
                System.out.println("Other categories are locked & cannot be updated for now...");
                break;
        }
        
        System.out.println("\nThe property is succefully updated");
    }

    @Override
    public String toString() {
        return "\nHey,  " + super.getUsername() + " !!! You are currently logged in as " + this.getClass().getSimpleName()
                + " with ID of - " + this.getSellerID() + ".";
    }

    ////////// GETTERS & SETTERS \\\\\\\\\\
    public String getSellerID() {
        return sellerID;
    }

}
