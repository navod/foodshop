/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom.impl;

import lk.ijse.foodshop.bo.custom.PurchaseOrderBO;
import lk.ijse.foodshop.controller.OrderDetailController;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.CustomerDAO;
import lk.ijse.foodshop.dao.custom.FoodDAO;
import lk.ijse.foodshop.dao.custom.OrderDAO;
import lk.ijse.foodshop.dao.custom.OrderDetailDAO;
import lk.ijse.foodshop.dao.custom.QueryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
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
public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    FoodDAO itemDAO = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    OrderDetailDAO orderDetailsDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
    QueryDAO queryDao = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public String getCustomerLastId() throws ClassNotFoundException, SQLException {
        return customerDAO.getLastId();
    }

    @Override
    public ArrayList<Customer> getAllContact() throws ClassNotFoundException, SQLException {
        return customerDAO.loadAll();
    }

    @Override
    public ArrayList<Food> getAllFoods() throws ClassNotFoundException, SQLException {
        return itemDAO.loadAll();
    }

    @Override
    public FoodDTO getFoodDetails(String description) throws ClassNotFoundException, SQLException {
        return orderDAO.getFoodDetails(description);
    }

    @Override
    public CustomerDTO getContactDetails(String contact) throws ClassNotFoundException, SQLException {
        return orderDAO.getContactDetails(contact);
    }

    @Override
    public boolean placeOrder(OrdersDTO od) throws ClassNotFoundException, SQLException {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            conn.setAutoCommit(false);

            OrdersDTO order = new OrdersDTO(od.getOid(), od.getContact(), od.getDate());
            boolean isAdded = orderDAO.isAdded(order);

            if (isAdded) {
                boolean isAddedAll = orderDetailsDAO.addOrderDetail(od.getOrderDetails());
                if (isAddedAll) {

                    boolean isUpdated = orderDetailsDAO.updateQTY(od.getOrderDetails());
                    if (isUpdated) {
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
    public String orderLastId() throws ClassNotFoundException, SQLException {
        return orderDAO.getLastId();
    }

    @Override
    public boolean deleteOrders(String id) throws ClassNotFoundException, SQLException {
        return orderDAO.delete(id);
    }

    @Override
    public String checkOrders(String id2) throws ClassNotFoundException, SQLException {
        return orderDAO.checkDetail(id2);
    }

    @Override
    public boolean rejectOrders(String contact, String date) throws ClassNotFoundException, SQLException {
        return orderDAO.rejectOrders(contact, date);
    }

    @Override
    public ArrayList<QueryDTO> serachOrders(String text) throws ClassNotFoundException, SQLException {
        return queryDao.searchOrders(text);
    }

    @Override
    public boolean updateOrders(int qty, String fid, double total) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.updateQTY(qty, fid, total);
    }

    @Override
    public boolean addOrderDetail(ArrayList<OrderDetailDTO> list) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.addOrderDetail(list);
    }

    @Override
    public boolean addItem(OrderDetailDTO detail) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.addItem(detail);
    }

    @Override
    public boolean updateQTY(ArrayList<OrderDetailDTO> orderDetails) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.updateQTY(orderDetails);
    }

    @Override
    public boolean deleteOrderDetails(String id, String qty) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.deleteFoods(id, qty);
    }

    @Override
    public boolean updateFoodQty(String qty, String tblQty, String id) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.updateFoodQty(qty, tblQty, id);
    }

}
