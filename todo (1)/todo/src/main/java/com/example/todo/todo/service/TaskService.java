package com.example.todo.todo.service;

import com.example.todo.todo.interfaceService.ItaskService;
import com.example.todo.todo.interfaces.ITask;
import com.example.todo.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ItaskService {

    @Autowired
    private ITask data;
    @Override
    public List<Task> listar() {
        return (List<Task>)data.findAll();
    }

    @Override
    public Optional<Task> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Task p) {
       int res = 0;
       Task task =data.save(p);
       if (!task.equals(null)){
           res=1;
       }
       return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }


}
