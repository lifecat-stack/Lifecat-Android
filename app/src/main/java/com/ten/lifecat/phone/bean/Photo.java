package com.ten.lifecat.phone.bean;

/**
 * @author 59682
 * @name Photo
 * @description adapter-item实体类--包含Image+Text
 */
public class Photo {
    private String name;
    private int imageId;

    public Photo(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
