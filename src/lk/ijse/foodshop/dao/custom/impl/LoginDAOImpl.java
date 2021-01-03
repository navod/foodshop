/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.CRUDUtill;
import lk.ijse.foodshop.dao.custom.LoginDAO;
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
public class LoginDAOImpl implements LoginDAO {

    @Override
    public boolean searchUser(LoginDTO login) throws ClassNotFoundException, SQLException {

        String sql = "select * from login where logName = ? and logPassword = ? ";

        ResultSet set = CRUDUtill.executeQuery(sql, login.getUsername(), login.getPassword());
        if (login.getUsername().equals("navod") && login.getPassword().equals("1234")) {
            boolean datafound;
            return datafound = set.next();
        } else {
            return false;
        }

    }
}
