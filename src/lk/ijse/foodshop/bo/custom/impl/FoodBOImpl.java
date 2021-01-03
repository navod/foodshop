/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo.custom.impl;

import lk.ijse.foodshop.bo.custom.FoodBO;
import lk.ijse.foodshop.dao.DAOFactory;
import lk.ijse.foodshop.dao.custom.FoodDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.entity.Food;

/**
 *
 * @author kushantha
 */
public class FoodBOImpl implements FoodBO {

    FoodDAO dao = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);

    @Override
    public boolean addFood(FoodDTO food) throws ClassNotFoundException, SQLException {
        return dao.isAdded(new Food(food.getfId(), food.getDescription(), food.getUnitPrice(), food.getQty()));
    }

    @Override
    public boolean updateFood(FoodDTO food) throws ClassNotFoundException, SQLException {
        return dao.update(new Food(food.getfId(), food.getDescription(), food.getUnitPrice(), food.getQty()));
    }

    @Override
    public boolean deleteFood(String foodID) throws ClassNotFoundException, SQLException {
        return dao.delete(foodID);
    }

    @Override
    public ArrayList<FoodDTO> searchFood(String value) throws ClassNotFoundException, SQLException{
       ArrayList<FoodDTO> all = new ArrayList<>() ;
        ArrayList<Food> allFoods = dao.search(value);
        allFoods.forEach(e -> {
            all.add(new FoodDTO(e.getfId(), e.getDescription(), e.getUnitPrice(), e.getQty()));
        });
        return all;
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws ClassNotFoundException, SQLException {
        ArrayList<FoodDTO> all = new ArrayList<>();
        ArrayList<Food> allFood = dao.loadAll();
//        for (FoodDTO c : all) {
//            allFood.add(new FoodDTO(c.getfId(), c.getDescription(), c.getUnitPrice(), c.getQty()));
//        }
//        return allFood;
        allFood.forEach(e -> {
            all.add(new FoodDTO(e.getfId(), e.getDescription(), e.getUnitPrice(), e.getQty()));
        });
        return all;
    }

    @Override
    public String getLastId() throws ClassNotFoundException, SQLException {
        return dao.getLastId();
    }

    @Override
    public String getQty(String fid) throws ClassNotFoundException, SQLException {
       return dao.getQty(fid);
    }

}
