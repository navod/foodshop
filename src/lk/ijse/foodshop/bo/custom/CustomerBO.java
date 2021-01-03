/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom;

import lk.ijse.foodshop.bo.SuperBO;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.entity.Customer;

/**
 *
 * @author kushantha
 */
public interface CustomerBO extends SuperBO{
    public boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;
    public boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;
    public boolean deleteCustomer(String customerID) throws ClassNotFoundException, SQLException;
    public ArrayList<CustomerDTO> searchCustomers(String value) throws ClassNotFoundException, SQLException;
    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException ;
    public String checkContact(String contact)throws ClassNotFoundException, SQLException;
    public String getLastId() throws ClassNotFoundException, SQLException;

   
}
