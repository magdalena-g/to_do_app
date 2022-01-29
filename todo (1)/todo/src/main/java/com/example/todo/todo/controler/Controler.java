package com.example.todo.todo.controler;

import com.example.todo.todo.interfaceService.ItaskService;
import com.example.todo.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controler {
    @Autowired
    private ItaskService service;

    @GetMapping("/list")
    public String listar(Model model){
        List<Task> tasks =service.listar();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid Task p, Model model){
        service.save(p);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Optional<Task>tasks=service.listarId(id);
        model.addAttribute("task", tasks);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/done/{done}")
    public String done(@PathVariable int done, Model model){


        List<Task> tasks =service.listar();
        model.addAttribute("tasks", tasks);
        return "successes";
    }

    @GetMapping("/done")
    public String done1(Model model){
        List<Task> tasks =service.listar();
        model.addAttribute("tasks", tasks);
        return "successes";
    }

    @Modifying
    @Query("update Task u set u.done = :done where u.id = :id")
    public void updateDone(@Param(value = "id") int id, @Param(value = "done") String done) {

    }
}
