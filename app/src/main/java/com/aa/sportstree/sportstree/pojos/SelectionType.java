package com.aa.sportstree.sportstree.pojos;

/**
 * Created by Abhinav on 10/31/2014.
 */
public enum SelectionType {

    Teams(0), Sports(1);

    private int value;

    SelectionType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
