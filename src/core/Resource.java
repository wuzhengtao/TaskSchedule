package core;

public class Resource {
    private int id;
    private String name;
    private long finalTime;
    private String description;

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

    public long getUsed() {
        return finalTime;
    }

    public void setUsed(long used) {
        finalTime = used;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
