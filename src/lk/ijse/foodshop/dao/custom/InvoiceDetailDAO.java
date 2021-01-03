/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom;

import lk.ijse.foodshop.dao.SuperDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.foodshop.dto.InvoiceDTO;
import lk.ijse.foodshop.dto.InvoiceDetailDTO;
import lk.ijse.foodshop.dto.OrderDetailDTO;

/**
 *
 * @author kushantha
 */
public interface InvoiceDetailDAO extends SuperDAO{
    public boolean addInvoiceDetail(ArrayList<InvoiceDetailDTO> list) throws ClassNotFoundException, SQLException;
     public boolean addItem(InvoiceDetailDTO detail) throws ClassNotFoundException, SQLException;
     public boolean updateQTY(ArrayList<InvoiceDetailDTO> orderDetails) throws ClassNotFoundException, SQLException;
}
