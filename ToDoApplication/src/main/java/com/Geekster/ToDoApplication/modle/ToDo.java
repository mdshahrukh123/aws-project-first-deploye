package com.Geekster.ToDoApplication.modle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDo {
    private Integer id;
//    @JsonProperty("Name")
    private String todoName;
    private Boolean todoStatus;

    public ToDo(Integer id, String todoName, Boolean todoStatus) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Boolean getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(Boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}
