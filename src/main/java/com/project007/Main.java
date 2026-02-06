package com.project007;

import com.project007.db.*;
import com.project007.db.relations.*;
import com.project007.repositories.*;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            System.out.println("--- Obteniendo Repositorios y Clases de Relaciones ---");
            AuthorRepository authorRepo = container.select(AuthorRepository.class).get();
            BookRepository bookRepo = container.select(BookRepository.class).get();
            CustomerRepository customerRepo = container.select(CustomerRepository.class).get();
            PurchaseOrderRepository orderRepo = container.select(PurchaseOrderRepository.class).get();
            LineItemRepository itemRepo = container.select(LineItemRepository.class).get();
            InventoryRepository inventoryRepo = container.select(InventoryRepository.class).get();

            AuthorRelations authorRelations = container.select(AuthorRelations.class).get();
            CustomerRelations customerRelations = container.select(CustomerRelations.class).get();
            PurchaseOrderRelations purchaseOrderRelations = container.select(PurchaseOrderRelations.class).get();
            LineItemRelations lineItemRelations = container.select(LineItemRelations.class).get();
            InventoryRelations inventoryRelations = container.select(InventoryRelations.class).get();

            System.out.println("\n--- Creando y Guardando Entidades ---");

            Author author = new Author();
            author.setName("Gabriel Garcia Marquez");
            author.setVersion(1);
            authorRepo.insert(author).get();
            System.out.println("Autor guardado: " + author.getName());

            Book book1 = new Book();
            book1.setTitle("Cien Años de Soledad");
            book1.setPrice(new BigDecimal("150.00"));
            book1.setVersion(1);
            bookRepo.insert(book1).get();
            System.out.println("Libro guardado: " + book1.getTitle());

            Book book2 = new Book();
            book2.setTitle("El Amor en los Tiempos del Cólera");
            book2.setPrice(new BigDecimal("120.50"));
            book2.setVersion(1);
            bookRepo.insert(book2).get();
            System.out.println("Libro guardado: " + book2.getTitle());

            Customer customer = new Customer();
            customer.setName("Robin Cajas");
            customer.setEmail("robin.cajas@example.com");
            customer.setVersion(1);
            customerRepo.insert(customer).get();
            System.out.println("Cliente guardado: " + customer.getName());

            PurchaseOrder order = new PurchaseOrder();
            order.setPlacedon(LocalDateTime.now());
            order.setDeliveredor(LocalDateTime.now().plusDays(5));
            order.setStatus(Status.ESTADO_1);
            order.setTotal(2);
            orderRepo.insert(order).get();
            System.out.println("Orden de compra guardada: " + order.getId());

            LineItem item1 = new LineItem();
            item1.setIdx(1);
            item1.setQuantity(1);
            itemRepo.insert(item1).get();

            LineItem item2 = new LineItem();
            item2.setIdx(2);
            item2.setQuantity(1);
            itemRepo.insert(item2).get();
            System.out.println("Items de línea guardados.");

            Inventory inv1 = new Inventory();
            inv1.setSupplied(100);
            inv1.setSold(10L);
            inv1.setVersion(1);
            inventoryRepo.insert(inv1).get();

            Inventory inv2 = new Inventory();
            inv2.setSupplied(50);
            inv2.setSold(5L);
            inv2.setVersion(1);
            inventoryRepo.insert(inv2).get();
            System.out.println("Inventarios guardados.");

            System.out.println("\n--- Estableciendo Relaciones ---");

            authorRelations.author(author).addBook(book1).addBook(book2).save();
            System.out.println("Relación establecida: " + author.getName() + " -> escribe -> " + book1.getTitle() + " y " + book2.getTitle());

            customerRelations.customer(customer).addOrder(order).save();
            System.out.println("Relación establecida: " + customer.getName() + " -> realizó -> Orden " + order.getId());

            purchaseOrderRelations.purchaseOrder(order).addItem(item1).addItem(item2).save();
            System.out.println("Relación establecida: Orden " + order.getId() + " -> contiene -> 2 items");

            lineItemRelations.book(book1).addItem(item1).save();
            lineItemRelations.book(book2).addItem(item2).save();
            System.out.println("Relaciones establecidas: Items -> referencian -> Libros");

            inventoryRelations.inventory(inv1).book(book1).save();
            inventoryRelations.inventory(inv2).book(book2).save();
            System.out.println("Relaciones establecidas: Inventarios -> stock_de -> Libros");


            System.out.println("\n--- Verificación: Recuperando todos los datos ---");

            System.out.println("\nAutores en la base de datos:");
            authorRepo.findAll().get().forEach(a -> System.out.println("- " + a));

            System.out.println("\nLibros en la base de datos:");
            bookRepo.findAll().get().forEach(b -> System.out.println("- " + b));

            System.out.println("\nClientes en la base de datos:");
            customerRepo.findAll().get().forEach(c -> System.out.println("- " + c));

            System.out.println("\nÓrdenes de Compra en la base de datos:");
            orderRepo.findAll().get().forEach(o -> System.out.println("- " + o));

            System.out.println("\nItems de Línea en la base de datos:");
            itemRepo.findAll().get().forEach(i -> System.out.println("- " + i));

            System.out.println("\nInventarios en la base de datos:");
            inventoryRepo.findAll().get().forEach(inv -> System.out.println("- " + inv));

        } catch (Exception e) {
            System.err.println("\nError en el flujo de demostración: " + e.getMessage());
            e.printStackTrace();
        }
    }
}