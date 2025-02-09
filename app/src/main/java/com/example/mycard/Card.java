package com.example.mycard;


import android.graphics.drawable.Drawable;
import android.content.Context;
import androidx.core.content.ContextCompat;

public class Card {
    private String name;
    private String name_short;
    private String value;
    private int value_int;
    private String suit;
    private String type;
    private String meaning_up;
    private String meaning_rev;
    private String desc;



    // Геттеры
    public String getName() {
        return name;
    }

    public String getNameShort() {
        return name_short;
    }

    public String getValue() {
        return value;
    }

    public int getValueInt() {
        return value_int;
    }

    public String getSuit() {
        return suit;
    }

    public String getType() {
        return type;
    }

    public String getMeaningUp() {
        return meaning_up;
    }

    public String getMeaningRev() {
        return meaning_rev;
    }

    public String getDesc() {
        return desc;
    }
}
