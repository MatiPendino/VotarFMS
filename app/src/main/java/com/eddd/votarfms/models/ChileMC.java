package com.eddd.votarfms.models;

public class ChileMC {

    private String name;
    private int position, points;
    private double punctuation;

    public ChileMC(){

    }

    public ChileMC(String name, int position, int points, double punctuation) {
        this.name = name;
        this.position = position;
        this.points = points;
        this.punctuation = punctuation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(double punctuation) {
        this.punctuation = punctuation;
    }
}
