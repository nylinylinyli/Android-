package com.example.restaurantapplinuiyanbdt20051;

public class FoodBDT20051 {
    public int imgid;
    public String name;



    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgid() {
        return imgid;
    }

    public String getName() {
        return name;
    }

    public FoodBDT20051(int imgid, String name) {
        this.imgid = imgid;
        this.name = name;
    }
}
