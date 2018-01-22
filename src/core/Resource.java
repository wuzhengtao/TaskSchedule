package core;

/**
 * 资源类
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 *
 */

public class Resource {
    private int id;//资源id
    private String name;//资源名称
    private long finalTime;//资源完成时间
    private String description;//资源描述

    public Resource(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.finalTime = 0;
        this.description = description;
    }

    public Resource(int id, String name) {
        this(id, name, null);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(long finalTime) {
        this.finalTime = finalTime;
    }
}
