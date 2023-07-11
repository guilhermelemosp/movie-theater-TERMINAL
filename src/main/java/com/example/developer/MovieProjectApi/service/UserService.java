package com.example.developer.MovieProjectApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.repository.UserRepo;

@Service
public class UserService {
        private static User currentUser;


        @Autowired    
        private UserRepo userRepo;


        public List<User> getAllUsers() {
                        return userRepo.findAll();
        }

        public User getUserById(Long id) {
                return userRepo.findById(id).orElse(null);
        }

        public User getUserByUsername(String username) {
                List<User> users = userRepo.findAll();
                for (User user : users) {
                        if (user.getUsername().equals(username)) {
                                return user;
                        }

                }
                return null;
        }

        public User addUser(User user) {
                return userRepo.save(user);
        }

        public User updateUser(User user) {
                User existingUser = userRepo.findById(user.getId()).orElse(null);
                if (existingUser != null) {
                        existingUser.setName(user.getName());
                        existingUser.setUsername(user.getUsername());
                        existingUser.setPassword(user.getPassword());
                        existingUser.setRole(user.getRole());
                        existingUser.setAge(user.getAge());
                        return userRepo.save(existingUser);
                
                }
                return null;
        }
        

        public String deleteUser(Long id) {
                userRepo.deleteById(id);
                return "Removido com sucesso!" + id;
        }

        public static User getCurrentUser() { //userService.java
        return currentUser;
        }

        
}

