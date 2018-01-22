package core;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private Resource res;
    private List<Task> taskQueue;

    public Answer(Resource res, List<Task> taskQueue) {
        this.res = res;
        this.taskQueue = taskQueue;
    }

    public Answer(Resource res) {
        this.res = res;
        this.taskQueue = new ArrayList<>();
    }

    public Resource getRes() {
        return res;
    }

    public void setRes(Resource res) {
        this.res = res;
    }

    public List<Task> getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(List<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void addTask(Task task) {
        this.taskQueue.add(task);
    }

    public long getCostTime() {
//        long costTime = 0;
//        for (Task task : taskQueue) {
//            costTime += task.getTime();
//        }
//        return costTime;
        return res.getFinalTime();
    }
}
