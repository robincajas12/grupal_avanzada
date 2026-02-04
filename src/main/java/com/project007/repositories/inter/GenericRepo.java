package com.project007.repositories;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

public interface GenericRepo<Entity, ID> {

    Future<Void> insert(Entity entity);

    Future<Optional<Entity>> findById(ID id);

    Future<List<Entity>> findAll();

    Future<Void> update(Entity entity);

    Future<Void> deleteById(ID id);
}
