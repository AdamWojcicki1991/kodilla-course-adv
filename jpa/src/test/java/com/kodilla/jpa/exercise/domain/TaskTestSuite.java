package com.kodilla.jpa.exercise.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class TaskTestSuite {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Test
    void shouldNotNPlusOneProblemOccure() {
        //Given
        List<Long> savedTasks = insertExampleData();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //When
        System.out.println("****************** BEGIN OF FETCHING *******************");
        System.out.println("*** STEP 1 – query for tasks ***");

        TypedQuery<Task> query = entityManager.createQuery(
                "from Task "
                        + " where id in (" + taskIds(savedTasks) + ")", Task.class);

        EntityGraph<Task> entityGraph = entityManager.createEntityGraph(Task.class);
        entityGraph.addAttributeNodes("employee");
        entityGraph.addSubgraph("subTasks").addAttributeNodes("employee");
        query.setHint("javax.persistence.fetchgraph", entityGraph);

        List<Task> tasks = query.getResultList();

        for (Task task : tasks) {
            System.out.println("*** STEP 2 – read data from task ***");
            System.out.println(task);
            System.out.println("*** STEP 3 – read the employee data ***");
            System.out.println(task.getEmployee());

            for (SubTask subTask : task.getSubTasks()) {
                System.out.println("*** STEP 4 – read the subtask ***");
                System.out.println(subTask);
                System.out.println("*** STEP 5 – read the employee from subtask ***");
                System.out.println(subTask.getEmployee());
            }
        }
        System.out.println("****************** END OF FETCHING *******************");

        //Then
        //Here should be some assertions and the clean up performed
    }

    @Test
    void shouldNPlusOneProblemOccure() {
        //Given
        List<Long> savedTasks = insertExampleData();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //When
        System.out.println("****************** BEGIN OF FETCHING *******************");
        System.out.println("*** STEP 1 – query for tasks ***");

        List<Task> tasks =
                entityManager.createQuery(
                        "from Task "
                                + " where id in (" + taskIds(savedTasks) + ")",
                        Task.class).getResultList();

        for (Task task : tasks) {
            System.out.println("*** STEP 2 – read data from task ***");
            System.out.println(task);
            System.out.println("*** STEP 3 – read the employee data ***");
            System.out.println(task.getEmployee());

            for (SubTask subTask : task.getSubTasks()) {
                System.out.println("*** STEP 4 – read the subtask ***");
                System.out.println(subTask);
                System.out.println("*** STEP 5 – read the employee from subtask ***");
                System.out.println(subTask.getEmployee());
            }
        }
        System.out.println("****************** END OF FETCHING *******************");

        //Then
        //Here should be some assertions and the clean up performed
    }

    private String taskIds(List<Long> taskIds) {
        return taskIds.stream()
                .map(n -> "" + n)
                .collect(Collectors.joining(","));
    }

    private List<Long> insertExampleData() {
        Employee emp1 = new Employee(null, "John", "Doe");
        Employee emp2 = new Employee(null, "David", "Mills");
        Task task1 = new Task(null, "Task1", "Queued", emp1);
        Task task2 = new Task(null, "Task2", "In progress", emp2);
        SubTask subTask1 = new SubTask(null, "Subtask1", "Queued", emp1, task1);
        SubTask subTask2 = new SubTask(null, "Subtask2", "Queued", emp1, task2);
        SubTask subTask3 = new SubTask(null, "Subtask3", "Queued", emp2, task1);
        SubTask subTask4 = new SubTask(null, "Subtask4", "Queued", emp2, task2);
        task1.getSubTasks().addAll(List.of(subTask1, subTask3));
        task2.getSubTasks().addAll(List.of(subTask2, subTask4));
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(emp1);
        entityManager.persist(emp2);
        entityManager.persist(task1);
        entityManager.persist(task2);
        entityManager.persist(subTask1);
        entityManager.persist(subTask2);
        entityManager.persist(subTask3);
        entityManager.persist(subTask4);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        return List.of(task1.getId(), task2.getId());
    }
}
