package com.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;

public class MatrixTask {
    public static void show(ArrayList<Task> tasks) {
        int importanceMax = 0;
        int urgencyMax = 0;
        int importanceMin = 0;
        int urgencyMin = 0;
        for (Task task : tasks) {
            importanceMax = max(importanceMax, task.getPoint().getImportance());
            urgencyMax = max(urgencyMax, task.getPoint().getUrgency());
            importanceMin = min(importanceMin, task.getPoint().getImportance());
            urgencyMin = min(urgencyMin, task.getPoint().getUrgency());
        }
        Task[][] matrixTasks = new Task[importanceMax + 1][urgencyMax + 1];
        for (Task task : tasks) {
            matrixTasks[task.getPoint().getImportance()][task.getPoint().getUrgency()] = task;
        }
//        System.out.println(Arrays.deepToString(matrixTasks));
        int cnt = 0;
        StringBuilder importanceLine = new StringBuilder("");
        for (int u = urgencyMax; u >= urgencyMin; u--) {
            for (int i = importanceMin; i <= importanceMax; i++) {
                importanceLine.append(Integer.valueOf(i).toString());
                importanceLine.append(" ");
            }
            importanceLine.append("\n");
            for (int i = importanceMin; i <= importanceMax; i++) {
                if (i == importanceMin) importanceLine.append(Integer.valueOf(u).toString());
                if (matrixTasks[i][u] == null) {
                    importanceLine.append("0");
                    importanceLine.append(" ");
                } else if
                (matrixTasks[i][u].getPoint().getImportance() == i && matrixTasks[i][u].getPoint().getUrgency() == u) {
                    importanceLine.append(matrixTasks[i][u].getTaskName().getName());
                    importanceLine.append(" ");
                }
            }
            importanceLine.append("\n");
        }
        String matrix = importanceLine.toString();
        System.out.println("-------  max min----------");
        System.out.println("重要度max：" + Integer.valueOf(importanceMax).toString());
        System.out.println("緊急度max：" + Integer.valueOf(urgencyMax).toString());
        System.out.println("重要度min：" + Integer.valueOf(importanceMin).toString());
        System.out.println("緊急度min：" + Integer.valueOf(urgencyMin).toString());
        System.out.println("-----------------");
        System.out.println(matrix);
    }
}
