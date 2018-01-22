package core;

import java.util.List;

/**
 * 所有资源的调度结果
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 *
 */

public class Answers {
    private List<Answer> answers;//结果集
    private long totalTime;//完成总时间

    public Answers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswer() {
        return answers;
    }

    public void setAnswer(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    /*
        总时间就是消耗最多时间的单个结果
     */

    public long getTotalTime() {
        totalTime = 0;
        for (Answer answer : answers
             ) {
            totalTime = totalTime > answer.getCostTime() ? totalTime : answer.getCostTime();
        }
        return totalTime;
    }
}
