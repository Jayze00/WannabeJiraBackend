package com.tbz.jyrabackend.dto;

import com.tbz.jyrabackend.entities.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueDto {
    private List<Issue> toDo;
    private List<Issue> inProgress;
    private List<Issue> done;

    public IssueDto() {
        toDo = new ArrayList<>();
        inProgress = new ArrayList<>();
        done = new ArrayList<>();
    }

    public List<Issue> getToDo() {
        return toDo;
    }

    public void setToDo(List<Issue> toDo) {
        this.toDo = toDo;
    }

    public List<Issue> getInProgress() {
        return inProgress;
    }

    public void setInProgress(List<Issue> inProgress) {
        this.inProgress = inProgress;
    }

    public List<Issue> getDone() {
        return done;
    }

    public void setDone(List<Issue> done) {
        this.done = done;
    }
}
