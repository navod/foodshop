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
public class CustomerDTO {
    private String custId;
    private String contact;
    private String name;
    private String addrss;

    public CustomerDTO(String name, String addrss) {
        this.name = name;
        this.addrss = addrss;
    }

    public CustomerDTO(String custId, String contact, String name, String addrss) {
        this.custId = custId;
        this.contact = contact;
        this.name = name;
        this.addrss = addrss;
    }

    @Override
    public String toString() {
        return "Customer{" + "custId=" + getCustId() + ", contact=" + getContact() + ", name=" + getName() + ", addrss=" + getAddrss() + '}';
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the addrss
     */
    public String getAddrss() {
        return addrss;
    }

    /**
     * @param addrss the addrss to set
     */
    public void setAddrss(String addrss) {
        this.addrss = addrss;
    }
    
    
}
