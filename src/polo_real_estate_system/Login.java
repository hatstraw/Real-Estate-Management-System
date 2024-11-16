/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package polo_real_estate_system;

/**
 *
 * @author hatst
 */
public interface Login {
     
    // return 0 if succesfull or 1 if invalid
    public int login();
    
    // return 0 if succesfull or 1 if invalid
    public int logout(String username);
    
}
