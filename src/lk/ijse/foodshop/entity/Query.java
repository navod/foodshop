/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.entity;

/**
 *
 * @author kushantha
 */
public class Query {
    private String oid;
    private String fId;
    private String description;
    private int qty;
    private String date;
    private String custContact;
    private double total;

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    private double unitPrice;

    public Query(String oid, String fId, String description, int qty, String date, String custContact, double total) {
        this.oid = oid;
        this.fId = fId;
        this.description = description;
        this.qty = qty;
        this.date = date;
        this.custContact = custContact;
        this.total = total;
    }

    public Query(String fId, String description, int qty, double total,double unitPrice) {
        this.fId = fId;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        
    }

    @Override
    public String toString() {
        return "Query{" + "oid=" + oid + ", fId=" + fId + ", description=" + description + ", qty=" + qty + ", date=" + date + ", custContact=" + custContact + ", total=" + total + ", unitPrice=" + unitPrice + '}';
    }

    

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the custContact
     */
    public String getCustContact() {
        return custContact;
    }

    /**
     * @param custContact the custContact to set
     */
    public void setCustContact(String custContact) {
        this.custContact = custContact;
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
