package com.project007.db.relations;

import com.project007.db.Book;
import com.project007.db.LineItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class LineItemRelations {

    private Book book;

    @Inject
    GraphTemplate template;

    private List<LineItem> items = new ArrayList<>();

    public LineItemRelations book(Book book) {
        this.book = book;
        return this;
    }

    public LineItemRelations addItem(LineItem item) {
        items.add(item);
        return this;
    }

    public void save() {
        items.forEach(item -> {
            template.edge(item, "referencia", book, Collections.emptyMap());
        });
    }
}
