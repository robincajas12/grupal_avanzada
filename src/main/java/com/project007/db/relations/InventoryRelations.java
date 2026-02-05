package com.project007.db.relations;

import com.project007.db.Book;
import com.project007.db.Inventory;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.Collections;


public class InventoryRelations {

    private Inventory inventory;
    private Book book;


    @Inject
    GraphTemplate template;

    public InventoryRelations book(Book book) {
        this.book = book;
        return this;
    }

    public InventoryRelations inventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    public void save() {
        if (book != null && inventory != null) {
            template.edge(inventory, "stock_de", book, Collections.emptyMap());
        }
    }
}
