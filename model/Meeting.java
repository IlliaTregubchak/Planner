package planner.model;

public class Meeting {
    private long id;
    private String name;
    private String description;
    private String date;
    private long userId;

    public Meeting() {
    }

    public Meeting(long id, String name, String description, String date, long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
