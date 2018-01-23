package core;

import java.util.ArrayList;
import java.util.List;

/**
 * 结果类，每一种资源的调度结果
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 *
 */

public class Answer {
    private Resource res;//资源
    private List<Task> taskQueue;//任务队列

    public Answer(Resource res) {
        this.res = res;
        this.taskQueue = new ArrayList<>();
    }

    public Resource getRes() {
        return res;
    }

    public List<Task> getTaskQueue() {
        return taskQueue;
    }

    public void addTask(Task task) {
        this.taskQueue.add(task);
    }

    /**
        一种资源消耗的时间
     */
    public long getCostTime() {
        return res.getFinalTime();
    }
}
