/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

/**
 *
 * @author hatst
 */
public class Payment {
    private String paymentType, cardNumber, cardDate, cardPin;

    public Payment(String paymentType, String cardNumber, String cardDate, String cardPin) {
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.cardPin = cardPin;
    }

    public Payment(String paymentType) {
        this.paymentType = paymentType;
    }
    
    
    
    public double calcPrice(double price){
        if (paymentType.equals("Installment")){
            return  price / 12;
        }
        
        return price;
        
    }

    public String getPaymentType() {
        return paymentType;
    }
    
    
}
