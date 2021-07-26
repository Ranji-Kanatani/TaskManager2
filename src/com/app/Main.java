package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Task>[][] tasks = new ArrayList[5][5];
        //System.out.println("debug");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("タスク名を入力してください");
            String input_taskName = scanner.nextLine();
            if(input_taskName.equals("quit")) break;
            TaskName taskName = new TaskName(input_taskName);
            System.out.println("重要度を入力してください");
            int input_importance = Integer.parseInt(scanner.nextLine());
            System.out.println("緊急度を入力してください");
            int input_urgency = Integer.parseInt(scanner.nextLine());
            Point point = new Point(input_importance,input_urgency);
            Task task = new Task(taskName, point);
            //System.out.println(task.TaskName().Name() + "\n" + task.Point().Importance() + "\n" + task.Point().Urgency());
            tasks[task.Point().Importance()][task.Point().Urgency()] = new ArrayList<Task>();
            tasks[task.Point().Importance()][task.Point().Urgency()].add(task);
        }
    }
}
