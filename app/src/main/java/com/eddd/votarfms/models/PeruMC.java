package com.eddd.votarfms.models;

public class PeruMC {

    private String name;
    private int position, points;
    private double punctuation;

    public PeruMC(){

    }

    public PeruMC(String name, int position, int points, double punctuation){

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
