package com.passonatetech.agrohub.model;

import java.sql.Time;
import java.util.Date;

public class Reminder {

    private String name;
    private String description;
    private String Seasons;
    private String typeofcrops;
    private String nameofCrop;
    private String Area;
    private String AreaSize;
    private String Quantity;
    private String Quantitymesure;
    private Date date;
    private Time time;

    public Reminder(String name, String description, String seasons, String typeofcrops, String nameofCrop, String area, String areaSize, String quantity, String quantitymesure, Date date, Time time) {
        this.name = name;
        this.description = description;
        Seasons = seasons;
        this.typeofcrops = typeofcrops;
        this.nameofCrop = nameofCrop;
        Area = area;
        AreaSize = areaSize;
        Quantity = quantity;
        Quantitymesure = quantitymesure;
        this.date = date;
        this.time = time;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeasons() {
        return Seasons;
    }

    public void setSeasons(String seasons) {
        Seasons = seasons;
    }

    public String getTypeofcrops() {
        return typeofcrops;
    }

    public void setTypeofcrops(String typeofcrops) {
        this.typeofcrops = typeofcrops;
    }

    public String getNameofCrop() {
        return nameofCrop;
    }

    public void setNameofCrop(String nameofCrop) {
        this.nameofCrop = nameofCrop;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getAreaSize() {
        return AreaSize;
    }

    public void setAreaSize(String areaSize) {
        AreaSize = areaSize;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getQuantitymesure() {
        return Quantitymesure;
    }

    public void setQuantitymesure(String quantitymesure) {
        Quantitymesure = quantitymesure;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }





}
