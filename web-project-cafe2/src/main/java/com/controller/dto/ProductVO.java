package com.controller.dto;

public class ProductVO {
    private int num;
    private String name;
    private int price;
    private String description;
    private String pictureurl;

    public int getNum() { return num; }
    public void setNum(int num) { this.num = num; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPictureurl() { return pictureurl; }
    public void setPictureurl(String pictureurl) { this.pictureurl = pictureurl; }
}
