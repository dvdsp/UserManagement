/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import common.Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class UserD {
    private static UserD instance = null;
    public static UserD Instance() {
        if(instance == null) {
            synchronized( UserD.class) {
                if(instance == null) {
                    instance = new UserD();
                }
            }
        }
        return instance;
    }
    
    public void createAccount() {
        while(true) {
            if(!Library.checkFileExist()) {
                return;
            }
            String username = Library.checkInputUser();
            String password = Library.checkInputPassWord();
            if(!Library.checkUserNameExist(username)) {
                System.out.println("*User name already exist!");
                return;
            }
            addAccountData(username, password);
            System.out.print("Would you like to continue create new Account, type Y to continue - N to stop :    ");
            if (!Library.checkYN() ){
                return;
            }
        }
    }
    public static void addAccountData(String username, String password) {
        File file = new File("user.dat");
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(username + ";" + password + "\n"); 
            System.out.println("*Create successfully.*");
    
        } catch (IOException ex) {
            //ignore
        }

    }
    public void loginSystem() {
        if(!Library.checkFileExist()) {
            return;
        }
        String username = Library.checkInputUser();
        String password = Library.checkInputPassWord();
        
        if(!Library.checkUserNameExist(username)) {
            String storedPassword = passwordByusername(username);
            if (storedPassword != null && storedPassword.equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.err.println("*Password incorrect*");
            }
        } else {
            System.err.println("*Username not found*");
        }
 
    }
    
    
    //get password by username
    public static String passwordByusername(String username) {
        File file = new File("user.dat");
        try (FileReader fileReader = new FileReader(file);BufferedReader bufferedReader = new BufferedReader(fileReader);){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
        } catch (FileNotFoundException ex) {
          //ignore
        } catch (IOException ex) {
           //ignore
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
