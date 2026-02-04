package com.project007.repositories;

import java.util.concurrent.ExecutorService;

import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import com.project007.db.Author;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository extends GenericRepoImpl<Author, String>{

    public AuthorRepository(ExecutorService executor, GraphTemplate graphTemplate, Class<?> clazz) {
        super(executor, graphTemplate, Author.class);
    }
    
    
}
