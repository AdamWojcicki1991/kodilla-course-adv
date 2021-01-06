package com.kodilla.jpa.exercise.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaTaskTestSuite {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Test
    void shouldPersistEmployee() {
        //Given
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = new Employee(null, "Adam", "Wojcicki");
        //When
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.flush();
        entityManager.getTransaction().commit();
        //Then
        Long key = employee.getId();
        Employee readEmployee = entityManager.find(Employee.class, key);
        entityManager.close();
        assertThat(readEmployee.getName()).isEqualTo(employee.getName());
    }
}
