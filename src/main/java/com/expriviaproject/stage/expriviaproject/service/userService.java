package com.expriviaproject.stage.expriviaproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.expriviaproject.stage.expriviaproject.entities.user;

import org.springframework.stereotype.Service;

@Service
public class userService {
    private List<user> userList = new ArrayList<>(Arrays.asList(
        new user("1","Alessio","Aprile","hhalessio@gmail.com"),
        new user("2","Giuseppe","Caggiano","giuseppe99@gmail.com"))
        );

    public List<user> getAllUserList() {
        return userList;
    }

    public void setAllUserList(List<user> userList) {
        this.userList = userList;
    }

    public user getUser(String id){
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }
    public void addUser(user user){
        userList.add(user);
    }
    public void updateUser(user user,String id){
        int counter = 0;
        for (user user1 : userList) {
            if (user1.getId().equals(id)){
                userList.set(counter, user);
            }
            counter ++;
        }
    }

    public void deleteUser(String id) {
        userList.removeIf(user -> user.getId().equals(id));
        }
}
