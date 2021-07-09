package com.company;

public class Battleship extends Ship{
    private int size = 4;
    private String name = "Battleship";
    private String shipChar = "B ";
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
