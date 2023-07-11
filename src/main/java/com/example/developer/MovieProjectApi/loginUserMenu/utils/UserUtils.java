package com.example.developer.MovieProjectApi.loginUserMenu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.service.UserService;

@Component
public class UserUtils {

    private UserService userService;
    private User currentUser;

    public UserUtils(UserService userService) {
        this.userService = userService;
    }

    public void setCurrentUser() {
        currentUser = UserService.getCurrentUser();
    }


    public String encryptPassword(String password) {
        try {
            // Cria uma instância do MessageDigest com o algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Converte a senha para um array de bytes
            byte[] passwordBytes = password.getBytes();
            
            // Calcula o hash da senha
            byte[] passwordHash = md.digest(passwordBytes);
            
            // Converte o hash para uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : passwordHash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Retorna a senha criptografada em formato hexadecimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Caso ocorra algum erro na criptografia da senha
            // trata a exceção apropriadamente
            e.printStackTrace();
            return null;
        }
    }

    public boolean authenticateUser(String username, String password) {//UserRules.java
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                String encryptedPassword = user.getPassword();
                String enteredPasswordEncrypted = encryptPassword(password);
                if (encryptedPassword.equals(enteredPasswordEncrypted)) {
                    currentUser = user;
                    return true;                
                }
            }
        }
        return false;
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
