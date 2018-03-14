package cn.edu.sdut.softlab.sqlitedemo;

/**
 * Created by subaochen on 17-4-26.
 */

public class People {
    public int id = -1;
    public String name;
    public int age;
    public float height;

    @Override
    public String toString() {
        String result = "";
        result += "id：" + this.id + "，";
        result += "姓名：" + this.name + "，";
        result += "年龄：" + this.age + "， ";
        result += "身高：" + this.height + "，";
        return result;
    }
}