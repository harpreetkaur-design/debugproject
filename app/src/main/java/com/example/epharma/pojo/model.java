package com.example.epharma.pojo;

public class model {
    private String productname;
    private String productacid;
    private String productcost;

    public model() {
    }

    public model(String productname, String productacid, String productcost) {
        this.productname = productname;
        this.productacid = productacid;
        this.productcost = productcost;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductacid() {
        return productacid;
    }

    public void setProductacid(String productacid) {
        this.productacid = productacid;
    }

    public String getProductcost() {
        return productcost;
    }

    public void setProductcost(String productcost) {
        this.productcost = productcost;
    }
}
