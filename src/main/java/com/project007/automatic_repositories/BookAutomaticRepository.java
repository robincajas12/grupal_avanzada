package com.project007.automatic_repositories;

import com.project007.db.Book;
import jakarta.data.repository.CrudRepository;

public interface BookAutomaticRepository extends CrudRepository<Book, String> {

}
