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
                    tasks = RegisterTask.registerTask();
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
        System.out.println(
                "0:REGISTER_TASK" + "\n" +
                "1:REMOVE_TASK" + "\n" +
                "2:SHOW_ALL_TASK" + "\n" +
                "3:SHOW_MATRIX_TASK" + "\n" +
                "4:FINISH");
        System.out.println("メニューを選んでください");
    }
    public static void showAllTask(ArrayList<Task> tasks){
        for (Task task : tasks){
            System.out.println(task.getTaskName().getName() + " " +
                    task.getPoint().getImportance() + " " +
                    task.getPoint().getUrgency());
        }
        System.out.println("");
    }
}