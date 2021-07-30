package com.app;

public class Task implements Tasker {
    TaskName taskName;
    Point point;

    public Task(TaskName taskName, Point point) {
        this.taskName = taskName;
        this.point = point;
    }

    @Override
    public TaskName getTaskName() {
        return this.taskName;
    }

    @Override
    public Point getPoint() {
        return this.point;
    }
}
