/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom;

import java.sql.SQLException;
import java.util.List;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.dao.CRUDDAO;
import lk.ijse.foodshop.entity.Food;
import java.util.ArrayList;

/**
 *
 * @author kushantha
 */
public interface FoodDAO extends CRUDDAO<Food,String>{

    public String getQty(String fid)throws ClassNotFoundException, SQLException ;
    public ArrayList<Food> loadAll() throws ClassNotFoundException, SQLException;
}
