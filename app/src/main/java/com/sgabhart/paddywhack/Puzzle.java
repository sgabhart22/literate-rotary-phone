package com.sgabhart.paddywhack;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Admin on 10/16/2017.
 */

public class Puzzle {
    private int id;
    private String date;
    private ArrayList<String> words, answers;
    private byte[] image;

    public Puzzle(int newId, String newDate, ArrayList<String> newWords,
                  ArrayList<String> newAnswers, byte[] newImage){
        id = newId;
        date = newDate;
        words = newWords;
        answers = newAnswers;
        image = newImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getDate(){
        return date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] newImage) {
        image = newImage;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "id=" + id +
                '}';
    }
}
