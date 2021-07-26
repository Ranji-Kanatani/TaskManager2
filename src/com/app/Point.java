package com.app;

public class Point {
    int importance;
    int urgency;

    public Point(int importance, int urgency){
        this.importance = importance;
        this.urgency = urgency;
    }

    public int Importance(){
        return importance;
    }
    public int Urgency(){
        return urgency;
    }
}
