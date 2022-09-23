package com.isha.todo.list.tasks;

import javax.persistence.*;

@Entity
@Table(name = "tasks_entity")
public class TasksEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "task")
    private String task;
    @Column(name = "done")
    private Boolean done;

    public TasksEntity() {
    }

    TasksEntity(Integer id, String task, Boolean isDone){
        this.id = id;
        this.task = task;
        this.done = isDone;
    }

    TasksEntity(Integer id, String task){
        this.id = id;
        this.task = task;
        this.done = false;
    }

    TasksEntity(String task){
        this.task = task;
        this.done = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }
}
