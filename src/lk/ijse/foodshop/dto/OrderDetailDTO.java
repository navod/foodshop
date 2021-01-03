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
public class OrderDetailDTO {
    private String oid;
    private String fid;
    private int qty;
    private double total;

    public OrderDetailDTO(String oid, String fid, int qty, double total) {
        this.oid = oid;
        this.fid = fid;
        this.qty = qty;
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "oid=" + getOid() + ", fid=" + getFid() + ", qty=" + getQty() + ", total=" + getTotal() + '}';
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
     * @return the fid
     */
    public String getFid() {
        return fid;
    }

    /**
     * @param fid the fid to set
     */
    public void setFid(String fid) {
        this.fid = fid;
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
