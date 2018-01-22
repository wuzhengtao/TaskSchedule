package util;

import core.Answer;
import core.Answers;
import core.Task;

import java.util.List;

public class MathUtil {
    private boolean[][] taskTable;
    public boolean[][] getTaskTable (List<Task> tasks) {
        //测试通过
        //将所有的父任务用二维数组列出
        int size = tasks.size();
        taskTable = new boolean[size][size];
        for (int i = 0; i < size; ++i) {
            Task task = tasks.get(i);
            List<Task> fatherTask = task.getFatherTask();
            for(int j = 0; j < size; ++j) {
                Task tempTask = tasks.get(j);
                if (isFather(tempTask, fatherTask)) {
                    taskTable[j][i] = true;
                }
            }

        }
        return taskTable;
    }

    private boolean isFather(Task tempTask, List<Task> fatherTask) {
        boolean flag = false;
        for (Task ts : fatherTask) {
            if (tempTask.equals(ts))flag = true;
        }
        return flag;
    }

    public <T> void printArray (T [] t) {
        for (int i = 0; i < t.length; ++i) {
            System.out.print(t[i].equals(true));
            System.out.print("q");
        }
        System.out.println();
    }

    public <T> void printArray (T [][] t) {
        for (int i = 0; i < t.length; ++i) {
            printArray(t[i]);
            System.out.print("sdf");
        }
    }

    public void printTasks (List<Task> tasks) {
        for (Task task : tasks) {
            System.out.print(task.getId() + ", ");
            System.out.print(task.getName() + ", ");
            System.out.print(task.getTime());
            if (task.getFatherTask().size() > 0){
                System.out.print(", fatherTask : ");
                System.out.print(task.getFatherTask().get(0).getName());
            }
            System.out.println();
        }
    }

    public void printAnswers (Answers answers) {
        if (answers == null) {
            System.out.println("Method is not finished");
            return;
        }
        for (Answer answer : answers.getAnswer()) {
            System.out.print(answer.getRes().getName() + ": ");
            for (Task task : answer.getTaskQueue()) {
                System.out.print(task.getName() + " " + task.getTime() + ", ");
            }
            System.out.print("costTime : " + answer.getCostTime());
            System.out.println();
        }
        System.out.println("Total Time is : " + answers.getTotalTime());
    }
}
