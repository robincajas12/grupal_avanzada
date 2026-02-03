package com.project007;

import com.project007.db.*;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.math.BigDecimal;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            GraphTemplate template = container.select(GraphTemplate.class).get();

            // 1. Limpiar base de datos (Opcional, para pruebas limpias)
            // template.getGraph().cypher("MATCH (n) DETACH DELETE n");

            // 2. Crear el Autor
            Author author = new Author();
            author.setId("auth-mathias");
            author.setName("Mathias Malzieu");
            author.setVersion(1);
            // Insertamos el autor primero
            template.insert(author);

            // 3. Crear el Inventario
            Inventory inventory = new Inventory();
            inventory.setId("inv-abs-001");
            inventory.setSold(50L);
            inventory.setSupplied(100);
            inventory.setVersion(1);
            // Insertamos el inventario
            template.insert(inventory);

            // 4. Crear el Libro y asociar Autor e Inventario
            Book book = new Book();
            book.setIsbn("ABS-12345");
            book.setTitle("La mecanica del corazon");
            book.setPrice(15.50);

            // Relaciones: JNoSQL creará las flechas en Neo4j
            book.setAuthors(Collections.singletonList(author));
            book.setInventory(inventory); // Relación 1 a 1 corregida

            // Al insertar el libro, se crean las relaciones WRITTEN_BY y HAS_STOCK
            template.insert(book);

            // 5. Crear un Cliente y una Orden para probar el resto del flujo
            Customer customer = new Customer();
            customer.setId("cust-jonathan");
            customer.setName("Jonathan Suarez");
            customer.setEmail("jonathan@example.com");
            template.insert(customer);

            LineItem item = new LineItem();
            item.setId("item-001");
            item.setQuantity(2);
            item.setBook(book); // El item apunta al libro
            template.insert(item);

            PurchaseOrder order = new PurchaseOrder();
            order.setId("order-999");
            order.setTotal(31);
            // order.setStatus(PurchaseOrder.Status.ESTADO1);
            order.setCustomer(customer); // La orden apunta al cliente
            order.setItems(Collections.singletonList(item)); // La orden contiene el item
            template.insert(order);

            System.out.println("¡Éxito! Estructura completa guardada en Neo4j.");

        } catch (Exception e) {
            System.err.println("Error en el flujo de grafos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}