package com.springboot.tododemo.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name="start_date")
    private Date startDate;



    @Column(name="task")
    private String task;

    @DateTimeFormat(pattern ="MM/dd/yyyy")
    @Column(name="target_date")
    private Date targetDate;

    @Column(name="status")
    private String status;

    public Todo(){

    }

    public Todo(Date startDate, String task, Date targetDate, String status) {
        this.startDate = startDate;
        this.task = task;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Todo(int id, Date startDate, String task, Date targetDate, String status) {
        this.id = id;
        this.startDate = startDate;
        this.task = task;
        this.targetDate = targetDate;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", task='" + task + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
