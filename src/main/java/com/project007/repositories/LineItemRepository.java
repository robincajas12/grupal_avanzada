package com.project007.repositories;

import com.project007.db.LineItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.concurrent.ExecutorService;

@ApplicationScoped
public class LineItemRepository extends GenericRepoImpl<LineItem, String> {

    @Inject
    public LineItemRepository(ExecutorService executor, GraphTemplate graphTemplate) {
        super(executor, graphTemplate, LineItem.class);
    }
}