package com.example.todobackend;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Repository
public class TodosRepository{
    private List<Todo> todos;

    public TodosRepository() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, 1L, "delectus aut autem", false));
        todos.add(new Todo(2, 2L, "quis ut nam facilis et officia qui", false));
        todos.add(new Todo(3, 3L, "fugiat veniam minus", false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Optional<Todo> findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return Optional.of(todo);
            }
        }
        return null;
    }


    public List<Todo> save(Todo todo) {
        todos.add(todo);
        return todos;
    }

    public List<Todo> updateTodo(Long id, Todo todo) {
        if(!findById(id).isPresent()){
            return save(todo);
        }else{
            Optional<Todo> oldTodo = todos.stream().filter(t -> t.getId() == id).findFirst();
            todos.set(todos.indexOf(oldTodo.get()), todo);
            return todos;
        }
    }

    public Todo complete(Long id) {
        findById(id).get().setCompleted(true);
        return findById(id).get();
    }

    public Todo close(Long id) {
        findById(id).get().setCompleted(false);
        return findById(id).get();
    }

}

