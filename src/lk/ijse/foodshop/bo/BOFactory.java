/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.bo;

import lk.ijse.foodshop.bo.custom.impl.CustomerBOImpl;
import lk.ijse.foodshop.bo.custom.impl.FoodBOImpl;
import lk.ijse.foodshop.bo.custom.impl.InvoiceBOImpl;
import lk.ijse.foodshop.bo.custom.impl.PurchaseOrderBOImpl;
import lk.ijse.foodshop.bo.custom.InvoiceBO;
import lk.ijse.foodshop.bo.custom.impl.LoginBOImpl;
import lk.ijse.foodshop.dao.custom.impl.LoginDAOImpl;

/**
 *
 * @author kushantha
 */
public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        CUSTOMER, FOOD, PURCHASEORDER, PURCHASEBILL, LOGIN
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case FOOD:
                return new FoodBOImpl();
            case PURCHASEORDER:
                return new PurchaseOrderBOImpl();
            case PURCHASEBILL:
                return new InvoiceBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            default:
                return null;

        }
    }
}
