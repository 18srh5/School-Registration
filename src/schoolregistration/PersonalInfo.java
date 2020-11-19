/*
 *Personal Information Class
    -contains info about student
 */
package schoolregistration;

public class PersonalInfo {

    private String firstName, lastName, street, city, province, postalCode, phone;

    /**
     * constructor
     */
    public PersonalInfo() {
        this.firstName = "";
        this.lastName = "";
        this.street = "";
        this.city = "";
        this.province = "";
        this.phone = "";
        this.postalCode = "";
    }

    /**
     * overload constructor
     * @param firstName
     * @param lastName
     * @param street
     * @param city
     * @param province
     * @param phone
     * @param postalCode
     */
    public PersonalInfo(String firstName, String lastName, String street, String city, String province, String phone, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.province = province;
        this.phone = phone;
        this.postalCode = postalCode;
    }

    /**
     * 
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     *
     * @return
     */
    public String getProvince() {
        return province;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * returns all information in a single string
     * @return
     */
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nAddress:" + street + " " + province
                 +" " + city + " " + postalCode + "\nPhone: " + phone;
    }

    //@Override

    /**
     * if both the first and last name are the same, then the objects are the same. 
     * @param o
     * @return
     */
    public boolean equals(PersonalInfo o) {
        if (this.firstName.equals(o.getFirstName()) && this.lastName.equals(o.getLastName())) {
            return true;
        }
        return false;
    }

}
