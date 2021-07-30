package com.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveTask {
    public static ArrayList<Task> removeTask(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("削除するタスク名を入力してください or quit");
            String inputRemoveTaskName = scanner.nextLine();
            if (inputRemoveTaskName.equals("quit")) break;
            try {
                sorryRemove(inputRemoveTaskName, tasks);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return tasks;
    }

    public static void sorryRemove(String removeTaskName, ArrayList<Task> tasks) throws Exception {
        String taskName = null;
        int cnt = 0;
        for (Task task : tasks) {
            taskName = task.getTaskName().getName();
            if (taskName.equals(removeTaskName)) {
                tasks.remove(cnt);
                break;
            }
            cnt++;
        }
        if (cnt == tasks.size()) throw new Exception("そんなタスクないよ！");
    }
}
