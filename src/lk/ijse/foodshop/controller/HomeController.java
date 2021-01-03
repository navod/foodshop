/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.dao.custom.HomeDAO;
import lk.ijse.foodshop.dao.custom.impl.HomeDAOImpl;
import java.sql.SQLException;

/**
 *
 * @author kushantha
 */
public class HomeController {
    HomeDAO h1 = new HomeDAOImpl();
    public int getAllOrders(String date) throws ClassNotFoundException, SQLException  {
       return h1.getAllOrders(date);
    }

    public int getAllCustomers() throws ClassNotFoundException, SQLException  {
        return h1.getAllCustomers();
    }

    public int rejectOrdersCount(String date) throws ClassNotFoundException, SQLException {
        return h1.rejectOrdersCount(date);
    }

    public String checkDate(String date)throws ClassNotFoundException, SQLException {
       return h1.checkDate(date);
    }

    public boolean deleteOrders(String checkDate) throws ClassNotFoundException, SQLException {
        return h1.deleteOrders(checkDate);
    }
    
}
