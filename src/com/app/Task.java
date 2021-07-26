package com.app;

public class Task implements Tasker{
    TaskName taskName;
    Point point;

    public Task(TaskName taskName, Point point){
        this.taskName = taskName;
        this.point = point;
    }

    @Override
    public TaskName TaskName(){
        return this.taskName;
    }

    @Override
    public Point Point() {
        return this.point;
    }
}
