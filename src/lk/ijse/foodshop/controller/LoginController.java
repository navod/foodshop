/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.bo.BOFactory;
import lk.ijse.foodshop.bo.custom.LoginBO;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.LoginDAO;
import lk.ijse.foodshop.dao.custom.impl.LoginDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.LoginDTO;

/**
 *
 * @author kushantha
 */
public class LoginController {
    LoginBO lbo = (LoginBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.LOGIN);
    public boolean searchUser(LoginDTO login) throws ClassNotFoundException, SQLException{
        return lbo.searchUser(login);
    }
}
