package com.mombesoft.tutorials.todobackendapi.repository;

import com.mombesoft.tutorials.todobackendapi.collections.TodoCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoCollection, String> {

}
