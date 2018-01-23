package core;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个任务主要包括任务名称，任务时间，父任务集，子任务集，所需资源集
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 */

public class Task {
    private int id;//任务id
    private String name;//任务名称
    private long time;//任务执行时间
    private String description;//任务描述
    private List<Task> fatherTask;//父任务
    private Resource[] res;//所需资源集

    private List<Task> childTask = new ArrayList<>();//子任务
    private TaskStatus status = TaskStatus.CREATED;//状态
    private long firstStartTime = 0;//最早开始时间
    private long finishTime = 0;//完成时间

    public Task(int id, String name, long time, String description, List<Task> fatherTask, Resource[] res) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.description = description;
        this.fatherTask = fatherTask;
        this.res = res;
    }

    public Task(int id, String name, long time, String description, List<Task> fatherTask) {
        this(id, name, time, description, fatherTask, null);
    }

    public Task(int id, String name, long time, String description, Resource[] res) {
        this(id, name, time, description, new ArrayList<>(), res);
    }

    public Task(int id, String name, long time, List<Task> fatherTask, Resource[] res) {
        this(id, name, time, null, fatherTask, res);
    }

    public Task(int id, String name, long time, String description) {
        this(id, name, time, description, new ArrayList<>(), null);
    }

    public Task(int id, String name, long time, List<Task> fatherTask) {
        this(id, name, time, null, fatherTask, null);
    }

    public Task(int id, String name, long time, Resource[] res) {
        this(id, name, time, null, new ArrayList<>(), res);
    }

    public Task(int id, String name, long time) {
        this(id, name, time, null, new ArrayList<>(), null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getFatherTask() {
        return fatherTask;
    }

    public void setFatherTask(List<Task> fatherTask) {
        this.fatherTask = fatherTask;
    }

    public void addFatherTask(Task fatherTask) {
        this.fatherTask.add(fatherTask);
    }

    public Resource[] getRes() {
        return res;
    }

    public void setRes(Resource[] res) {
        this.res = res;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public long getFirstStartTime() {
        return firstStartTime;
    }

    public void setFirstStartTime(long startTime) {
        this.firstStartTime = startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public List<Task> getChildTask() {
        return childTask;
    }

    public void addChildTask(Task task) {
        this.childTask.add(task);
    }
}
