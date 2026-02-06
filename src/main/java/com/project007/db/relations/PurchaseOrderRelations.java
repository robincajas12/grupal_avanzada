package com.project007.db.relations;

import com.project007.db.LineItem;
import com.project007.db.PurchaseOrder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class PurchaseOrderRelations {

    private PurchaseOrder purchaseOrder;

    @Inject
    GraphTemplate template;

    private List<LineItem> items = new ArrayList<>();

    public PurchaseOrderRelations purchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        return this;
    }

    public PurchaseOrderRelations addItem(LineItem item) {
        items.add(item);
        return this;
    }

    public void save() {
        items.forEach(item -> {
            template.edge(purchaseOrder, "contiene", item, Collections.emptyMap());
        });
    }
}
