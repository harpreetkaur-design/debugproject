package com.example.epharma.models;

public class product {

    public String productname;
    public String productcost;
    public String productacid;
    public String productimage;

    public product(String productname, String productcost, String productacid,String productimage) {
        this.productname = productname;
        this.productcost = productcost;
        this.productacid = productacid;
        this.productimage=productimage;
    }

    public product() {
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
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
