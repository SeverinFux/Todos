package com.example.todobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
@RequestMapping("/todos")
public class TodosRESTController {
    TodosRepository todosRepository;

    @Autowired
    public TodosRESTController(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Todo>> todoList() {
        return ResponseEntity.ok(todosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> todoById(@PathVariable int id) {
        return ResponseEntity.ok(todosRepository.findAll().stream().filter(t -> t.getId() == id).findFirst().get());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        ResponseEntity.ok(todosRepository.findAll().removeIf(e -> e.getId() == id));
    }

    @PostMapping("")
    public ResponseEntity<List<Todo>> putTodo(@RequestBody Todo todo) {

        return ResponseEntity.ok(todosRepository.save(todo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<List<Todo>> patchTodo(@PathVariable long id, @RequestBody Todo todo) {
        if (todosRepository.findById(id).isPresent()) {

            return ResponseEntity.ok(todosRepository.updateTodo(id, todo));

        } else {
            return null;
        }
    }
    @PatchMapping("/{id}/open")
    public ResponseEntity<Todo> openTodo(@PathVariable long id) {
        if (todosRepository.findById(id).isPresent()) {

            return ResponseEntity.ok(todosRepository.complete(id));

        } else {
            return null;
        }
    }
    @PatchMapping("/{id}/close")
    public ResponseEntity<Todo> closeTodo(@PathVariable long id) {
        if (todosRepository.findById(id).isPresent()) {

            return ResponseEntity.ok(todosRepository.close(id));

        } else {
            return null;
        }
    }
}
