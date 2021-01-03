/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom;

import lk.ijse.foodshop.dao.CRUDDAO;
import lk.ijse.foodshop.dao.SuperDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.dto.QueryDTO;

/**
 *
 * @author kushantha
 */
public interface QueryDAO extends SuperDAO {
    public List<QueryDTO> getAllOrders() throws ClassNotFoundException, SQLException;

    public ArrayList<QueryDTO> searchOrders(String text)throws ClassNotFoundException, SQLException;
}
