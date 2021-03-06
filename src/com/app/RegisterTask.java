package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.*;

public class RegisterTask {
    ArrayList<Task> tasks = new ArrayList<Task>();

    public RegisterTask(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> registerTask(ArrayList<Task> tasks) {
//        int importanceMax = 0;
//        int urgencyMax = 0;
//        ArrayList<Task> tasks = new ArrayList<Task>();
        this.tasks = tasks;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("タスク名を入力してください or quit");
            String input_taskName = scanner.nextLine();
            if (input_taskName.equals("quit")) break;
            TaskName taskName = new TaskName(input_taskName);
            System.out.println("重要度を入力してください");
            int input_importance = Integer.parseInt(scanner.nextLine());
            System.out.println("緊急度を入力してください");
            int input_urgency = Integer.parseInt(scanner.nextLine());
            Point point = new Point(input_importance, input_urgency);
            Task task = new Task(taskName, point);
            //System.out.println(task.TaskName().Name() + "\n" + task.Point().Importance() + "\n" + task.Point().Urgency());
            this.tasks.add(task);
//            importanceMax = max(importanceMax, task.getPoint().getImportance());
//            urgencyMax = max(urgencyMax, task.getPoint().getUrgency());
        }
//        List<Task>[][] tasksMatrix = new ArrayList[importanceMax][urgencyMax];
//        tasksMatrix[tasks[].Point().Importance()][task.Point().Urgency()] = new ArrayList<Task>();
//        tasksMatrix[task.Point().Importance()][task.Point().Urgency()].add(task);
//        System.out.println(Arrays.toString(tasksMatrix));
        return this.tasks;
    }
}
