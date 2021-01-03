/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.bo.BOFactory;
import lk.ijse.foodshop.bo.custom.PurchaseOrderBO;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.OrderDAO;
import lk.ijse.foodshop.dao.custom.impl.OrderDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.dto.OrderDetailDTO;
import lk.ijse.foodshop.dto.OrdersDTO;
import lk.ijse.foodshop.dto.QueryDTO;
import lk.ijse.foodshop.entity.Customer;
import lk.ijse.foodshop.entity.Food;

/**
 *
 * @author kushantha
 */
public class OrderController {

PurchaseOrderBO bo = (PurchaseOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PURCHASEORDER);
    public String getLastId() throws ClassNotFoundException, SQLException {
        return bo.orderLastId();
    }

    public ArrayList<Customer> getAllContact() throws ClassNotFoundException, SQLException {
       return bo.getAllContact();
    }

    public List<Food> getAllFoods() throws ClassNotFoundException, SQLException {
       return bo.getAllFoods();
    }

    public FoodDTO getFoodDetails(String description) throws ClassNotFoundException, SQLException {
      return bo.getFoodDetails(description);
    }

    public CustomerDTO getContactDetails(String contact) throws ClassNotFoundException, SQLException {
        return bo.getContactDetails(contact);
    }

    public boolean placeOrder(OrdersDTO orders) throws ClassNotFoundException, SQLException {
       return bo.placeOrder(orders);
    }

    public boolean deleteOrders(String id) throws ClassNotFoundException, SQLException {
        return bo.deleteOrders(id);
    }

    public String checkOrders(String id2) throws ClassNotFoundException, SQLException {
        return bo.checkOrders(id2);
    }

    public boolean rejectOrders(String contact, String date)throws ClassNotFoundException, SQLException{
       return bo.rejectOrders(contact,date);
    }

    public ArrayList<QueryDTO> searchOrders(String text) throws ClassNotFoundException, SQLException{
       return bo.serachOrders(text);
    }

    public boolean updateOrders(int qty,String fid,double total)throws ClassNotFoundException, SQLException {
        return bo.updateOrders(qty,fid,total);
    }

    public boolean updateFoodQty(String qty, String tblQty,String id) throws ClassNotFoundException, SQLException {
        return bo.updateFoodQty(qty,tblQty,id);
    }
}
