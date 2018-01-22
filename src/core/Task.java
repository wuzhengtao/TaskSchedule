package core;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private int id;
    private String name;
    private long time;
    private String description;
    private List<Task> fatherTask;
    private Resource[] res;

    private int status = 0;
    private long firstStartTime = 0;
    private long finishTime = 0;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
}
