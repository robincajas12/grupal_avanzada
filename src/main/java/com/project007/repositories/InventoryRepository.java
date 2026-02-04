package com.project007.repositories;

import com.project007.db.Inventory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.concurrent.ExecutorService;

@ApplicationScoped
public class InventoryRepository extends GenericRepoImpl<Inventory, String> {

    @Inject
    public InventoryRepository(ExecutorService executor, GraphTemplate graphTemplate) {
        super(executor, graphTemplate, Inventory.class);
    }
}