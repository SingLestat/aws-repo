package com.company;

public class Destroyer extends Ship{
    private int size = 3;
    private String name = "Destroyer";
    private String shipChar = "D ";

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
