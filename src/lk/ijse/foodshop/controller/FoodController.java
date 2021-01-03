/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.controller;

import lk.ijse.foodshop.bo.BOFactory;
import lk.ijse.foodshop.bo.custom.FoodBO;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.FoodDAO;
import lk.ijse.foodshop.dao.custom.impl.FoodDAOImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;

/**
 *
 * @author kushantha
 */
public class FoodController {
//    FoodDAO f1 = (FoodDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
    FoodBO f1 =(FoodBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FOOD);
    public String getLastId() throws ClassNotFoundException, SQLException {
       return f1.getLastId();
    }
    public ArrayList<FoodDTO> loadAllFood() throws ClassNotFoundException, SQLException{
        return f1.getAllFood();
    }

    public boolean updateFood(FoodDTO food) throws ClassNotFoundException, SQLException{
        return f1.updateFood(food);
    }


    public boolean deleteFood(String id) throws ClassNotFoundException, SQLException{
        return f1.deleteFood(id);
    }

    public List<FoodDTO> searchFoods(String value) throws ClassNotFoundException, SQLException{
        return f1.searchFood(value);
    }
    public boolean isAddedFood(FoodDTO food) throws ClassNotFoundException, SQLException{
        return f1.addFood(food);
    }

    public String getQty(String fid) throws ClassNotFoundException, SQLException {
        return f1.getQty(fid);
    }
}
