/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polo_real_estate_system;

/**
 *
 * @author hatst
 */
public class propertyTaxRate {
    private String state;
    private String city;
    private double taxRate;

    public propertyTaxRate() {
        this.city = "Kuala Lumpur";
        this.state = "Selangor";
    }
    
    public double calcTax(int sqFeet) {
        // quit rent = approx. 0.0252 * per sq Feet (Gombak) // closest one I could find
        return (0.0252 * sqFeet);
    }
    
    
}
