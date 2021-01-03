/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.bo.BOFactory;
import lk.ijse.foodshop.bo.custom.impl.InvoiceBOImpl;
import lk.ijse.foodshop.dao.custom.InvoiceDAO;
import lk.ijse.foodshop.dao.custom.impl.InvoiceDAOImpl;
import java.sql.SQLException;
import java.util.List;
import lk.ijse.foodshop.dto.InvoiceDTO;
import lk.ijse.foodshop.dto.QueryDTO;
import lk.ijse.foodshop.bo.custom.InvoiceBO;

/**
 *
 * @author kushantha
 */
public class InvoiceController {
    InvoiceBOImpl b1 = (InvoiceBOImpl)BOFactory.getInstance().getBO(BOFactory.BOTypes.PURCHASEBILL);
    public String checkContact(String text) throws ClassNotFoundException, SQLException {
//        return p1.checkContact(text);
         return b1.checkContact(text);
    }
    public List<QueryDTO> getAllOrders(String id) throws ClassNotFoundException, SQLException {
//        return p1.getAllOrders(id);
        return b1.getAllOrders(id);
    }

    public boolean placeBill(InvoiceDTO purchase,String contact) throws ClassNotFoundException, SQLException {
        return b1.placeOrder(purchase,contact);
    }

    public String getLastId() throws ClassNotFoundException, SQLException {
        return b1.getLastId();
    }

    public boolean deleteFood(String text) throws ClassNotFoundException, SQLException {
        return b1.deleteOrders(text);
    }
    
}
