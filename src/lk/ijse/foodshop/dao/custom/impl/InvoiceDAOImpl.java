/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.CRUDUtill;
import lk.ijse.foodshop.dao.custom.InvoiceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.InvoiceDTO;
import lk.ijse.foodshop.dto.QueryDTO;

/**
 *
 * @author kushantha
 */
public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public String getLastId() throws ClassNotFoundException, SQLException {
        String sql = "select invoicId from invoice order by invoicId desc limit 1";

        ResultSet set = CRUDUtill.executeQuery(sql);
        if (set.next()) {
            return set.getString("invoicId");
        }
        return null;
    }

    @Override
    public boolean isAdded(InvoiceDTO enty) throws ClassNotFoundException, SQLException {
        String sql = "insert into invoice values (?,?)";
        return CRUDUtill.executeUpdate(sql, enty.getInvoicId(), enty.getDate());
    }

    @Override
    public String checkContact(String text) throws ClassNotFoundException, SQLException {
        String sql = "select custContact from orders where custContact = ?";
        ResultSet set = CRUDUtill.executeQuery(sql, text);

        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }

    @Override
    public List<QueryDTO> getAllOrders(String id) throws ClassNotFoundException, SQLException {
        String sql = "select food.foodId,fName,OrderDetail.qty,unitPrice,total \n"
                + "from orders cross join orderdetail cross join food on\n"
                + "orders.oid = orderdetail.oid and food.foodId = orderdetail.foodId where custContact=?";
         
        ResultSet set = CRUDUtill.executeQuery(sql, id);

        List<QueryDTO> list = new ArrayList<>();
        while (set.next()) {
            list.add(new QueryDTO(set.getString(1), set.getString(2),set.getInt(3),set.getDouble(4),set.getDouble(5)));

        }
        return list;
    }

    @Override
    public boolean deleteOrders(String text) throws ClassNotFoundException, SQLException {
        String sql = "delete from orders where custContact = ?";
        return CRUDUtill.executeUpdate(sql, text);
    }

}
