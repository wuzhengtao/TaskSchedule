package core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有资源的调度结果
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 *
 */

public class Answers extends HashMap<Resource,Answer> {
//    private Map<Resource,Answer> answers;//结果集
//
//    public Answers(Map<Resource,Answer> answers) {
//        this.answers = answers;
//    }
//
//    public Map<Resource,Answer> getAnswer() {
//        return answers;
//    }
//
//    public void setAnswer(Map<Resource,Answer> answers) {
//        this.answers = answers;
//    }
//
//    public void addAnswer(Answer answer) {
//        this.answers.put(answer.getRes(),answer);
//    }

    /*
        总时间就是消耗最多时间的单个结果
     */

    public long getTotalTime() {
        long totalTime = 0;
        for (Answer answer : this.values()
             ) {
            totalTime = totalTime > answer.getCostTime() ? totalTime : answer.getCostTime();
        }
        return totalTime;
    }
}
