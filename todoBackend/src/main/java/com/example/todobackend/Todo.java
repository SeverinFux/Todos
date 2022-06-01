package com.example.todobackend;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private long userid;
    private long id;
    private String title;
    private boolean completed;
}
