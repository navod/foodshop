/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.dao.custom.QueryDAO;
import lk.ijse.foodshop.dao.custom.impl.QueryDAOImpl;
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
public class QuerController {
    QueryDAO d1 = new QueryDAOImpl();
    public List<QueryDTO> getAllOrders() throws ClassNotFoundException, SQLException {
        return d1.getAllOrders();
    }
}
