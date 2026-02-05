package com.project007.repositories;

import com.project007.db.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.concurrent.ExecutorService;

@ApplicationScoped
public class CustomerRepository extends GenericRepoImpl<Customer, String> {

    @Inject
    public CustomerRepository(ExecutorService executor, GraphTemplate graphTemplate) {
        super(executor, graphTemplate, Customer.class);
    }
}