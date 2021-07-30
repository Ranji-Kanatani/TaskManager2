package com.app;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateTask {
    ArrayList<Task> tasks = new ArrayList<Task>();

    public UpdateTask(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> updateTask(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        this.tasks = tasks;
        while (true) {
            System.out.println("更新するタスク名を入力してください or quit");
            String inputUpdateTaskName = scanner.nextLine();
            if (inputUpdateTaskName.equals("quit")) break;
            TaskName taskName = new TaskName(inputUpdateTaskName);
            try {
                checkTaskName(taskName, this.tasks);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("重要度を入力してください");
            int input_importance = Integer.parseInt(scanner.nextLine());
            System.out.println("緊急度を入力してください");
            int input_urgency = Integer.parseInt(scanner.nextLine());
            Point point = new Point(input_importance, input_urgency);
            Task updateTask = new Task(taskName, point);
            this.tasks = update(updateTask, tasks);
        }
        return this.tasks;
    }

    public static ArrayList<Task> update(Task updateTask, ArrayList<Task> tasks) {
        String taskName = null;
        String updateTaskName = null;
        int cnt = 0;
        for (Task task : tasks) {
            taskName = task.getTaskName().getName();
            updateTaskName = updateTask.getTaskName().getName();
            if (taskName.equals(updateTaskName)) {
                tasks.set(cnt, updateTask);
                return tasks;
            }
            cnt++;
        }
        return tasks;
    }

    public static void checkTaskName(TaskName updateTaskName, ArrayList<Task> tasks) throws Exception {
        String taskName = null;
        int cnt = 0;
        for (Task task : tasks) {
            taskName = task.getTaskName().getName();
            if (!taskName.equals(updateTaskName.getName())) {
                cnt++;
            }
        }
        if (cnt == tasks.size()) throw new Exception("そんなタスクないよ！");
    }
}
