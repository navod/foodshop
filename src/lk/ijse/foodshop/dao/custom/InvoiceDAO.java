/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom;

import lk.ijse.foodshop.dao.SuperDAO;
import java.sql.SQLException;
import java.util.List;
import lk.ijse.foodshop.dto.InvoiceDTO;
import lk.ijse.foodshop.dto.QueryDTO;

/**
 *
 * @author kushantha
 */
public interface InvoiceDAO extends SuperDAO{

    public boolean isAdded(InvoiceDTO enty) throws ClassNotFoundException, SQLException;

    public String getLastId() throws ClassNotFoundException, SQLException ;
    
    public String checkContact(String text) throws ClassNotFoundException, SQLException;
    
    public List<QueryDTO> getAllOrders(String id) throws ClassNotFoundException, SQLException;

    public boolean deleteOrders(String text) throws ClassNotFoundException, SQLException;
    
}
