package com.kodilla.jpa.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class InvoiceTestSuite {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Test
    void shouldNotNPlusOneProblemOccure() {
        //Given
        List<Long> savedInvoices = insertExampleData();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //When
        System.out.println("****************** BEGIN OF FETCHING *******************");
        System.out.println("*** STEP 1 – query for invoices ***");

        TypedQuery<Invoice> query = entityManager.createQuery(
                "from Invoice "
                        + " where id in (" + invoiceIds(savedInvoices) + ")", Invoice.class);

        EntityGraph<Invoice> entityGraph = entityManager.createEntityGraph(Invoice.class);
        entityGraph.addAttributeNodes("customer");
        entityGraph.addSubgraph("items").addAttributeNodes("product");
        query.setHint("javax.persistence.fetchgraph", entityGraph);

        List<Invoice> invoices = query.getResultList();

        for (Invoice invoice : invoices) {
            System.out.println("*** STEP 2 – read data from invoice ***");
            System.out.println(invoice);
            System.out.println("*** STEP 3 – read the customer data ***");
            System.out.println(invoice.getCustomer());

            for (Item item : invoice.getItems()) {
                System.out.println("*** STEP 4 – read the item ***");
                System.out.println(item);
                System.out.println("*** STEP 5 – read the product from item ***");
                System.out.println(item.getProduct());
            }
        }
        System.out.println("****************** END OF FETCHING *******************");

        //Then
        //Here should be some assertions and the clean up performed
    }

    @Test
    void shouldNPlusOneProblemOccure() {
        //Given
        List<Long> savedInvoices = insertExampleData();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //When
        System.out.println("****************** BEGIN OF FETCHING *******************");
        System.out.println("*** STEP 1 – query for invoices ***");

        List<Invoice> invoices =
                entityManager.createQuery(
                        "from Invoice "
                                + " where id in (" + invoiceIds(savedInvoices) + ")",
                        Invoice.class).getResultList();

        for (Invoice invoice : invoices) {
            System.out.println("*** STEP 2 – read data from invoice ***");
            System.out.println(invoice);
            System.out.println("*** STEP 3 – read the customer data ***");
            System.out.println(invoice.getCustomer());

            for (Item item : invoice.getItems()) {
                System.out.println("*** STEP 4 – read the item ***");
                System.out.println(item);
                System.out.println("*** STEP 5 – read the product from item ***");
                System.out.println(item.getProduct());
            }
        }
        System.out.println("****************** END OF FETCHING *******************");

        //Then
        //Here should be some assertions and the clean up performed
    }

    private String invoiceIds(List<Long> invoiceIds) {
        return invoiceIds.stream()
                .map(n -> "" + n)
                .collect(Collectors.joining(","));
    }

    private List<Long> insertExampleData() {
        Customer c1 = new Customer(null, "Customer1", "c1_address1", "c1_address2");
        Customer c2 = new Customer(null, "Customer2", "c2_address1", "c2_address2");
        Invoice iv1 = new Invoice(null, "1/2020", LocalDate.now(), c1);
        Invoice iv2 = new Invoice(null, "2/2020", LocalDate.now(), c2);
        Product p1 = new Product(null, "Product1");
        Product p2 = new Product(null, "Product2");
        Product p3 = new Product(null, "Product3");
        Product p4 = new Product(null, "Product4");
        Item item1Invoice1 = new Item(null, 1, 100, iv1, p1);
        Item item2Invoice1 = new Item(null, 1, 200, iv1, p2);
        Item item3Invoice2 = new Item(null, 2, 50, iv2, p3);
        Item item4Invoice2 = new Item(null, 3, 10, iv2, p4);
        iv1.getItems().addAll(List.of(item1Invoice1, item2Invoice1));
        iv2.getItems().addAll(List.of(item3Invoice2, item4Invoice2));
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.persist(p4);
        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(iv1);
        entityManager.persist(iv2);
        entityManager.persist(item1Invoice1);
        entityManager.persist(item2Invoice1);
        entityManager.persist(item3Invoice2);
        entityManager.persist(item4Invoice2);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        return List.of(iv1.getId(), iv2.getId());
    }
}
