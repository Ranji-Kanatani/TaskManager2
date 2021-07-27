package com.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputMenu = null;
        Menu menu = Menu.REGISTER_TASK;
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        while(true){              //これを抜けたらアプリ終了
            inputMenu = scanner.nextLine();
            switch(menu.MenuName(inputMenu)) {
                case REGISTER_TASK:
                    tasks = RegisterTask.registerTask();
                    break;
                case REMOVE_TASK:
                    break;
                case SHOW_ALL_TASK:
                    break;
                case SHOW_MATRIX_TASK:
                    break;
                case FINISH:
                    break;
            }
        }
    }
}
