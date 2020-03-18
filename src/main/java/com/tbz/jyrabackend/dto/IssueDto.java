package com.tbz.jyrabackend.dto;

import com.tbz.jyrabackend.entities.Issue;

import java.util.List;

public class IssueDto {
    private List<Issue> todo;
    private List<Issue> inprogress;
    private List<Issue> done;

    public List<Issue> getTodo() {
        return todo;
    }

    public void setTodo(List<Issue> todo) {
        this.todo = todo;
    }

    public List<Issue> getInprogress() {
        return inprogress;
    }

    public void setInprogress(List<Issue> inprogress) {
        this.inprogress = inprogress;
    }

    public List<Issue> getDone() {
        return done;
    }

    public void setDone(List<Issue> done) {
        this.done = done;
    }
}
