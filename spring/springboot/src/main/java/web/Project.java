package web;

public class Project {
    String name;
    String uuid;

    public Project(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
