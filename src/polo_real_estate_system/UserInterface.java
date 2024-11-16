/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hatst
 */
public class UserInterface {

    private Scanner scan;
    private ArrayList<Property> Kl_property;
    private User currentUser;
    private Agreement agree;
    

    public UserInterface() {
        this.scan = new Scanner(System.in);
        this.Kl_property = new ArrayList<>();
    }

    public void Start() {
        this.readData();
        this.welcomeMsg();
        this.menu();
    }

    public void welcomeMsg() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+ \t\t\t\t\t    +\n+  \t\tWELCOME TO   \t\t    +\n+\tPOLO REAL ESTATE MANAGEMENT \t    +");
        System.out.println("+ \t\t\t\t\t    +\n+++++++++++++++++++++++++++++++++++++++++++");

        String prompt = "\n\t\t1. Login \n\t\t2. Register \n\nPlease choose one : ";
        int input = this.catchEmAll(prompt, 2);

        String loginPrompt = "\n\t\t1. Buyer \n\t\t2. Agent \n\t\t3. Seller \n\nPlease choose one : ";
        int loginChoice = this.catchEmAll(loginPrompt, 3);

        initializeSystem(input, loginChoice);
    }

    public void menu() {
        //this.clearScreen();

        while (true) {
            System.out.println(currentUser);

            String prompt = "\n\t\t1. Display Property \n\t\t2. Search Property \n\t\t3. Create Agreement \n\t\t4. End Session";

            //check if the current user is Seller with instaceOf method
            if (currentUser instanceof Seller) {
                prompt += "\n\t\t5. Add Property \n\t\t6. Delete Property \n\t\t7. Update Property";
            }

            prompt += " \n\nPlease choose one : ";

            int choice = (currentUser instanceof Seller) ? this.catchEmAll(prompt, 7) : this.catchEmAll(prompt, 4);

            this.actions(choice);

        }

    }

    public boolean createAgreement() {
        //check if the current user is Seller with instaceOf method
        if (currentUser instanceof Seller) {
            System.out.println("\n Seller cannnot sell property directly !!!\n Contact your nearest agent.");
            return false;
        }
        
        actions(1);
        System.out.println("Enter the your desired property number : ");
        int id = Integer.parseInt(scan.nextLine());

        if (currentUser instanceof Buyer) {
            //User nearestSeller = new Seller();
            agree = new Agreement(id, Kl_property.get(id), new Agent(), (Buyer)currentUser);
        }else if (currentUser instanceof Agent) {
            agree = new Agreement(id, Kl_property.get(id), new Agent(), (Buyer)currentUser);
        }
        
        agree.getPayment();
        
        return true;
    }

    public void actions(int choice) {
        switch (choice) {
            case 1:
                if (currentUser instanceof Buyer buyer) {
                    String searchQuery = buyer.getPreferredLocation();
                    currentUser.searchProperty(this.Kl_property, searchQuery);
                    break;
                }
                currentUser.displayProperty(this.Kl_property);
                break;

            case 2:
                System.out.println(" \n Current HOT Properties: \n\t1.Ampang Hilir \n\t2.Bukit Jalil \n\t3.Mont Kiara \n\t4.Kenny Hills\n");
                System.out.print("Enter your preferred location : ");
                String searchQuery = scan.nextLine();

                currentUser.searchProperty(this.Kl_property, searchQuery);
                break;
            case 3:
                if (createAgreement()){
                    System.out.println("\nCOngratz !! An agreement is created !!!");   
                    System.out.println("Print agreement ? (y/n)");
                    String arg = scan.nextLine();
                    if(arg.equals("y")){
                        System.out.println(agree.printAgreement());
                    }
                }else{
                    System.out.println("UH-oh, something went wro1"
                            + "ng, BYE_BYE!!!");
                    System.exit(1);
                }
                break;
            case 4:
                System.out.println("BYE-BYE!!!!!");
                System.exit(0);
                break;
            case 5:
                ((Seller) currentUser).addProperty(this.Kl_property);
                break;
            case 6:
                ((Seller) currentUser).deleteProperty(this.Kl_property);
                break;
            case 7:
                ((Seller) currentUser).updateProperty(this.Kl_property);
                break;
            default:
                break;
        }
    }

    // for internal use of class only
    private void initializeSystem(int input, int loginChoice) {
        if (input == 1) {
            if (loginChoice == 1) {
                currentUser = new Buyer();
                currentUser.loginValidity();
            } else if (loginChoice == 2) {
                currentUser = new Agent();
                currentUser.loginValidity();
            } else if (loginChoice == 3) {
                currentUser = new Seller();
                currentUser.loginValidity();
            } else {
                System.out.println("ERROR 404");
                System.exit(1); // Something, somewhere went terribly wrong, just nuke everything;
            }
        } else if (input == 2) {
            if (loginChoice == 1) {
                register("Buyer");
            } else if (loginChoice == 2) {
                register("Agent");
            } else if (loginChoice == 3) {
                register("Seller");
            } else {
                System.out.println("ERROR 404");
                System.exit(1); // Something, somewhere went terribly wrong, just nuke everything;
            }
        }
    }

    // for internal use of class only
    private int register(String Users) {

        // ToDO input sanitization
        System.out.print("Username : ");
        String username = scan.nextLine();
        System.out.print("Password : ");
        String pass = scan.nextLine();
        System.out.print("Full Name : ");
        String name = scan.nextLine();
        System.out.print("Number : ");
        String num = scan.nextLine();
        System.out.print("Email : ");
        String email = scan.nextLine();

        switch (Users) {
            case "Buyer" -> {
                System.out.print("Preferred Location : ");
                String loc = scan.nextLine();
                System.out.print("Budget : ");
                Double budget = scan.nextDouble();
                System.out.println("\n A new account for you as " + Users + " is created !!!");
                currentUser = new Buyer(username, pass, name, num, email, budget, loc);
                currentUser.loginValidity();
            }
            case "Agent" -> {
                System.out.println("\n A new account for you as " + Users + " is created !!!");
                currentUser = new Agent(username, pass, name, num, email);
                currentUser.loginValidity();
            }
            case "Seller" -> {
                System.out.println("\n A new account for you as " + Users + " is created !!!");
                currentUser = new Seller(username, pass, name, num, email);
                currentUser.loginValidity();
            }
            default -> {
                System.out.println("You broke it, you broke my program !!!!");
                System.exit(1); // Something, somewhere went terribly wrong, just nuke everything;
            }
        }

        return 0;
    }

    // for internal use of class only, just for avoiding duplicate code
    private int catchEmAll(String prompt, int noChoice) {
        int choice = 0;

        do {
            System.out.print(prompt);
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("User input was not a number.");
            }
        } while (choice <= 0 || choice > noChoice);

        return choice;
    }

    // read data from file to get first few houses
    // private because only this class will run the method, once when program run.
    private void readData() {

        // create scanner for reading the csv file
        try (Scanner scan = new Scanner(Paths.get("KL_Properties.csv"))) {

            // Read first line of file and discard it.
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String row = scan.nextLine();
                String[] parts = row.split(",");

                // parse the part that is not String in the csv file.
                int sqFeet = Integer.parseInt(parts[4]);
                int price = Integer.parseInt(parts[5]);
                String amneties = parts[6] + " - Bathroom \n\t\t\t  " + parts[7] + " - Car Parks \n\t\t\t  " + parts[8] + " - Rooms \n\t\t\t  " + "Furnishing: " + parts[9];
                double leasePrice = Double.parseDouble(parts[11]);
                double rentPrice = Double.parseDouble(parts[10]);

                this.Kl_property.add(new Property(parts[1], parts[2], parts[3], sqFeet, price, amneties, leasePrice, rentPrice));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // for clearing screen by bombarding with \n
    public void clearScreen() {
        System.out.println(new String(new char[70]).replace("\0", "\r\n"));
    }

    ////////// GETTERS & SETTERS \\\\\\\\\\
    public Scanner getScan() {
        return this.scan;
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
