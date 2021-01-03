/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.CRUDUtill;
import lk.ijse.foodshop.dao.custom.CustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.entity.Customer;
import lk.ijse.foodshop.view.CustomerForm;

/**
 *
 * @author kushantha
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean isAdded(Customer e) throws ClassNotFoundException, SQLException {
        String sql = "insert into customer values (?,?,?,?)";
        return CRUDUtill.executeUpdate(sql, e.getCustId(),e.getContact(),e.getName(),e.getAddrss());
    }

    
    @Override
    public ArrayList<Customer> loadAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from customer order by custId asc";

        ArrayList<Customer> cust = new ArrayList<>();

        ResultSet set = CRUDUtill.executeQuery(sql);

        while (set.next()) {
            String id = set.getString(1);
            String contact = set.getString(2);
            String name = set.getString(3);
            String address = set.getString(4);

            Customer customer = new Customer(id, contact, name, address);

            cust.add(customer);
        }
        return cust;

    }

    @Override
    public String checkContact(String contact) throws ClassNotFoundException, SQLException {
        
        String sql = "select custContact from customer where custContact = ?";
       
        ResultSet set = CRUDUtill.executeQuery(sql, contact);

        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }

    @Override
    public boolean update(Customer c) throws ClassNotFoundException, SQLException {

        String sql = "update customer set custContact = ?,custName = ?, custAddress = ? where custId =?";
        return CRUDUtill.executeUpdate(sql, c.getContact(),c.getName(),c.getAddrss(),c.getCustId());

    }

    @Override
    public String getLastId() throws ClassNotFoundException, SQLException {

    
        String sql = "select custID from customer order by custID desc limit 1";
        ResultSet set = CRUDUtill.executeQuery(sql);
        if (set.next()) {
            return set.getString("custID");
        }

        return null;
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from customer where custId=?";

        return CRUDUtill.executeUpdate(sql,id);
    }

    @Override
    public ArrayList<Customer> search(String value) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer WHERE custName LIKE ? || custId LIKE ? ||  custContact LIKE ? || custAddress LIKE ?";
        
        ResultSet set = CRUDUtill.executeQuery(sql,"%"+ value+"%","%"+ value+"%","%"+ value+"%","%"+ value+"%");
        ArrayList<Customer> list = new ArrayList<>();

        while (set.next()) {
            list.add(new Customer(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4))
            );

        }
        return list;
    }
}
