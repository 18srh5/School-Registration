/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolregistration;

/**
 *
 * @author samrh135
 */
public class EmergencyInfo {
    private String contact1Name,contact2Name, email1, email2, address1, address2, phone1, phone2;

    /**
     *  Constructor
     */
    public EmergencyInfo() {
        address1="";
        address2="";
        contact1Name="";
        contact2Name="";
        email1="";
        email2="";
        phone1="";
        phone2="";
    }

    /**
     *  overload constructor
     * @param contact1Name
     * @param contact2Name
     * @param email1
     * @param email2
     * @param address1
     * @param address2
     * @param phone1
     * @param phone2
     */
    public EmergencyInfo(String contact1Name, String contact2Name, String email1, String email2, String address1, String address2, String phone1, String phone2) {
        this.contact1Name = contact1Name;
        this.contact2Name = contact2Name;
        this.email1 = email1;
        this.email2 = email2;
        this.address1 = address1;
        this.address2 = address2;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    /**
     *
     * @return
     */
    public String getAddress1() {
        return address1;
    }

    /**
     *
     * @return
     */
    public String getAddress2() {
        return address2;
    }

    /**
     *
     * @return
     */
    public String getContact1Name() {
        return contact1Name;
    }

    /**
     *
     * @return
     */
    public String getContact2Name() {
        return contact2Name;
    }

    /**
     *
     * @return
     */
    public String getEmail1() {
        return email1;
    }

    /**
     *
     * @return
     */
    public String getEmail2() {
        return email2;
    }

    /**
     *
     * @return
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     *
     * @return
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     *
     * @param address1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     *
     * @param address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     *
     * @param contact1Name
     */
    public void setContact1Name(String contact1Name) {
        this.contact1Name = contact1Name;
    }

    /**
     *
     * @param contact2Name
     */
    public void setContact2Name(String contact2Name) {
        this.contact2Name = contact2Name;
    }

    /**
     *
     * @param email1
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    /**
     *
     * @param email2
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /**
     *
     * @param phone1
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     *
     * @param phone2
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     *  Sends all information in a single string
     * @return
     */
    @Override
    public String toString() {
        return "Contact 1\nName: " + contact1Name + "\nAddress: " + address1 + "\nEmail: " + email1
                + "\nPhone: " + phone1 + "\nContact 2\nName: " + contact2Name + "\nAddress: " + address2 + "\nEmail: " + email2
                + "\nPhone: " + phone2;
    }
    
    
}
