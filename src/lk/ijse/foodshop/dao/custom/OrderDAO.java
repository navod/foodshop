/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom;

import lk.ijse.foodshop.dao.CRUDDAO;
import lk.ijse.foodshop.dao.SuperDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.dto.OrderDetailDTO;
import lk.ijse.foodshop.dto.OrdersDTO;
import lk.ijse.foodshop.dto.QueryDTO;

/**
 *
 * @author kushantha
 */
public interface OrderDAO extends CRUDDAO<OrdersDTO, String>{

    public String getLastId() throws ClassNotFoundException, SQLException;

    public List<String> getAllContact() throws ClassNotFoundException, SQLException;

    public List<String> getAllFoods() throws ClassNotFoundException, SQLException;

    public FoodDTO getFoodDetails(String description) throws ClassNotFoundException, SQLException;

    public CustomerDTO getContactDetails(String contact) throws ClassNotFoundException, SQLException;

    public String checkDetail(String id2)throws ClassNotFoundException, SQLException;

    public boolean rejectOrders(String contact, String date) throws ClassNotFoundException, SQLException;
    
    

}
