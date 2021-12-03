package com.eddd.votarfms.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class Batalla implements Parcelable {

    //en estas variables se almacenarán los puntos totales de todas las rondas, y los puntos finales de toda la batalla
    private float pointsFMEasyMode, pointsFMHardMode, pointsFMThemes, pointsFMRandomMode, pointsFMBloodMode, pointsFMDeluxeMode, totalPointsFM;
    private float pointsSMEasyMode, pointsSMHardMode, pointsSMThemes, pointsSMRandomMode, pointsSMBloodMode, pointsSMDeluxeMode, totalPointsSM;

    //en estas variables se almacenarán el nombre de la liga seleccionada, y el nombre de los mcs elegidos
    private String mLeague, mFirstMc, mSecondMc, mWinner;

    private static final String JSON_FIRST_EASY = "firstEasy";
    private static final String JSON_FIRST_HARD = "firstHard";
    private static final String JSON_FIRST_THEMES = "firstThemes";
    private static final String JSON_FIRST_RANDOM = "firstRandom";
    private static final String JSON_FIRST_BLOOD = "firstBlood";
    private static final String JSON_FIRST_DELUXE = "firstDeluxe";
    private static final String JSON_FIRST_TOTAL = "firstTotal";

    private static final String JSON_SECOND_EASY = "secondEasy";
    private static final String JSON_SECOND_HARD = "secondHard";
    private static final String JSON_SECOND_THEMES = "secondThemes";
    private static final String JSON_SECOND_RANDOM = "secondRandom";
    private static final String JSON_SECOND_BLOOD = "secondBlood";
    private static final String JSON_SECOND_DELUXE = "secondDeluxe";
    private static final String JSON_SECOND_TOTAL = "secondTotal";

    private static final String JSON_FIRST_NAME = "firstName";
    private static final String JSON_SECOND_NAME = "secondName";
    private static final String JSON_LEAGUE = "league";
    private static final String JSON_WINNER= "winner";

    public Batalla( String firstMc, String secondMc,String league, String winner, float pointsFirstEasy, float pointsFirstHard,
                    float pointsFirstThemes, float pointsFirstRandom, float pointsFirstBlood, float pointsFirstDeluxe,
                    float totalPointsFirst, float pointsSecondEasy, float pointsSecondHard, float pointsSecondThemes,
                    float pointsSecondRandom, float pointsSecondBlood, float pointsSecondDeluxe, float totalPointsSecond){

        this.mFirstMc = firstMc;
        this.mSecondMc = secondMc;
        this.mLeague = league;
        this.mWinner = winner;
        this.pointsFMEasyMode = pointsFirstEasy;
        this.pointsFMHardMode = pointsFirstHard;
        this.pointsFMThemes = pointsFirstThemes;
        this.pointsFMRandomMode = pointsFirstRandom;
        this.pointsFMBloodMode = pointsFirstBlood;
        this.pointsFMDeluxeMode = pointsFirstDeluxe;
        this.totalPointsFM = totalPointsFirst;
        this.pointsSMEasyMode = pointsSecondEasy;
        this.pointsSMHardMode = pointsSecondHard;
        this.pointsSMThemes = pointsSecondThemes;
        this.pointsSMRandomMode = pointsSecondRandom;
        this.pointsSMBloodMode = pointsSecondBlood;
        this.pointsSMDeluxeMode = pointsSecondBlood;
        this.pointsSMDeluxeMode = pointsSecondDeluxe;
        this.totalPointsSM = totalPointsSecond;


    }

    //constructor para crear una batalla a partir de un objeto JSON
    public Batalla(JSONObject jsonObject) throws JSONException{

        //obtengo el dato en formato JSON con el "get" y lo asigno a la variable que forma parte de la batalla creada
        mFirstMc = jsonObject.getString(JSON_FIRST_NAME);
        mSecondMc = jsonObject.getString(JSON_SECOND_NAME);
        mLeague = jsonObject.getString(JSON_LEAGUE);
        mWinner = jsonObject.getString(JSON_WINNER);

        pointsFMEasyMode =(float) jsonObject.getInt(JSON_FIRST_EASY);
        pointsFMHardMode = (float) jsonObject.getInt(JSON_FIRST_HARD);
        pointsFMThemes= (float) jsonObject.getInt(JSON_FIRST_THEMES);
        pointsFMRandomMode = (float) jsonObject.getInt(JSON_FIRST_RANDOM);
        pointsFMBloodMode = (float) jsonObject.getInt(JSON_FIRST_BLOOD);
        pointsFMDeluxeMode = (float) jsonObject.getInt(JSON_FIRST_DELUXE);
        totalPointsFM = (float) jsonObject.getInt(JSON_FIRST_TOTAL);

        pointsSMEasyMode = (float) jsonObject.getInt(JSON_SECOND_EASY);
        pointsSMHardMode = (float) jsonObject.getInt(JSON_SECOND_HARD);
        pointsSMThemes = (float) jsonObject.getInt(JSON_SECOND_THEMES);
        pointsSMRandomMode = (float) jsonObject.getInt(JSON_SECOND_RANDOM);
        pointsSMBloodMode = (float) jsonObject.getInt(JSON_SECOND_BLOOD);
        pointsSMDeluxeMode = (float) jsonObject.getInt(JSON_SECOND_DELUXE);
        totalPointsSM = (float) jsonObject.getInt(JSON_SECOND_TOTAL);

    }

    //este método toma todas las variables de la batalla y las serializa en un objeto de tipo JSON
    public JSONObject convertBattleToJSON() throws JSONException{

        JSONObject jsonObject = new JSONObject();

        jsonObject.put(JSON_FIRST_NAME, mFirstMc); //el String creado (JSON_FIRST_NAME) se serializa en JSON, tomando el valor de mFirstMc
        jsonObject.put(JSON_SECOND_NAME, mSecondMc);
        jsonObject.put(JSON_WINNER, mWinner);
        jsonObject.put(JSON_LEAGUE, mLeague);

        jsonObject.put(JSON_FIRST_EASY, pointsFMEasyMode);
        jsonObject.put(JSON_FIRST_HARD, pointsFMHardMode);
        jsonObject.put(JSON_FIRST_THEMES, pointsFMThemes);
        jsonObject.put(JSON_FIRST_RANDOM, pointsFMRandomMode);
        jsonObject.put(JSON_FIRST_BLOOD, pointsFMBloodMode);
        jsonObject.put(JSON_FIRST_DELUXE, pointsFMDeluxeMode);
        jsonObject.put(JSON_FIRST_TOTAL, totalPointsFM);

        jsonObject.put(JSON_SECOND_EASY, pointsSMEasyMode);
        jsonObject.put(JSON_SECOND_HARD, pointsSMHardMode);
        jsonObject.put(JSON_SECOND_THEMES, pointsSMThemes);
        jsonObject.put(JSON_SECOND_RANDOM, pointsSMRandomMode);
        jsonObject.put(JSON_SECOND_BLOOD, pointsSMBloodMode);
        jsonObject.put(JSON_SECOND_DELUXE, pointsSMDeluxeMode);
        jsonObject.put(JSON_SECOND_TOTAL, totalPointsSM);

        return jsonObject;
    }

    protected Batalla(Parcel in) {
        pointsFMEasyMode = in.readFloat();
        pointsFMHardMode = in.readFloat();
        pointsFMThemes = in.readFloat();
        pointsFMRandomMode = in.readFloat();
        pointsFMBloodMode = in.readFloat();
        pointsFMDeluxeMode = in.readFloat();
        totalPointsFM = in.readFloat();
        pointsSMEasyMode = in.readFloat();
        pointsSMHardMode = in.readFloat();
        pointsSMThemes = in.readFloat();
        pointsSMRandomMode = in.readFloat();
        pointsSMBloodMode = in.readFloat();
        pointsSMDeluxeMode = in.readFloat();
        totalPointsSM = in.readFloat();
        mLeague = in.readString();
        mFirstMc = in.readString();
        mSecondMc = in.readString();
        mWinner = in.readString();
    }

    public static final Creator<Batalla> CREATOR = new Creator<Batalla>() {
        @Override
        public Batalla createFromParcel(Parcel in) {
            return new Batalla(in);
        }

        @Override
        public Batalla[] newArray(int size) {
            return new Batalla[size];
        }
    };

    public String getWinner(){
        return mWinner;
    }
    public void setWinner(String winner){
        this.mWinner = winner;
    }

    public float getPointsFMEasyMode() {
        return pointsFMEasyMode;
    }

    public void setPointsFMEasyMode(float pointsFMEasyMode) {
        this.pointsFMEasyMode = pointsFMEasyMode;
    }

    public float getPointsFMHardMode() {
        return pointsFMHardMode;
    }

    public void setPointsFMHardMode(float pointsFMHardMode) {
        this.pointsFMHardMode = pointsFMHardMode;
    }

    public float getPointsFMThemes() {
        return pointsFMThemes;
    }

    public void setPointsFMThemes(float pointsFMThemes) {
        this.pointsFMThemes = pointsFMThemes;
    }

    public float getPointsFMRandomMode() {
        return pointsFMRandomMode;
    }

    public void setPointsFMRandomMode(float pointsFMRandomMode) {
        this.pointsFMRandomMode = pointsFMRandomMode;
    }

    public float getPointsFMBloodMode() {
        return pointsFMBloodMode;
    }

    public void setPointsFMBloodMode(float pointsFMBloodMode) {
        this.pointsFMBloodMode = pointsFMBloodMode;
    }

    public float getPointsFMDeluxeMode() {
        return pointsFMDeluxeMode;
    }

    public void setPointsFMDeluxeMode(float pointsFMDeluxeMode) {
        this.pointsFMDeluxeMode = pointsFMDeluxeMode;
    }

    public float getTotalPointsFM() {
        return totalPointsFM;
    }

    public void setTotalPointsFM(float totalPointsFM) {
        this.totalPointsFM = totalPointsFM;
    }

    public float getPointsSMEasyMode() {
        return pointsSMEasyMode;
    }

    public void setPointsSMEasyMode(float pointsSMEasyMode) {
        this.pointsSMEasyMode = pointsSMEasyMode;
    }

    public float getPointsSMHardMode() {
        return pointsSMHardMode;
    }

    public void setPointsSMHardMode(float pointsSMHardMode) {
        this.pointsSMHardMode = pointsSMHardMode;
    }

    public float getPointsSMThemes() {
        return pointsSMThemes;
    }

    public void setPointsSMThemes(float pointsSMThemes) {
        this.pointsSMThemes = pointsSMThemes;
    }

    public float getPointsSMRandomMode() {
        return pointsSMRandomMode;
    }

    public void setPointsSMRandomMode(float pointsSMRandomMode) {
        this.pointsSMRandomMode = pointsSMRandomMode;
    }

    public float getPointsSMBloodMode() {
        return pointsSMBloodMode;
    }

    public void setPointsSMBloodMode(float pointsSMBloodMode) {
        this.pointsSMBloodMode = pointsSMBloodMode;
    }

    public float getPointsSMDeluxeMode() {
        return pointsSMDeluxeMode;
    }

    public void setPointsSMDeluxeMode(float pointsSMDeluxeMode) {
        this.pointsSMDeluxeMode = pointsSMDeluxeMode;
    }

    public float getTotalPointsSM() {
        return totalPointsSM;
    }

    public void setTotalPointsSM(float totalPointsSM) {
        this.totalPointsSM = totalPointsSM;
    }

    public String getLeague() {
        return mLeague;
    }

    public void setLeague(String league) {
        this.mLeague = league;
    }

    public String getFirstMc() {
        return mFirstMc;
    }

    public void setFirstMc(String firstMc) {
        this.mFirstMc = firstMc;
    }

    public String getSecondMc() {
        return mSecondMc;
    }

    public void setSecondMc(String secondMc) {
        this.mSecondMc = secondMc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(pointsFMEasyMode);
        dest.writeFloat(pointsFMHardMode);
        dest.writeFloat(pointsFMThemes);
        dest.writeFloat(pointsFMRandomMode);
        dest.writeFloat(pointsFMBloodMode);
        dest.writeFloat(pointsFMDeluxeMode);
        dest.writeFloat(totalPointsFM);
        dest.writeFloat(pointsSMEasyMode);
        dest.writeFloat(pointsSMHardMode);
        dest.writeFloat(pointsSMThemes);
        dest.writeFloat(pointsSMRandomMode);
        dest.writeFloat(pointsSMBloodMode);
        dest.writeFloat(pointsSMDeluxeMode);
        dest.writeFloat(totalPointsSM);
        dest.writeString(mLeague);
        dest.writeString(mFirstMc);
        dest.writeString(mSecondMc);
        dest.writeString(mWinner);
    }
}
