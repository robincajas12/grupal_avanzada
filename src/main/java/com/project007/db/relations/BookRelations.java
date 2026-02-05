package com.project007.db.relations;

import com.project007.db.Author;
import com.project007.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@ApplicationScoped
public class BookRelations {
    // esto es la entidad y las demas propiedades sonn sus relationes
    private Book book;
    @Inject
    GraphTemplate template;

    private List<Author> authors = new ArrayList<>();

    public BookRelations book(Book book)
    {
        this.book = book;
        return this;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }
    public BookRelations addAuthor(Author author)
    {
        authors.add(author);
        return this;
    }
    public void save()
    {
        authors.forEach(author -> {
            template.edge(author, "escribe", book, Collections.emptyMap());
        });
    }


}
