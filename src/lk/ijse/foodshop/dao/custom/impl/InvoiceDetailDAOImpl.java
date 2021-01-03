/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.controller.FoodController;
import lk.ijse.foodshop.dao.CRUDUtill;
import lk.ijse.foodshop.dao.custom.InvoiceDetailDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.InvoiceDTO;
import lk.ijse.foodshop.dto.InvoiceDetailDTO;
import lk.ijse.foodshop.dto.QueryDTO;
import lk.ijse.foodshop.dto.OrderDetailDTO;

/**
 *
 * @author kushantha
 */
public class InvoiceDetailDAOImpl implements InvoiceDetailDAO {

    @Override
    public boolean addInvoiceDetail(ArrayList<InvoiceDetailDTO> list) throws ClassNotFoundException, SQLException {
 
        for (InvoiceDetailDTO temp : list) {
            boolean isAdded = addItem(temp);
            if (!isAdded) {
                return false;
            }
        }
        return true;
    
    }

    @Override
    public boolean addItem(InvoiceDetailDTO detail) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO invoicedetail VALUES(?,?,?,?)";
        return CRUDUtill.executeUpdate(sql, detail.getInvoicId(), detail.getFoodId(), detail.getQty(), detail.getTotal());
    }

    @Override
    public boolean updateQTY(ArrayList<InvoiceDetailDTO> orderDetails) throws ClassNotFoundException, SQLException {
        for (InvoiceDetailDTO detail : orderDetails) {
            String isAvailableQty = new FoodController().getQty(detail.getFoodId());
            if (isAvailableQty.equals("")) {

            } else if (isAvailableQty != null) {
                String sql = "UPDATE food SET qty=(qty-?) WHERE foodId=?";

                if (!(CRUDUtill.executeUpdate(sql, detail.getQty(), detail.getFoodId()))) {
                    return false;
                }
            }

        }
        return true;
    }


}
