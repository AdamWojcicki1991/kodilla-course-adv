package com.kodilla.jpa.exercise.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @OneToMany(targetEntity = SubTask.class, mappedBy = "task")
    private List<SubTask> subTasks = new ArrayList<>();

    public Task(Long id, String name, String status, Employee employee) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.employee = employee;
    }

    public Task() {
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

    public List<SubTask> getSubTasks() {
        return subTasks;
    }
}
