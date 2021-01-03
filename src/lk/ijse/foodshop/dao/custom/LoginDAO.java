/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom;

import lk.ijse.foodshop.dao.CRUDDAO;
import lk.ijse.foodshop.dao.SuperDAO;
import java.sql.SQLException;
import lk.ijse.foodshop.dto.LoginDTO;

/**
 *
 * @author kushantha
 */
public interface LoginDAO extends SuperDAO{
    
    public boolean searchUser(LoginDTO login) throws ClassNotFoundException, SQLException;
}
