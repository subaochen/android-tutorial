package cn.edu.sdut.android.recyclerviewdemo;

public class Fruit {
    private String name;
    private int imageId;
    private String color;

    public Fruit(String name, int imageId, String color) {
        this.name = name;
        this.imageId = imageId;
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

    public String getColor(){
        return color;
    }
}
