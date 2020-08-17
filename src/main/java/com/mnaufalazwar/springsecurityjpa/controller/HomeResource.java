package com.mnaufalazwar.springsecurityjpa.controller;

import com.mnaufalazwar.springsecurityjpa.config.SecurityConfiguration;
import com.mnaufalazwar.springsecurityjpa.dao.UserRepository;
import com.mnaufalazwar.springsecurityjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @GetMapping("/")
    public String home() {
        return securityConfiguration.getPasswordEncoder().encode("welcome home");
//        return "welcome home";
//        return "<h1>welcome</h1>";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public User registration(@RequestBody User user){

//        User myUser = user;
        user.setPassword(securityConfiguration.getPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);

//        return "success";

    }

    @GetMapping("/user")
    public String user(){
        return "welcome user";
//        return "<h1>welcome user</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "welcome admin";
//        return "<h1>welcome admin</h1>";
    }

}
