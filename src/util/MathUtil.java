package util;

import core.Answer;
import core.Answers;
import core.Task;

/**
 * 工具类
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 *
 */

public class MathUtil {

    /*
        打印出结果集
     */
    public void printAnswers (Answers answers) {
        if (answers == null) {
            System.out.println("Method is not finished");
            return;
        }
        for (Answer answer : answers.values()) {
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
