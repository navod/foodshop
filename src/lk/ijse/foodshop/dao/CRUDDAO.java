/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.dto.CustomerDTO;

/**
 *
 * @author kushantha
 */
public interface CRUDDAO<T, ID> extends SuperDAO{

    public boolean isAdded(T enty) throws ClassNotFoundException, SQLException;

//    public ArrayList<T> loadAll() throws ClassNotFoundException, SQLException;

    public boolean update(T enty) throws ClassNotFoundException, SQLException;

    public String getLastId() throws ClassNotFoundException, SQLException;

    public boolean delete(ID id) throws ClassNotFoundException, SQLException;

    public ArrayList<T> search(ID id) throws ClassNotFoundException, SQLException;
}
