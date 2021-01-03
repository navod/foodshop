/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom.impl;

import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.CustomerDAO;
import lk.ijse.foodshop.dao.custom.FoodDAO;
import lk.ijse.foodshop.dao.custom.InvoiceDAO;
import lk.ijse.foodshop.dao.custom.InvoiceDetailDAO;
import lk.ijse.foodshop.dao.custom.OrderDAO;
import lk.ijse.foodshop.dao.custom.QueryDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.dto.OrdersDTO;
import lk.ijse.foodshop.dto.InvoiceDTO;
import lk.ijse.foodshop.dto.QueryDTO;
import lk.ijse.foodshop.bo.custom.InvoiceBO;
import lk.ijse.foodshop.entity.Food;

/**
 *
 * @author kushantha
 */
public class InvoiceBOImpl implements InvoiceBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    FoodDAO itemDAO = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    InvoiceDAO purchaseDAO = (InvoiceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INVOICE);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);
    InvoiceDetailDAO invoiceDetailDAO = (InvoiceDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INVOICEDETAIL);

    @Override
    public ArrayList<Food> getAllFoods() throws ClassNotFoundException, SQLException {
        return itemDAO.loadAll();
    }

    @Override
    public FoodDTO getFoodDetails(String description) throws ClassNotFoundException, SQLException {
        return orderDAO.getFoodDetails(description);
    }

    @Override
    public boolean placeOrder(InvoiceDTO p, String contact) throws ClassNotFoundException, SQLException {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            conn.setAutoCommit(false);

            InvoiceDTO purchase = new InvoiceDTO(p.getInvoicId(), p.getDate());
            boolean isAdded = purchaseDAO.isAdded(purchase);

            if (isAdded) {
                boolean isAddedAll = invoiceDetailDAO.addInvoiceDetail(p.getPurchase());
                if (isAddedAll) {
                    if (contact.equals("")){
                        boolean isUpdated = invoiceDetailDAO.updateQTY(p.getPurchase());
                        if (isUpdated) {
                            conn.commit();
                            return true;
                        }
                    } else {

                        conn.commit();
                        return true;

                    }
                }

            } else {
                conn.rollback();
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getConnection().setAutoCommit(true);
        }
    }

    @Override
    public String checkContact(String text) throws ClassNotFoundException, SQLException {
        return purchaseDAO.checkContact(text);
    }

    @Override
    public String getLastId() throws ClassNotFoundException, SQLException {
        return purchaseDAO.getLastId();
    }

    @Override
    public List<QueryDTO> getAllOrders(String id) throws ClassNotFoundException, SQLException {
        return purchaseDAO.getAllOrders(id);
    }

    public boolean deleteOrders(String text) throws ClassNotFoundException, SQLException {
        return purchaseDAO.deleteOrders(text);
    }
}
