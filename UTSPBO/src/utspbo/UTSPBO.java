/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utspbo;

/**
 *
 * @author ASUS
 */
public class UTSPBO {
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            BankingSystem bankingSystem = new BankingSystem();
            bankingSystem.showMenu();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
