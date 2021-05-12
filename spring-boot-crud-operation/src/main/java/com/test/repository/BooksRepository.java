package com.test.repository;
import org.springframework.data.repository.CrudRepository;

import com.test.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
