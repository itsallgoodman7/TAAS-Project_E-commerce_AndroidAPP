package com.example.project.Model;

import java.io.Serializable;

public class MusicDevice implements Serializable {

    private Long id;
    private String name;
    private MusicDeviceCategories category;
    private Double price;
    private String pictureUrl;
    private String description;


    public MusicDevice(Long id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public MusicDevice(Long id, String name, Double price, MusicDeviceCategories category, String pictureUrl, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.category = category;
        this.description = description;
    }

    public MusicDevice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public MusicDeviceCategories getCategory() { return category;}

    public void setCategory(MusicDeviceCategories category) {this.category = category;}

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public static MusicDeviceCategories stringToCategory(String category){
        switch (category){

            case "Consumer":
                return MusicDeviceCategories.Consumer;
            case "Acoustic":
                return MusicDeviceCategories.Acoustic;
            case "MIDIProduction":
                return MusicDeviceCategories.MIDIProduction;
            default:
                return null;

        }

    }

    @Override
    public String toString() {
        return "MusicDevice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
