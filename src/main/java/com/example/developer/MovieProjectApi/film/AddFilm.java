package com.example.developer.MovieProjectApi.film;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.Menu;
import com.example.developer.MovieProjectApi.film.utils.FilmUtils;
import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.service.FilmService;

@Component
public class AddFilm extends Film{

    Scanner scanner = new Scanner(System.in);
    FilmService filmService;
    FilmUtils filmUtils;

    public void cadastraFilme() { //FilmService.java
        String rulesGender[] = filmUtils.getGender();
        String rulesTecnology[] = filmUtils.getTecnologyApplied();
        int rulesMinimumAge[] = filmUtils.getMinimumAge();
        int rulesAvailableSeats = filmUtils.getAvailableSeats();
        int rulesValue[] = filmUtils.getValue();

        scanner.nextLine();
        System.out.println("Digite o título do filme: ");
        String title = scanner.nextLine();

        System.out.println("Digite o gênero do filme: ");
        for(int i = 0; i < rulesGender.length; i++) {
            System.out.println((i + 1) + " - " + rulesGender[i]);
        }
        int genreOption = scanner.nextInt();
        String gender = rulesGender[genreOption - 1];

        System.out.println("Digite a faixa etária do filme: ");
         for(int i = 0; i < rulesMinimumAge.length; i++) {
            System.out.println((i + 1) + " - " + rulesMinimumAge[i]);
        }
        int ageOption = scanner.nextInt();
        int minimumAge = rulesMinimumAge[ageOption - 1];

        System.out.println("Digite a duração do filme: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite valor do ingresso: ");
           for(int i = 0; i < rulesValue.length; i++) {
            System.out.println((i + 1) + " - " + rulesValue[i]);
        }
        int value = scanner.nextInt();
        int ticketPrice = rulesValue[value - 1];
        
        scanner.nextLine();

        System.out.println("Digite a tecnologia aplicada no filme: ");
           for(int i = 0; i < rulesTecnology.length; i++) {
            System.out.println((i + 1) + " - " + rulesTecnology[i]);
        }
        int tecnologyOption = scanner.nextInt();
        String technology = rulesTecnology[tecnologyOption - 1];

        System.out.println("Quantidade padrão de assentos: " + rulesAvailableSeats);
        int availableSeats = rulesAvailableSeats;
        scanner.nextLine();
        System.out.println("Pressione 1 para confirmar os 100 lugares. Caso queira voltar para o Menu principal, pressione 2");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Voltando para o Menu principal...");
                Menu.employeeMenu();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        Film film = new Film(title, gender, minimumAge, duration, ticketPrice, technology, availableSeats);
        filmService.addFilm(film);
        System.out.println("Filme cadastrado com sucesso!");
        Menu.employeeMenu();
    }
}
