package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputMenu = null;
        Menu menu = Menu.REGISTER_TASK;
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        while (true) {              //これを抜けたらアプリ終了
            showMenu();
            inputMenu = scanner.nextLine();
            switch (menu.toMenu(inputMenu)) {
                case REGISTER_TASK:
                    System.out.println("REGISTER_TASK");
                    RegisterTask regTask = new RegisterTask(tasks);
                    tasks = regTask.registerTask(tasks);
                    break;
                case UPDATE_TASK:
                    System.out.println("UPDATE_TASK");
                    UpdateTask upTask = new UpdateTask(tasks);
                    tasks = upTask.updateTask(tasks);
                    break;
                case REMOVE_TASK:
                    System.out.println("REMOVE_TASK");
                    tasks = RemoveTask.removeTask(tasks);
                    break;
                case SHOW_ALL_TASK:
                    System.out.println("SHOW_ALL_TASK");
                    showAllTask(tasks);
                    break;
                case SHOW_MATRIX_TASK:
                    System.out.println("SHOW_MATRIX_TASK");
                    MatrixTask.show(tasks);
                    break;
                case FINISH:
                    System.out.println("FINISH");
                    System.exit(0);
                    break;
                default:
                    System.out.println("default");  //throwの方が優先される？
                    throw new IllegalStateException("Unexpected value: " + menu.toMenu(inputMenu));
            }
        }
    }

    public static void showMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println(menu.getMenuNum() + ":" + menu.toString());
        }
        System.out.println("メニューを選んでください");
    }

    public static void showAllTask(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(
                    task.getTaskName().getName() + " " +
                    task.getPoint().getImportance() + " " +
                    task.getPoint().getUrgency()
            );
        }
        System.out.println("");
    }
}