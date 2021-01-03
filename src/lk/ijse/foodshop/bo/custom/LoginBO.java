/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom;

import lk.ijse.foodshop.bo.SuperBO;
import lk.ijse.foodshop.dto.LoginDTO;
import java.sql.SQLException;

/**
 *
 * @author kushantha
 */
public interface LoginBO extends SuperBO {

    public boolean searchUser(LoginDTO login) throws ClassNotFoundException, SQLException;
    
}
