package com.example.todo.todo.controler;



import com.example.todo.todo.model.User;
import com.example.todo.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class UserControler {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav= new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user){
        User oauthUser = userService.login(user.getUsername(), user.getPassword());
        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser)){
            return "redirect:/list";
        }
        else{
            return "redirect:/login";
        }
    }
}
