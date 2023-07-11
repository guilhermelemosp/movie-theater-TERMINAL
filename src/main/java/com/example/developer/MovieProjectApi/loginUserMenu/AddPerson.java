package com.example.developer.MovieProjectApi.loginUserMenu;

import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.service.FilmService;
import com.example.developer.MovieProjectApi.service.TicketsService;
import com.example.developer.MovieProjectApi.service.UserService;

@Component
public class AddPerson extends LoginUserMenu{




    public AddPerson(UserService userService, FilmService filmService, TicketsService ticketsService) {
        super(userService, filmService, ticketsService);
    }

    public static void addPerson() {
        getScanner();
        getScanner().nextLine();
        System.out.println("Digite seu nome: ");
        String name = getScanner().nextLine();

        System.out.println("Digite seu nome de usuário: ");
        String username = getScanner().nextLine();

        System.out.println("Digite sua senha: ");
        String password = getScanner().nextLine();

        String passwordEncrypted = userUtils.encryptPassword(password);

        System.out.println("Digite sua idade: ");
        int age = getScanner().nextInt();
        getScanner().nextLine();
        System.out.println("Selecione a opção de cadastro: ");
        System.out.println("1 - Administrador");
        System.out.println("2 - Cliente");
        int optionNumber = getScanner().nextInt();
        getScanner().nextLine();
        
        String option = "";
        
        switch (optionNumber) {
            case 1:
                option = "Administrador";
                System.out.println("Cadastrando usuário comum...");
                break;
            case 2:
                option = "Cliente";
                System.out.println("Cadastrando administrador...");
                break;
            default:
                System.out.println("Opção inválida!");
                Login.login();
                break;
        }
        
        User user = new User(name, username, passwordEncrypted, option, age);
        userService.addUser(user);
        System.out.println("Usuário cadastrado com sucesso!");

        Login.login();
    }
}
