package com.utility.pojo;

public class Player {

    //private int Id; // not required as of now
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

}
