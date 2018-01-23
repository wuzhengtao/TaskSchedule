package util;

import core.Answer;
import core.AnswerMap;
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

    /**
     *  打印出结果集
     */

    public void printAnswerMap(AnswerMap answers) {
        long totaltime = 0;
        for (Answer answer : answers.values()) {
            System.out.print(answer.getRes().getName() + ": ");
            for (Task task : answer.getTaskQueue()) {
                System.out.print(task.getName() + " " + task.getTime() + ", ");
            }
            totaltime = totaltime > answer.getCostTime() ? totaltime : answer.getCostTime();
            System.out.print("costTime : " + answer.getCostTime());
            System.out.println();
        }

        System.out.println("Total Time is : " + totaltime);
    }
}
