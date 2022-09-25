/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Autopart {
    private String pid;
    private String name;
    private String type;
    private int price;

    public Autopart(String pid, String name, String type, int price) {
        this.pid= pid;
        this.name = name;
        this.type = type;
        this.price = price;
   
    }
    public String getPid(){
        return pid;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getPrice() {
        return price;
    }
}
