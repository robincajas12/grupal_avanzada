package com.project007.db.relations;

import com.project007.db.Author;
import com.project007.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class AuthorRelations {
    private Author author;

    @Inject
    GraphTemplate template;


    private List<Book> books = new ArrayList<>();

    public AuthorRelations author(Author author) {
        this.author = author;
        return this;
    }

    public AuthorRelations addBook(Book book) {
        books.add(book);
        return this;
    }

    public void save() {
        books.forEach(book -> {
            template.edge(author, "escribe", book, Collections.emptyMap());
        });
    }
}
