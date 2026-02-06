package com.project007.db.relations;

import com.project007.db.Author;
import com.project007.db.Book;
import com.project007.db.Customer;
import com.project007.db.PurchaseOrder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class CustomerRelations {
    private Customer customer;

    @Inject
    GraphTemplate template;

    private List<PurchaseOrder> orders = new ArrayList<>();

    public CustomerRelations customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CustomerRelations addOrder(PurchaseOrder order) {
        orders.add(order);
        return this;
    }

    public void save() {
        orders.forEach(order -> {
            template.edge(customer, "realizó", order, Collections.emptyMap());
        });
    }
}
