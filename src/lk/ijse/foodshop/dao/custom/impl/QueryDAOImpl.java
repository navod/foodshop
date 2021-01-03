/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.custom.QueryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.QueryDTO;

/**
 *
 * @author kushantha
 */
public class QueryDAOImpl implements QueryDAO{

    @Override
    public List<QueryDTO> getAllOrders() throws ClassNotFoundException, SQLException {
       Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select orders.oid,food.foodId,fName,OrderDetail.qty,Orders.inDate,Orders.custContact,total\n"
                + "from orders cross join orderdetail cross join food on\n"
                + "orders.oid = orderdetail.oid and food.foodId = orderdetail.foodId order by orderdetail.oid asc";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet set = pstm.executeQuery();

        List<QueryDTO> list = new ArrayList<>();
        while (set.next()) {
            list.add(new QueryDTO(set.getString(1), set.getString(2),set.getString(3), set.getInt(4), set.getString(5), set.getString(6), set.getDouble(7)));

        }
        return list;
    }

    @Override
    public ArrayList<QueryDTO> searchOrders(String value) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select orders.oid,food.foodId,fName,OrderDetail.qty,Orders.inDate,Orders.custContact,total\n"
                + "from orders cross join orderdetail cross join food on\n"
                + "orders.oid = orderdetail.oid and food.foodId = orderdetail.foodId "
                + "where orders.oid like ? ||  food.foodId like ? || fName like ? || inDate like ? || custContact like ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
         pstm.setString(1, "%" + value + "%");
        pstm.setString(2, "%" + value + "%");
        pstm.setString(3, "%" + value + "%");
        pstm.setString(4, "%" + value + "%");
        pstm.setString(5, "%" + value + "%");
        ResultSet set = pstm.executeQuery();

        ArrayList<QueryDTO> list = new ArrayList<>();
        while (set.next()) {
            list.add(new QueryDTO(set.getString(1), set.getString(2),set.getString(3), set.getInt(4), set.getString(5), set.getString(6), set.getDouble(7)));

        }
        return list;
    }
}
