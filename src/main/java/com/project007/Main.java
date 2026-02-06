package com.project007;

import com.project007.db.Book;
import com.project007.db.Customer;
import com.project007.repositories.BookRepository;
import com.project007.repositories.CustomerRepository;
import com.project007.services.BookstoreService;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            BookstoreService bookstoreService = container.select(BookstoreService.class).get();
            CustomerRepository customerRepo = container.select(CustomerRepository.class).get();
            BookRepository bookRepo = container.select(BookRepository.class).get();

            bookstoreService.setupInitialData();

            Customer customer = new Customer();
            customer.setName("Robin Cajas");
            customer.setEmail("robin.cajas@example.com");
            customer.setVersion(1);
            customerRepo.insert(customer).get();
            System.out.println("\n--- Nuevo cliente creado ---");
            System.out.println("Cliente guardado: " + customer.getName());


            List<Book> booksToOrder;
            try (Stream<Book> bookStream = bookRepo.findAll().get()) {
                booksToOrder = bookStream.collect(Collectors.toList());
            }
            bookstoreService.placeOrder(customer, booksToOrder);


            bookstoreService.printAllData();


        } catch (Exception e) {
            System.err.println("\nError main: " + e.getMessage());
            e.printStackTrace();
        }
    }
}