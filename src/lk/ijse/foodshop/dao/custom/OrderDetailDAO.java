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
import lk.ijse.foodshop.dto.OrderDetailDTO;

/**
 *
 * @author kushantha
 */
public interface OrderDetailDAO extends SuperDAO{
     public boolean addOrderDetail(ArrayList<OrderDetailDTO> list) throws ClassNotFoundException, SQLException;
     public boolean addItem(OrderDetailDTO detail) throws ClassNotFoundException, SQLException;
     public boolean updateQTY(ArrayList<OrderDetailDTO> orderDetails) throws ClassNotFoundException, SQLException;

    public boolean deleteFoods(String id,String qty)throws ClassNotFoundException, SQLException;

    public boolean updateQTY(int qty,String id,double total)throws ClassNotFoundException, SQLException;

    public boolean updateFoodQty(String qty, String tblQty,String id)throws ClassNotFoundException, SQLException;
   
}
