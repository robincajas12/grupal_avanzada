package com.project007.repositories;

import com.project007.repositories.inter.GenericRepo;
import org.eclipse.jnosql.mapping.graph.GraphTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class GenericRepoImpl<Entity, ID> implements GenericRepo<Entity,ID> {
    Class<?> clazz;
    GraphTemplate graphTemplate;
    ExecutorService executor;
    public GenericRepoImpl(ExecutorService executor, GraphTemplate graphTemplate, Class<?> clazz)
    {
        this.graphTemplate = graphTemplate;
        this.clazz = clazz;
        this.executor = executor;
    }

    @Override
    public Future<Void> insert(Entity entity) {
        return CompletableFuture.runAsync(() -> {
            graphTemplate.insert(entity);
        },executor);
    }

    @Override
    public Future<Optional<Entity>> findById(ID id) {
        return CompletableFuture.supplyAsync(() -> {
            return (Optional<Entity>) graphTemplate.find(clazz, id);
        },executor);
    }

    @Override
    public Future<Stream<Entity>> findAll() {
        return CompletableFuture.supplyAsync(() -> {
            return (Stream<Entity>) graphTemplate.findAll(clazz);
        },executor);
    }

    @Override
    public Future<Void> update(Entity entity) {
        return CompletableFuture.runAsync(() -> {
            graphTemplate.update(entity);
        },executor);
    }

    @Override
    public Future<Void> deleteById(ID id) {
        return CompletableFuture.runAsync(() -> {
            graphTemplate.delete(clazz, id);
        },executor);
    }
}
