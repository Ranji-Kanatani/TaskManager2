package com.app;

public class Point {
    private int importance;
    private int urgency;

    public Point(int importance, int urgency) {
        this.importance = importance;
        this.urgency = urgency;
    }

    public int getImportance() {
        return importance;
    }

    public int getUrgency() {
        return urgency;
    }
}
