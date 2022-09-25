/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.HashMap;
import java.util.Map;
import model.Autopart;

/**
 *
 * @author Lenovo
 */
public class ApartData { // Lab 8

    private final Map<String, Autopart> apartMap = new HashMap<>();
    private static final ApartData instance = new ApartData();

    public static ApartData getInstance() {
        return instance;
    }

    private ApartData() {
        apartMap.put("A1", new Autopart("A1", "motor", "car", 1000)); // ไม่ลองรับภาษาไทยไม่ได้
        apartMap.put("A2", new Autopart("A2", "battery", "car", 3000));
        apartMap.put("A3", new Autopart("A3", "brakes", "car", 500));
    }

    public Autopart getAutopart(String name) {
        return apartMap.get(name);
    }

    public void putAutopart(Autopart autopart) {
        apartMap.put(autopart.getName(), autopart);
    }

}
