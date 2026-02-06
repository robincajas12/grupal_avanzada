package com.project007.repositories;

import java.util.concurrent.ExecutorService;

import jakarta.inject.Inject;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import com.project007.db.Author;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository extends GenericRepoImpl<Author, String>{
    @Inject
    public AuthorRepository(ExecutorService executor, GraphTemplate graphTemplate) {
        super(executor, graphTemplate, Author.class);
    }
    
    
}
