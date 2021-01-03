/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.custom.OrderDetailDAO;
import lk.ijse.foodshop.controller.FoodController;
import lk.ijse.foodshop.dao.CRUDUtill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.OrderDetailDTO;

/**
 *
 * @author kushantha
 */
public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public boolean addOrderDetail(ArrayList<OrderDetailDTO> list) throws ClassNotFoundException, SQLException {
        for (OrderDetailDTO temp : list) {
            boolean isAdded = addItem(temp);
            if (!isAdded) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addItem(OrderDetailDTO detail) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO orderDetail VALUES(?,?,?,?)";
        return CRUDUtill.executeUpdate(sql, detail.getOid(), detail.getFid(), detail.getQty(), detail.getTotal());
    }

    @Override
    public boolean updateQTY(ArrayList<OrderDetailDTO> orderDetails) throws ClassNotFoundException, SQLException {

        for (OrderDetailDTO detail : orderDetails) {
            String isAvailableQty = new FoodController().getQty(detail.getFid());
            if (isAvailableQty.equals("")) {

            } else if (isAvailableQty != null) {
                String sql = "UPDATE food SET qty=(qty-?) WHERE foodId=?";

                if (!(CRUDUtill.executeUpdate(sql, detail.getQty(), detail.getFid()))) {
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public boolean deleteFoods(String id, String qty) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getInstance().getConnection();

        String sql1 = "delete from orderdetail where foodId =?";
//        return CRUDUtill.executeUpdate(sql, id);
        boolean isDelete = CRUDUtill.executeUpdate(sql1, id);
        if (isDelete) {
            String checkQty = new FoodController().getQty(id);
            if (checkQty.equals("")) {

            } else if (checkQty != null) {
                String sql2 = "UPDATE food SET qty=(qty+?) WHERE foodId=?";
                if (!CRUDUtill.executeUpdate(sql2, qty, id)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean updateQTY(int qty, String fid, double total) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE orderdetail SET qty=?,total=? WHERE foodId=?";

        return CRUDUtill.executeUpdate(sql, qty, total, fid);

    }

    @Override
    public boolean updateFoodQty(String qty, String tblQty, String id) throws ClassNotFoundException, SQLException {
        String checkQty = new FoodController().getQty(id);
        if (checkQty.equals("")) {

        } else if (checkQty != null) {
            String sql2 = "UPDATE food SET qty=(qty+?-?) WHERE foodId=?";
            if (!CRUDUtill.executeUpdate(sql2, tblQty, qty,id)) {
                return false;
            }
        }
        return true;
    }
    
}
