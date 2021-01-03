/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom;

import lk.ijse.foodshop.bo.SuperBO;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.entity.Food;

/**
 *
 * @author kushantha
 */
public interface FoodBO extends SuperBO{
    public boolean addFood(FoodDTO food) throws ClassNotFoundException, SQLException;
    public boolean updateFood(FoodDTO food) throws ClassNotFoundException, SQLException;
    public boolean deleteFood(String foodID) throws ClassNotFoundException, SQLException;
    public ArrayList<FoodDTO> searchFood(String foodDesc) throws ClassNotFoundException, SQLException;
    public ArrayList<FoodDTO> getAllFood() throws ClassNotFoundException, SQLException ;
    public String getLastId() throws ClassNotFoundException, SQLException;

    public String getQty(String fid)throws ClassNotFoundException, SQLException;
}
