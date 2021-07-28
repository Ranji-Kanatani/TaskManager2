package com.app;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;

public class MatrixTask {
    public static void show(ArrayList<Task> tasks) {
        int importanceMax = 0;
        int urgencyMax = 0;
        int importanceMin = 0;
        int urgencyMin = 0;
        int taskNameMaxLength = 0;
        String importanceNum;
        String urgencyNum;
        for (Task task : tasks) {
            importanceMax = max(importanceMax, task.getPoint().getImportance());
            urgencyMax = max(urgencyMax, task.getPoint().getUrgency());
            importanceMin = min(importanceMin, task.getPoint().getImportance());
            urgencyMin = min(urgencyMin, task.getPoint().getUrgency());
            taskNameMaxLength = max(taskNameMaxLength, task.getTaskName().getName().length());
        }
        Task[][] matrixTasks = new Task[importanceMax + 1][urgencyMax + 1];
        for (Task task : tasks) {
            matrixTasks[task.getPoint().getImportance()][task.getPoint().getUrgency()] = task;
        }
//        System.out.println(Arrays.deepToString(matrixTasks));
        int cnt = 0;
        StringBuilder sideLine = new StringBuilder("");
        String nowTaskname;
        for (int u = urgencyMax; u >= urgencyMin; u--) {
            urgencyNum = Integer.valueOf(u).toString();
            sideLine.append(format(urgencyNum, taskNameMaxLength));
            for (int i = importanceMin; i <= importanceMax; i++) {
                if (matrixTasks[i][u] == null) {
                    sideLine.append(format("0", taskNameMaxLength));
                    sideLine.append(" ");
                } else if
                (matrixTasks[i][u].getPoint().getImportance() == i && matrixTasks[i][u].getPoint().getUrgency() == u) {
                    nowTaskname = matrixTasks[i][u].getTaskName().getName();
                    sideLine.append(format(nowTaskname, taskNameMaxLength));
                    sideLine.append(" ");
                }
            }
            sideLine.append("\n");
        }
        sideLine.append(format(" ",taskNameMaxLength));
        for (int i = importanceMin; i <= importanceMax; i++) {
            importanceNum = Integer.valueOf(i).toString();
            sideLine.append(format(importanceNum, taskNameMaxLength));
            sideLine.append(" ");
        }
        sideLine.append("\n");
        String matrix = sideLine.toString();
        System.out.println("-------  max min----------");
        System.out.println("重要度max：" + Integer.valueOf(importanceMax).toString());
        System.out.println("緊急度max：" + Integer.valueOf(urgencyMax).toString());
        System.out.println("重要度min：" + Integer.valueOf(importanceMin).toString());
        System.out.println("緊急度min：" + Integer.valueOf(urgencyMin).toString());
        System.out.println("-----------------");
        System.out.println(matrix);
    }

    private static String format(String target, int length) {
        int byteDiff = (getByteLength(target, Charset.forName("UTF-8")) - target.length()) / 2;
        return String.format("%-" + (length - byteDiff) + "s", target);
    }

    private static int getByteLength(String string, Charset charset) {
        return string.getBytes(charset).length;
    }
}
