/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.CRUDUtill;
import lk.ijse.foodshop.dao.custom.HomeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kushantha
 */
public class HomeDAOImpl implements HomeDAO{

    @Override
    public int getAllOrders(String date) throws ClassNotFoundException, SQLException {
        String sql = "select count(oid) from orders where inDate = ?";
        ResultSet set = CRUDUtill.executeQuery(sql, date);

        if (set.next()) {
            return set.getInt(1);
        }
        return 0;
    }

    @Override
    public int getAllCustomers() throws ClassNotFoundException, SQLException {
        String sql = "select count(custContact) from customer";
        ResultSet set = CRUDUtill.executeQuery(sql);

        if (set.next()) {
            return set.getInt(1);
        }
        return 0;
    }

    @Override
    public int rejectOrdersCount(String date) throws ClassNotFoundException, SQLException {
        String sql = "select count(indate) from rejectorders where inDate=?";
        ResultSet set = CRUDUtill.executeQuery(sql,date);

        if (set.next()) {
            return set.getInt(1);
        }
        return 0;
    }

    @Override
    public String checkDate(String date) throws ClassNotFoundException, SQLException {
        String sql = "select indate from rejectorders where inDate=?";
        ResultSet set = CRUDUtill.executeQuery(sql,date);

        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }

    @Override
    public boolean deleteOrders(String checkDate) throws ClassNotFoundException, SQLException {
       String sql = "delete from rejectorders where inDate not in (?)";
       return CRUDUtill.executeUpdate(sql, checkDate);
    }
}
