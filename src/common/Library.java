/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Library {
    
    public final static String  CHECK_USERNAME = "^\\S{5}\\S*$";
    public final static String  CHECK_PASSWORD = "^\\S{6}\\S*$";
    
    
    public static String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String choice = sc.nextLine().trim();
            if(choice.isEmpty()) {
                System.out.print("*Can not be empty. Enter again:  ");
            } else{
                return choice;
            }
        }
    }
    
    public static boolean checkYN() {  
        while(true) {
            String choice = checkInputString();
            if(choice.equalsIgnoreCase("Y")) {
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.print("*Please type only Y or N:   ");
        }
    }
    
    public static boolean checkFileExist() {
        File file = new File("user.dat");
        if(!file.exists()) {
            try {
                System.out.println("File isn't exist");
                file.createNewFile();// java's method
                System.out.println("File created");
                return false;
            } catch(IOException e) {
                //
            }
        }
        return true;
    }
    
    public static boolean checkUserNameExist(String username) {
        File file = new File("user.dat");
        while (true) {
            try(FileReader fReader = new FileReader(file);BufferedReader bReader = new BufferedReader(fReader);) {
                String line;
                while( (line = bReader.readLine() ) != null ){
                   String[] account = line.split(";");
                   if(username.equalsIgnoreCase(account[0])) {
                       return false;
                   } 
                }
                return true;
            } catch(FileNotFoundException e) {
                //
            } catch(IOException e) {
                //
            }
            return true;
        }
    }
    
    

    public static String checkInputUser() {
        System.out.print("Enter user name:    ");
        while(true) {
            String input = checkInputString();
            if(input.matches(CHECK_USERNAME)) {
                return input;
            }
            System.out.print("*User name must at least 5 characters:  ");
        }
    }
    
    public static String checkInputPassWord() {
        System.out.print("Enter password:     ");
        while(true) {
            String input = checkInputString();
            if(input.matches(CHECK_PASSWORD)) {
                return input;
            }
            System.out.println("*Password must at least 6 characters:   ");
        }
    }
    
    
    
    
    
    
    
    
}
