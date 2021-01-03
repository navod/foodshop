/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom;

import java.sql.SQLException;

/**
 *
 * @author kushantha
 */
public interface HomeDAO {
    public int getAllOrders(String date) throws ClassNotFoundException, SQLException ;

    public int getAllCustomers() throws ClassNotFoundException, SQLException  ;

    public int rejectOrdersCount(String date)throws ClassNotFoundException, SQLException;

    public String checkDate(String date)throws ClassNotFoundException, SQLException;

    public boolean deleteOrders(String checkDate)throws ClassNotFoundException, SQLException;
}
