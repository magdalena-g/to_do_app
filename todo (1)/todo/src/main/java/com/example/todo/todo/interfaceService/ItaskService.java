package com.example.todo.todo.interfaceService;

import com.example.todo.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface ItaskService {
    public List<Task>listar();
    public Optional<Task>listarId(int id);
    public int save(Task p);
    public void delete(int id);

}
