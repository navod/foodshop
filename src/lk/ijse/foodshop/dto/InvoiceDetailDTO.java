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
public class InvoiceDetailDTO {
    private String invoicId;
    private String foodId;
    private int qty;
    private double total;

    public InvoiceDetailDTO(String invoicId, String foodId, int qty, double total) {
        this.invoicId = invoicId;
        this.foodId = foodId;
        this.qty = qty;
        this.total = total;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" + "invoicId=" + getInvoicId() + ", foodId=" + getFoodId() + ", qty=" + getQty() + ", total=" + getTotal() + '}';
    }

    /**
     * @return the invoicId
     */
    public String getInvoicId() {
        return invoicId;
    }

    /**
     * @param invoicId the invoicId to set
     */
    public void setInvoicId(String invoicId) {
        this.invoicId = invoicId;
    }

    /**
     * @return the foodId
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     * @param foodId the foodId to set
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
