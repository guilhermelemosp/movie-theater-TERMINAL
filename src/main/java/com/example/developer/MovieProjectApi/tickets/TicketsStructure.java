package com.example.developer.MovieProjectApi.tickets;
import java.util.List;
import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.model.TicketsBoughtByUser;
import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.service.FilmService;
import com.example.developer.MovieProjectApi.Menu;

@Component
public class TicketsStructure extends Menu{
    FilmService filmService;
    private User currentUser;


    public TicketsStructure(FilmService filmService, User currentUser) {
        this.filmService = filmService;
        this.currentUser = currentUser;
    }


    public void buyTickets() { //TicketService.java
        List<Film> films = filmService.getAllFilms();
        int userAge = currentUser.getAge();
        System.out.println("Selecione o filme que deseja comprar ingressos: ");
        for (int i = 0; i < films.size(); i++) {
            Film film = films.get(i);
            if (film.getMinimumAge() <= userAge) {
                System.out.println((i + 1) + " - " + film.getTitle());
            } else {
                continue; // Pula para a próxima iteração do loop
            }
        }

        System.out.println("Digite o número correspondente ao filme que deseja comprar ingressos: ");
        int filmChoice = scanner.nextInt();
        scanner.nextLine();

        if (filmChoice < 1 || filmChoice > films.size()) {
            System.out.println("Opção inválida!");
            clientMenu();
            return;
        }

        Film chosenFilm = films.get(filmChoice - 1);
        
        System.out.println("Digite a quantidade de ingressos que deseja comprar: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        if (quantity > chosenFilm.getAvailableSeats()) {
            System.out.println("Não há ingressos suficientes para a quantidade desejada!");
        } else {
            chosenFilm.setAvailableSeats(chosenFilm.getAvailableSeats() - quantity);
            filmService.updateFilm(chosenFilm);
            TicketsBoughtByUser ticket = new TicketsBoughtByUser(currentUser, chosenFilm);
            ticketsService.addTicket(ticket);
            System.out.println("Ingressos comprados com sucesso!");
        }

        clientMenu();
    }
}
