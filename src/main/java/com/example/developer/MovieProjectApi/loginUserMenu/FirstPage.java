package com.example.developer.MovieProjectApi.loginUserMenu;


import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.service.FilmService;
import com.example.developer.MovieProjectApi.service.TicketsService;
import com.example.developer.MovieProjectApi.service.UserService;

@Component
public class FirstPage extends LoginUserMenu{


    public FirstPage(UserService userService, FilmService filmService, TicketsService ticketsService) {
        super(userService, filmService, ticketsService);
    }

    public boolean loginPage() {
        getScanner();
        System.out.println("Bem vindo ao app de filmes!");
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastre-se");
        int option = getScanner().nextInt();
        switch (option) {
            case 1:
                System.out.println("ÁREA DE LOGIN");
                Login.login();
                break;
            case 2:
                System.out.println("ÁREA DE CADASTRO");
                AddPerson.addPerson();
                break;
            default:
                System.out.println("Opção inválida!");
                loginPage();
                break;
        }
        
        return true;
    }

}
