package com.project007.services;

import com.project007.db.*;
import com.project007.db.relations.*;
import com.project007.repositories.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class BookstoreService {

    @Inject private AuthorRepository authorRepo;
    @Inject private BookRepository bookRepo;
    @Inject private CustomerRepository customerRepo;
    @Inject private PurchaseOrderRepository orderRepo;
    @Inject private LineItemRepository itemRepo;
    @Inject private InventoryRepository inventoryRepo;

    @Inject private AuthorRelations authorRelations;
    @Inject private CustomerRelations customerRelations;
    @Inject private PurchaseOrderRelations purchaseOrderRelations;
    @Inject private LineItemRelations lineItemRelations;
    @Inject private InventoryRelations inventoryRelations;

    public void setupInitialData() throws ExecutionException, InterruptedException {
        System.out.println("--- Configurando datos iniciales ---");

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

        authorRelations.author(author).addBook(book1).addBook(book2).save();
        System.out.println("Relación establecida: Autor -> Libros");

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

        inventoryRelations.inventory(inv1).book(book1).save();
        inventoryRelations.inventory(inv2).book(book2).save();
        System.out.println("Relaciones establecidas: Inventarios -> Libros");
    }

    public PurchaseOrder placeOrder(Customer customer, List<Book> books) throws ExecutionException, InterruptedException {
        System.out.println("\n--- Creando una nueva orden de compra ---");

        PurchaseOrder order = new PurchaseOrder();
        order.setPlacedon(LocalDateTime.now());
        order.setDeliveredor(LocalDateTime.now().plusDays(5));
        order.setStatus(Status.ESTADO_1);
        order.setTotal(books.size());
        orderRepo.insert(order).get();
        System.out.println("Orden de compra guardada: " + order.getId());

        customerRelations.customer(customer).addOrder(order).save();
        System.out.println("Relación establecida: Cliente -> Orden");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            LineItem item = new LineItem();
            item.setIdx(i + 1);
            item.setQuantity(1);
            itemRepo.insert(item).get();

            purchaseOrderRelations.purchaseOrder(order).addItem(item).save();
            lineItemRelations.book(book).addItem(item).save();
        }
        System.out.println("Relaciones establecidas: Orden -> Items -> Libros");

        return order;
    }

    public void printAllData() throws ExecutionException, InterruptedException {
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
    }
}
