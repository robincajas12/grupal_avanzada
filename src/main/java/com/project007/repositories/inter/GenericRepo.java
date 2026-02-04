package com.project007.repositories.inter;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface GenericRepo<Entity, ID> {

    Future<Void> insert(Entity entity);

    Future<Optional<Entity>> findById(ID id);

    Future<Stream<Entity>> findAll();

    Future<Void> update(Entity entity);

    Future<Void> deleteById(ID id);
}
