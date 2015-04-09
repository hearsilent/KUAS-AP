package com.kuas.ap.donate;

public class ScoreList {
    String ID;
    String Midterm;
    String Final;
    public ScoreList(String ID, String Midterm, String Final)
    {
        this.ID = ID.replace(" ","");
        this.Midterm = Midterm.replace(" ","");
        this.Final = Final.replace(" ","");
    }
}