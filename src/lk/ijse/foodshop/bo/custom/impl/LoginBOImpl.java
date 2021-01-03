/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom.impl;

import lk.ijse.foodshop.bo.BOFactory;
import lk.ijse.foodshop.bo.custom.LoginBO;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.LoginDAO;
import lk.ijse.foodshop.dto.LoginDTO;
import java.sql.SQLException;

/**
 *
 * @author kushantha
 */
public class LoginBOImpl implements LoginBO{
    LoginDAO bo = (LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);
    @Override
    public boolean searchUser(LoginDTO login) throws ClassNotFoundException, SQLException {
        return bo.searchUser(login);
    }
    
}
