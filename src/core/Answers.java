package core;

import java.util.List;

public class Answers {
    private List<Answer> answers;
    private long totalTime;

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

    public long getTotalTime() {
        totalTime = 0;
        for (Answer answer : answers
             ) {
            totalTime = totalTime > answer.getCostTime() ? totalTime : answer.getCostTime();
        }
        return totalTime;
    }
}
