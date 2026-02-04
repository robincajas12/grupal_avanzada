package com.project007;

import com.project007.db.*;
import com.project007.repositories.BookRepository;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            GraphTemplate template = container.select(GraphTemplate.class).get();

            // Ejemplos

            Author author = new Author();
            author.setName("Garcia Marquez");
            author.setVersion(1);
            template.insert(author);

            Book book = new Book();
            book.setTitle("Cien Años de Seriedad");
            book.setPrice(BigDecimal.valueOf(100.4));
            book.setVersion(1);
            template.insert(book);

            Customer c = new Customer();
            c.setEmail("robincajas@uce.edu.ec");
            c.setName("Robin Cajas");
            c.setVersion(1);
            template.insert(c);

            Inventory i = new Inventory();
            i.setSupplied(1);
            i.setVersion(1);
            i.setSold(45L);
            template.insert(i);

            LineItem lineItem = new LineItem();
            lineItem.setIdx(10);
            lineItem.setQuantity(15);
            template.insert(lineItem);

            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setPlacedon(LocalDateTime.now());
            purchaseOrder.setDeliveredor(LocalDateTime.of(2005,12,4,5,6,7));
            purchaseOrder.setStatus(Status.ESTADO_1);
            purchaseOrder.setTotal(15);
            template.insert(purchaseOrder);

            template.edge(author, "escribe", book, Collections.emptyMap());

            template.edge(c,"realizó", purchaseOrder, Collections.emptyMap());

            template.edge(lineItem, "referencia", book, Collections.emptyMap());

            template.edge(i, "stock_de", book, Collections.emptyMap());

            template.edge(purchaseOrder, "contiene", lineItem, Collections.emptyMap());

            container.select(BookRepository.class).get().findAll().get().forEach(System.out::println);





        } catch (Exception e) {
            System.err.println("Error en el flujo de grafos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}