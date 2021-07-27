package com.app;

import java.util.ArrayList;

public class Tasks {
    ArrayList<Task> tasks = new ArrayList<Task>();
    public Tasks(Task task){
        tasks.add(task); //二次元にせなあかんな～
    }
    public void remove(int num){
        tasks.remove(num);
    }
}
