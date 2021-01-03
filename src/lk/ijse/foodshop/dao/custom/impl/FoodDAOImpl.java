/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dao.custom.impl;

import lk.ijse.foodshop.dao.CRUDUtill;
import lk.ijse.foodshop.dao.custom.FoodDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.foodshop.db.DBConnection;
import lk.ijse.foodshop.dto.CustomerDTO;
import lk.ijse.foodshop.dto.FoodDTO;
import lk.ijse.foodshop.entity.Food;

/**
 *
 * @author kushantha
 */
public class FoodDAOImpl implements FoodDAO {

    @Override
    public String getLastId() throws ClassNotFoundException, SQLException {
        String sql = "select foodId from food order by foodId desc limit 1";
        ResultSet set = CRUDUtill.executeQuery(sql);
        if (set.next()) {
            return set.getString("foodId");
        }

        return null;
    }

    @Override
    public boolean isAdded(Food food) throws ClassNotFoundException, SQLException {
        if (food.getQty() != null) {
            String sql = "insert into food values (?,?,?,?)";

            return CRUDUtill.executeUpdate(sql, food.getfId(), food.getDescription(), food.getUnitPrice(), food.getQty());
        } else {

            String sql = "insert into food(foodId,fName,unitPrice) values (?,?,?)";

            return CRUDUtill.executeUpdate(sql, food.getfId(), food.getDescription(), food.getUnitPrice());
        }

    }

    @Override
    public ArrayList<Food> loadAll() throws ClassNotFoundException, SQLException {

        String sql = "select * from food";

        ArrayList<Food> fd = new ArrayList<>();

        ResultSet set = CRUDUtill.executeQuery(sql);

        while (set.next()) {
            String id = set.getString(1);
            String description = set.getString(2);
            double unitPrice = set.getDouble(3);
            String qty = set.getString(4);
            Food food = new Food(id, description, unitPrice, qty);

            fd.add(food);
        }
        return fd;
    }

    @Override
    public boolean update(Food food) throws ClassNotFoundException, SQLException {

        String sql = "update food set fName = ?,unitPrice = ?,qty =? where foodId =?";

        return CRUDUtill.executeUpdate(sql, food.getDescription(), food.getUnitPrice(), food.getQty(), food.getfId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from food where foodId=?";
        return CRUDUtill.executeUpdate(sql, id);

    }

    @Override
    public ArrayList<Food> search(String value) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM food WHERE fName LIKE ?";
        ResultSet set = CRUDUtill.executeQuery(sql, "%" + value + "%");
        ArrayList<Food> list = new ArrayList<>();

        while (set.next()) {
            list.add(new Food(
                    set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getString(4))
            );

        }
        return list;
    }

    public String getQty(String fid) throws ClassNotFoundException, SQLException {

        String sql = "select qty from food where foodId =?";

        ResultSet set = CRUDUtill.executeQuery(sql, fid);
        if (set.next()) {
            return set.getString("qty");
        }

        return null;
    }
}
