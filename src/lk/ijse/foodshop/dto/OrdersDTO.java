/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodshop.dto;

import java.util.ArrayList;

/**
 *
 * @author kushantha
 */
public class OrdersDTO {
    private String oid;
    private String Contact;
    private String date;
    private ArrayList<OrderDetailDTO> orderDetails;

    public OrdersDTO(String oid, String Contact, String date, ArrayList<OrderDetailDTO> orderDetails) {
        this.oid = oid;
        this.Contact = Contact;
        this.date = date;
        this.orderDetails = orderDetails;
    }

    public OrdersDTO(String oid, String Contact, String date) {
        this.oid = oid;
        this.Contact = Contact;
        this.date = date;
    }
    @Override
    public String toString() {
        return "Orders{" + "oid=" + getOid() + ", Contact=" + getContact() + ", date=" + getDate() + ", orderDetails=" + getOrderDetails() + '}';
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
     * @return the Contact
     */
    public String getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(String Contact) {
        this.Contact = Contact;
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
     * @return the orderDetails
     */
    public ArrayList<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    /**
     * @param orderDetails the orderDetails to set
     */
    public void setOrderDetails(ArrayList<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
