package com.example.project.Model;

import java.util.ArrayList;

public class MusicDeviceOrders {
    ArrayList<MusicDeviceOrder> musicDeviceOrders;

    public MusicDeviceOrders(ArrayList<MusicDeviceOrder> musicDeviceOrders) {
        this.musicDeviceOrders = musicDeviceOrders;
    }

    public ArrayList<MusicDeviceOrder> getMusicDeviceOrders() {
        return musicDeviceOrders;
    }

    public void setMusicDeviceOrders(ArrayList<MusicDeviceOrder> musicDeviceOrders) {
        this.musicDeviceOrders = musicDeviceOrders;
    }

}
