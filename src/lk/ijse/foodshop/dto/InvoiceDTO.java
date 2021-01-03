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
public class InvoiceDTO {
    private String invoicId;
    private String date;
    private ArrayList<InvoiceDetailDTO> getPurchase;

    public InvoiceDTO(String invoicId, String date, ArrayList<InvoiceDetailDTO> getPurchase) {
        this.invoicId = invoicId;
        this.date = date;
        this.getPurchase = getPurchase;
    }

    public InvoiceDTO(String invoicId, String date) {
        this.invoicId = invoicId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoicId=" + invoicId + ", date=" + date + ", getPurchase=" + getPurchase + '}';
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
     * @return the getPurchase
     */
    public ArrayList<InvoiceDetailDTO> getPurchase() {
        return getPurchase;
    }

    /**
     * @param getPurchase the getPurchase to set
     */
    public void setGetPurchase(ArrayList<InvoiceDetailDTO> getPurchase) {
        this.getPurchase = getPurchase;
    }
}
