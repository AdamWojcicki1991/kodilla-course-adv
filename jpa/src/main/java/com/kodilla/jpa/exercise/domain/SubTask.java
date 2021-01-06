package com.kodilla.jpa.exercise.domain;

import javax.persistence.*;

@Entity
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

    public SubTask(Long id, String name, String status, Employee employee, Task task) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.employee = employee;
        this.task = task;
    }

    public SubTask() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Task getTask() {
        return task;
    }
}
