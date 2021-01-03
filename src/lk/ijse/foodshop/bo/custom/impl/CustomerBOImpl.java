/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom.impl;

import lk.ijse.foodshop.bo.custom.CustomerBO;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.CustomerDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.entity.Customer;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author kushantha
 */
public class CustomerBOImpl implements CustomerBO {

    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return dao.isAdded(new Customer(customer.getCustId(), customer.getContact(), customer.getName(), customer.getAddrss()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return dao.update(new Customer(customer.getCustId(), customer.getContact(), customer.getName(), customer.getAddrss()));
    }

    @Override
    public boolean deleteCustomer(String customerID) throws ClassNotFoundException, SQLException {
        return dao.delete(customerID);
    }

    @Override
    public ArrayList<CustomerDTO> searchCustomers(String value) throws ClassNotFoundException, SQLException {
       ArrayList<CustomerDTO> all = new ArrayList<>() ;
        ArrayList<Customer> allCustomers = dao.search(value);
        allCustomers.forEach(e -> {
            all.add(new CustomerDTO(e.getCustId(), e.getContact(), e.getName(), e.getAddrss()));
        });
        return all;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        ArrayList<CustomerDTO> all = new ArrayList<>() ;
        ArrayList<Customer> allCustomers = dao.loadAll();
//        for (CustomerDTO c : all) {
//            allCustomers.add(new CustomerDTO(c.getCustId(), c.getName(), c.getAddrss(), c.getContact()));
//        }
//        return allCustomers;
//    }
        allCustomers.forEach(e -> {
            all.add(new CustomerDTO(e.getCustId(), e.getContact(), e.getName(), e.getAddrss()));
        });
        return all;
    }

    @Override
    public String checkContact(String contact) throws ClassNotFoundException, SQLException {
        return dao.checkContact(contact);
    }

    @Override
    public String getLastId() throws ClassNotFoundException, SQLException {
        return dao.getLastId();
    }
}
