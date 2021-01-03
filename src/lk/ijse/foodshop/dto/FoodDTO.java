/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dto;

/**
 *
 * @author kushantha
 */
public class FoodDTO {
    private String fId;
    private String description;
    private double unitPrice;
    private String qty;

    public FoodDTO() {
    }

    public FoodDTO(String fId, String description, double unitPrice, String qty) {
        this.fId = fId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public FoodDTO(String fId, String description, double unitPrice) {
        this.fId = fId;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public FoodDTO(String fId, double unitPrice, String qty) {
        this.fId = fId;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Food{" + "fId=" + getfId() + ", description=" + getDescription() + ", unitPrice=" + getUnitPrice() + ", qty=" + getQty() + '}';
    }

    /**
     * @return the fId
     */
    public String getfId() {
        return fId;
    }

    /**
     * @param fId the fId to set
     */
    public void setfId(String fId) {
        this.fId = fId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    
    
}
