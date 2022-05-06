package com.creatures.cateringappdemo;

public class ModelClass {

    private int ID;
    private String name;
    private String description;
    private String img_link;


    public ModelClass(int ID, String name, String img_link) {
        this.ID = ID;
        this.name = name;
        this.img_link = img_link;
    }

    public ModelClass(int ID, String name, String description, String img_link) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.img_link = img_link;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getImg_link() {
        return img_link;
    }

    public String getDescription() {
        return description;
    }

}
