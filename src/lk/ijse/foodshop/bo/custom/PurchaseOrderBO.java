/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom;

import lk.ijse.foodshop.bo.SuperBO;
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
public interface PurchaseOrderBO extends SuperBO{
    public String getCustomerLastId() throws ClassNotFoundException, SQLException;

    public ArrayList<Customer> getAllContact() throws ClassNotFoundException, SQLException;

    public ArrayList<Food> getAllFoods() throws ClassNotFoundException, SQLException;

    public FoodDTO getFoodDetails(String description)throws ClassNotFoundException, SQLException;

    public CustomerDTO getContactDetails(String contact)throws ClassNotFoundException, SQLException;

    public boolean placeOrder(OrdersDTO orders)throws ClassNotFoundException, SQLException;
    
    public String orderLastId() throws ClassNotFoundException, SQLException;

    public boolean deleteOrders(String id) throws ClassNotFoundException, SQLException;

    public String checkOrders(String id2)throws ClassNotFoundException, SQLException;

    public boolean rejectOrders(String contact, String date)throws ClassNotFoundException, SQLException;

    public ArrayList<QueryDTO> serachOrders(String text)throws ClassNotFoundException, SQLException;

    public boolean updateOrders(int qty,String fid,double total)throws ClassNotFoundException, SQLException;
    
    public boolean addOrderDetail(ArrayList<OrderDetailDTO> list) throws ClassNotFoundException, SQLException;
    
    public boolean addItem(OrderDetailDTO detail) throws ClassNotFoundException, SQLException;
    
    public boolean updateQTY(ArrayList<OrderDetailDTO> orderDetails) throws ClassNotFoundException, SQLException;
    
    public boolean deleteOrderDetails(String id,String qty) throws ClassNotFoundException, SQLException;

    public boolean updateFoodQty(String qty, String tblQty,String id)throws ClassNotFoundException, SQLException;
    
    
}
