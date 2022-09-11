package com.mombesoft.tutorials.todobackentapi.repository;

import com.mombesoft.tutorials.todobackentapi.collections.TodoCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoCollection, String> {

}
