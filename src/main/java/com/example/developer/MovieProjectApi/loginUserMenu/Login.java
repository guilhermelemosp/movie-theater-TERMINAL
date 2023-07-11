package com.example.developer.MovieProjectApi.loginUserMenu;


import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.service.FilmService;
import com.example.developer.MovieProjectApi.service.TicketsService;
import com.example.developer.MovieProjectApi.service.UserService;

@Component
public class Login extends LoginUserMenu{
    
 public Login(UserService userService, FilmService filmService, TicketsService ticketsService) {
        super(userService, filmService, ticketsService);
    }

    public static void login() {
        getScanner().nextLine();
        System.out.println("Digite seu nome de usuário: ");
        String username = getScanner().nextLine();
        System.out.println("Digite sua senha: ");
        String password = getScanner().nextLine();
        
        boolean isAutenticated = userUtils.authenticateUser(username, password);

        if (isAutenticated) {
            User user = userService.getUserByUsername(username);
            if(user != null){
            if (user.getRole().equals("Administrador")) {
               employeeMenu();
            } else if (user.getRole().equals("Cliente")) {
                clientMenu();
            }
            }
        } else {
            System.out.println("Nome de usuário ou senha inválidos. Voltando para a página inicial...");
            login();
        }
    
    }

}
