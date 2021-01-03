/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.bo.BOFactory;
import lk.ijse.foodshop.bo.custom.CustomerBO;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.CustomerDAO;
import lk.ijse.foodshop.dao.custom.impl.CustomerDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.CustomerDTO;

/**
 *
 * @author kushantha
 */
public class CustomerController {

//    CustomerDAO c1 = (CustomerDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    CustomerBO c1 = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    public boolean isAddedCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return c1.addCustomer(customer);
    }

    public List<CustomerDTO> loadAllCustomer() throws ClassNotFoundException, SQLException {
        return c1.getAllCustomers();
    }

    public String checkContact(String contact) throws ClassNotFoundException, SQLException {
        return c1.checkContact(contact);
    }
    public boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return c1.updateCustomer(customer);
    }
    public String getLastId() throws ClassNotFoundException, SQLException {
        return c1.getLastId();
    }
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{
        return c1.deleteCustomer(id);
    }
    public ArrayList<CustomerDTO> searchCustomers(String value) throws ClassNotFoundException, SQLException{
        return  c1.searchCustomers(value);
    }
}
