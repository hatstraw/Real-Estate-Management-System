/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

/**
 *
 * @author hatst
 */
public class Agent extends User {

    private String agentID;
    private double commissionRate;

    public Agent(String username, String password, String name, String number, String email) {
        super(username, password, name, number, email);
        this.agentID = username.charAt(0) + "" + name.charAt(name.length() - 1) + "Agent-01";
        this.commissionRate = 120000.00;
    }

    public Agent() {
        super("Ezam", "123", "Ezam Official", "+60-179234123", "ezam@gmail.com");
        this.agentID = "EOAgent-01";
        this.commissionRate = 120000.00;
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
                + " with ID of - " + this.getAgentID() + ".";
    }

    ////////// GETTERS & SETTERS \\\\\\\\\\

    @Override
    public String getName() {
        return super.getName(); 
    }

    
    public String getAgentID() {
        return agentID;
    }
    
}
