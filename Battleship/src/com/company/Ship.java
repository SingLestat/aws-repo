package com.company;

abstract class Ship{
    private int size;
    private String name;
    private String shipChar;

    public Ship(){};

    abstract int getSize();
    abstract void setSize(int size);
    abstract String getName();
    abstract void setName(String name);
    abstract String getShipChar();
    abstract void setShipChar(String shipChar);
    }
