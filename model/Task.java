package planner.model;

public class Task {
    private long id;
    private String name;
    private String description;
    private String date;
    private boolean status;
    private long userId;

    public Task() {
    }

    public Task(long id, String name, String description, String date, boolean status, long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
