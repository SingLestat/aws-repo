package com.company;

public class Carrier extends Ship{
    private int size = 5;
    private String name = "Carrier";
    private String shipChar = "C ";

    @Override
    int getSize(){
        return size;
    }

    @Override
    void setSize(int size){
        this.size = size;
    }

    @Override
    String getName(){
        return name;
    }

    @Override
    void setName(String name){
        this.name = name;
    }

    @Override
    String getShipChar(){
        return shipChar;
    }

    @Override
    void setShipChar(String shipChar){
        this.shipChar  = shipChar;
    }
}
