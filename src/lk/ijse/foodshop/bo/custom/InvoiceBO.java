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
import lk.ijse.foodshop.dto.OrdersDTO;
import lk.ijse.foodshop.dto.InvoiceDTO;
import lk.ijse.foodshop.dto.QueryDTO;
import lk.ijse.foodshop.entity.Food;

/**
 *
 * @author kushantha
 */
public interface InvoiceBO extends SuperBO {

    public ArrayList<Food> getAllFoods() throws ClassNotFoundException, SQLException;

    public FoodDTO getFoodDetails(String description) throws ClassNotFoundException, SQLException;

    public String checkContact(String text) throws ClassNotFoundException, SQLException;

    public boolean placeOrder(InvoiceDTO purchase,String contact) throws ClassNotFoundException, SQLException;

    public String getLastId() throws ClassNotFoundException, SQLException;

    public List<QueryDTO> getAllOrders(String id) throws ClassNotFoundException, SQLException;

}
