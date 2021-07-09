package com.company;

public class PatrolBoat extends Ship{
    private int size = 2;
    private String name = "Patrol Boat";
    private String shipChar = "P ";

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
