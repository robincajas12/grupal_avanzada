package com.project007.repositories;

import com.project007.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.concurrent.ExecutorService;
@ApplicationScoped
public class BookRepository extends GenericRepoImpl<Book, String> {
    @Inject
    public BookRepository(ExecutorService executor, GraphTemplate graphTemplate) {
        super(executor, graphTemplate, Book.class);
    }
}
