package com.expriviaproject.stage.expriviaproject.controller;

import java.util.List;

import com.expriviaproject.stage.expriviaproject.entities.user;
import com.expriviaproject.stage.expriviaproject.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //crea un'istanza di service
    @Autowired
    private userService UserService;
    //crea una lista di utenti prendendo tutti gli utenti di service
    @RequestMapping("/user")
    public List<user> all_user(){
        return UserService.getAllUserList();
    }
    //getUser
    @RequestMapping("/user/{id}")
    public user getUser(@PathVariable("id") String id){
        return UserService.getUser(id);
    }
    //addUser
    @RequestMapping(method = RequestMethod.POST, value="/user")
    public void addUser(@RequestBody user user){
        UserService.addUser(user);
    }
    //updateUser
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public void updateUser(@RequestBody user user, @PathVariable("id")String id){
        UserService.updateUser(user, id);
    }
    //deleteUser
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deleteUser(@PathVariable("id")String id){
        UserService.deleteUser(id);
    }

}
