package com.example.epharma.models;
/**
 * Pojo for shopping details
 * @author Manpreet kaur
 */
public class shoppingDetails {


    public String email;
    public String contactNumber;
    public String address;

    public String postalCode;
    public String city;
    public String province;
    public String productname;
    public String productcost;
    public String productacid;

    public shoppingDetails(String email, String contactNumber, String address, String postalCode, String city, String province,  String productname, String productcost, String productacid) {

        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
            this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.productname = productname;
        this.productcost = productcost;
        this.productacid = productacid;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }



    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductcost() {
        return productcost;
    }

    public void setProductcost(String productcost) {
        this.productcost = productcost;
    }

    public String getProductacid() {
        return productacid;
    }

    public void setProductacid(String productacid) {
        this.productacid = productacid;
    }
}
