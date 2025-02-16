package com.example.project.Model;

public class MusicDeviceOrder {

    MusicDevice musicDevice;
    int quantity;

    public MusicDeviceOrder(MusicDevice musicDevice, int num) {
        this.musicDevice = musicDevice;
        this.quantity = num;
    }

    public MusicDevice getMusicDevice() {
        return musicDevice;
    }

    public void setMusicDevice(MusicDevice musicDevice) {
        this.musicDevice = musicDevice;
    }

    public int getNum() {
        return quantity;
    }

    public void setNum(int num) {
        this.quantity = num;
    }
}
