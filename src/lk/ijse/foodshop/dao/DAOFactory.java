/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao;

import lk.ijse.foodshop.dao.custom.OrderDAO;
import lk.ijse.foodshop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.foodshop.dao.custom.impl.FoodDAOImpl;
import lk.ijse.foodshop.dao.custom.impl.InvoiceDAOImpl;
import lk.ijse.foodshop.dao.custom.impl.LoginDAOImpl;
import lk.ijse.foodshop.dao.custom.impl.OrderDAOImpl;
import lk.ijse.foodshop.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.foodshop.dao.custom.impl.InvoiceDetailDAOImpl;
import lk.ijse.foodshop.dao.custom.impl.QueryDAOImpl;
import lk.ijse.foodshop.dto.CustomerDTO;

/**
 *
 * @author kushantha
 */
public class DAOFactory {

    private static DAOFactory dAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public enum DAOTypes {
        LOGIN, CUSTOMER, FOOD, ORDERDETAIL, ORDERS, QUERYDAO, INVOICE, INVOICEDETAIL
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case FOOD:
                return new FoodDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();
            case ORDERS:
                return new OrderDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            case INVOICE:
                return new InvoiceDAOImpl();
            case INVOICEDETAIL:
                return new InvoiceDetailDAOImpl();
            default:
                return null;
        }
    }
}
