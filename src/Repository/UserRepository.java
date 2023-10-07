/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.UserD;

/**
 *
 * @author DELL
 */
public class UserRepository implements InterfaceUserRepository {

    @Override
    public void add() {
        UserD.Instance().createAccount();
    }

    @Override
    public void login() {
        UserD.Instance().loginSystem();
        
    }
    
}
