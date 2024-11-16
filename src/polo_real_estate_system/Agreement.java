/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author hatst
 */
public class Agreement {

    private int agreementID;
    private LocalDate date;
    private Property propertyDetail;
    private Agent agentDetail;
    private Buyer buyerDetail;
    private Payment pay;


    public Agreement(int agreementID, Property propertyDetail, Agent agentDetail, Buyer buyerDetail) {
        this.agreementID = agreementID;
        this.propertyDetail = propertyDetail;
        this.date = LocalDate.now();
        this.agentDetail = agentDetail;
        this.buyerDetail = buyerDetail;
    }
    
    public String getPayment(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nEnter the the payment method : ");
        System.out.println("\t\tInstallment \n\t\tFull Payment");
        String choice = scan.nextLine();
        
        if(choice.equals("Installment")){
            System.out.println("Enter your card number : ");
            String num = scan.nextLine();
            System.out.println("Enter your card date : ");
            String date = scan.nextLine();
            System.out.println("Enter your card pin : ");
            String pin = scan.nextLine();
            
            pay = new Payment(choice, num, date, pin);        
            return choice; 
        } else if(choice.equals("Full Payment")){
            pay = new Payment(choice);
            return choice;
        } else {
            System.out.println("Wrong choice");
            return "NULL";
        }
    }

    public String printAgreement() {
        return (this.toString() + "\n"+this.propertyDetail.toString());
    }

    @Override
    public String toString() {
        String prompt = "\n=============================================================\n" ;
        
        prompt += "\n\tThis agreement is created and notarized on the date of : "+ date + " for : \n\n\t\t 1)" + this.buyerDetail.getName() +" with an id of " + buyerDetail.getBuyerID()
                + "\n\n\tand handled by \n\n\t\t2)" + this.agentDetail.getName() +" with an id of " + agentDetail.getAgentID()
                + "\n\n\t for the property of with ID of " + agreementID + " loacated in " + propertyDetail.getAddress();
        
        prompt += "\n\n\tThe payment will be made in " + pay.getPaymentType() + " where buyee will make RM " + String.format("%.2f", pay.calcPrice(this.propertyDetail.getPrice())) 
                    + "\n\t until the whole payment of " + String.format("%.2f", this.propertyDetail.getPrice()) + " is completed from this day onward.";
        
        prompt += "\n====================================================================\n";
        
        return prompt;
    }
    
    
}
