package com.project007.repositories;

import com.project007.db.PurchaseOrder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.concurrent.ExecutorService;

@ApplicationScoped
public class PurchaseOrderRepository extends GenericRepoImpl<PurchaseOrder, String> {

    @Inject
    public PurchaseOrderRepository(ExecutorService executor, GraphTemplate graphTemplate) {
        super(executor, graphTemplate, PurchaseOrder.class);
    }
}