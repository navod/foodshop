/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.bo.BOFactory;
import lk.ijse.foodshop.bo.custom.PurchaseOrderBO;
import lk.ijse.foodshop.dao.custom.OrderDetailDAO;
import lk.ijse.foodshop.dao.custom.impl.OrderDetailDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.OrderDetailDTO;

/**
 *
 * @author kushantha
 */
public class OrderDetailController {
//    OrderDetailDAO d1 = new OrderDetailDAOImpl();
    PurchaseOrderBO purchaseOrderBO = (PurchaseOrderBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.PURCHASEORDER);
    
    public boolean addOrderDetail(ArrayList<OrderDetailDTO> list) throws ClassNotFoundException, SQLException {
//       return d1.addOrderDetail(list);
        return purchaseOrderBO.addOrderDetail(list);
    }

    public boolean addItem(OrderDetailDTO detail) throws ClassNotFoundException, SQLException {
//        return d1.addItem(detail);
          return purchaseOrderBO.addItem(detail);
    }

    public boolean updateQTY(ArrayList<OrderDetailDTO> orderDetails) throws ClassNotFoundException, SQLException {
//       return d1.updateQTY(orderDetails);
         return purchaseOrderBO.updateQTY(orderDetails);
    }

    public boolean deleteOrderDetails(String id,String qty) throws ClassNotFoundException, SQLException {
//        return d1.deleteFoods(id);
          return purchaseOrderBO.deleteOrderDetails(id,qty);
    }
}

