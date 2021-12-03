package com.eddd.votarfms.models;

public class SpainMC {

    private String name;
    private int position, points;
    private double punctuation;

    public SpainMC(){

    }

    public SpainMC(String name, int position, int points, double punctuation){

        this.name = name;
        this.position = position;
        this.points = points;
        this.punctuation = punctuation;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getPoints() {
        return points;
    }

    public double getPunctuation() {
        return punctuation;
    }

}
