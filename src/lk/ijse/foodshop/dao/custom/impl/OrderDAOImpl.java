/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.custom.OrderDAO;
import lk.ijse.foodshop.controller.FoodController;
import lk.ijse.foodshop.controller.OrderController;
import lk.ijse.foodshop.controller.OrderDetailController;
import lk.ijse.foodshop.dao.CRUDUtill;
import lk.ijse.foodshop.dao.custom.QueryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.dto.OrderDetailDTO;
import lk.ijse.foodshop.dto.OrdersDTO;
import lk.ijse.foodshop.dto.QueryDTO;

/**
 *
 * @author kushantha
 */
public class OrderDAOImpl implements OrderDAO {

    public String getLastId() throws ClassNotFoundException, SQLException {

        String sql = "select oid from orders order by oid desc limit 1";

        ResultSet set = CRUDUtill.executeQuery(sql);
        if (set.next()) {
            return set.getString("oid");
        }
        return null;

    }

    public List<String> getAllContact() throws ClassNotFoundException, SQLException {
        String sql = "select custContact from customer";

        ResultSet set = CRUDUtill.executeQuery(sql);
        List<String> o1 = new ArrayList<>();
        while (set.next()) {
            o1.add(set.getString("custContact"));
        }
        return o1;
    }

    public List<String> getAllFoods() throws ClassNotFoundException, SQLException {

        String sql = "select fName from food";

        ResultSet set = CRUDUtill.executeQuery(sql);
        List<String> o1 = new ArrayList<>();
        while (set.next()) {
            o1.add(set.getString("fName"));
        }
        return o1;
    }

    public FoodDTO getFoodDetails(String description) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM food WHERE fName = ?";

        ResultSet set = CRUDUtill.executeQuery(sql, description);
        if (set.next()) {
            return new FoodDTO(
                    set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getString(4));
        }
        return null;
    }

    public CustomerDTO getContactDetails(String contact) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM customer WHERE custContact = ?";

        ResultSet set = CRUDUtill.executeQuery(sql, contact);
        if (set.next()) {
            return new CustomerDTO(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4));

        }
        return null;
    }

    @Override
    public boolean isAdded(OrdersDTO enty) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO orders  VALUES (?,?,?)";
        return CRUDUtill.executeUpdate(sql, enty.getOid(), enty.getContact(), enty.getDate());
    }

    @Override
    public boolean update(OrdersDTO enty) throws ClassNotFoundException, SQLException {
        String sql = "Update Orders set inDate=?,custContact=? where oid=?";
        return CRUDUtill.executeUpdate(sql, enty.getDate(), enty.getContact(), enty.getOid());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CRUDUtill.executeUpdate("delete from orders where oid=?", id);
    }

    @Override
    public ArrayList<OrdersDTO> search(String value) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM orders WHERE oid LIKE ? || custContact LIKE ? ||  inDate LIKE ? ";

        ResultSet set = CRUDUtill.executeQuery(sql, "%" + value + "%", "%" + value + "%", "%" + value + "%");
        ArrayList<OrdersDTO> list = new ArrayList<>();

        while (set.next()) {
            list.add(new OrdersDTO(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3))
            );

        }
        return list;
    }

    @Override
    public String checkDetail(String id2) throws ClassNotFoundException, SQLException {
        String sql = "select oid from orderDetail where oid =?";

        ResultSet set = CRUDUtill.executeQuery(sql, id2);

        if (set.next()) {
            return set.getString(1);
        }
        return null;

    }

    @Override
    public boolean rejectOrders(String contact, String date) throws ClassNotFoundException, SQLException{
        String sql = "insert into rejectOrders values (?,?)";
        return CRUDUtill.executeUpdate(sql, contact,date);
    }

}
