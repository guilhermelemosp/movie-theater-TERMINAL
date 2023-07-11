package com.example.developer.MovieProjectApi;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.film.AddFilm;
import com.example.developer.MovieProjectApi.film.FilmStructure;
import com.example.developer.MovieProjectApi.film.utils.FilmUtils;
import com.example.developer.MovieProjectApi.loginUserMenu.FirstPage;
import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.service.FilmService;
import com.example.developer.MovieProjectApi.service.TicketsService;
import com.example.developer.MovieProjectApi.service.UserService;
import com.example.developer.MovieProjectApi.tickets.TicketsStructure;


@Component
public abstract class Menu {
    protected static Scanner scanner;
    private static FilmUtils filmUtils;
    private static FilmService filmService;
    protected static TicketsService ticketsService;
    private static User currentUser;
    private static TicketsStructure ticketsStructure;
    private static FilmStructure filmStructure;
    private static AddFilm addFilm;
    private static FirstPage firstPage;
    
    

    public static User setCurrentUser() {
        currentUser = UserService.getCurrentUser();

        return currentUser;
    }
   

    public static void clientMenu() { //user.menu.structure
        scanner = new Scanner(System.in);
        System.out.println("Olá, " + setCurrentUser() + ". Seja Bem-Vindo!");
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Comprar Ingressos");
        System.out.println("2 - Filmes em cartaz para você");
        System.out.println("3 - Ingressos comprados");
        System.out.println("4 - Sair para login");
        int option = scanner.nextInt();
    
        switch (option) {
            case 1:
                System.out.println("Comprando ingressos...");          
                ticketsStructure.buyTickets();         
                break;
            case 2:
                System.out.println("Filmes em cartaz para você...");
                filmService.setMoviesByAge();
                scanner.nextLine();
                System.out.println("Pressione 1 para voltar ao Menu principal ou 2 para comprar ingressos...");
                int optionNumber = scanner.nextInt();
                scanner.nextLine();
                if(optionNumber == 1){
                    clientMenu();
                } else if(optionNumber == 2){
                    ticketsStructure.buyTickets();
                } else {
                    System.out.println("Opção inválida!");
                    clientMenu();
                }
                break;
            case 3:
                ticketsService.getTicketsByUser(setCurrentUser()).thenRunAsync(() -> {
                System.out.println("Digite qualquer tecla para voltar ao menu principal e pressione ENTER:");
                scanner.next();
                    clientMenu();
            });;
                break;
            case 4:
                System.out.println("Saindo para login...");
                firstPage.loginPage();
                break;
            default:
                System.out.println("Opção inválida!");
                clientMenu();
                break;
        }
        
    }

    public static void employeeMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá, " + currentUser.getName() + ". Seja Bem-Vindo!");
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Cadastrar filme");
        System.out.println("2 - Excluir filme");
        System.out.println("3 - Listar filmes");
        System.out.println("4 - Sair para login");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Adicionando filme...");
                addFilm.cadastraFilme();
                break;
            case 2:
            filmStructure.deleteFilm();
            employeeMenu();
            break;
            case 3:
                System.out.println("Buscando...");
                filmUtils.filmList();
                employeeMenu();
                break;
            case 4:
            firstPage.loginPage();
                break;
        }
            
    }
    
}
