package main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class TaskRequest {
    @JsonProperty(value = "isDone")
    private Boolean done;
    private String title;
    private String description;

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
