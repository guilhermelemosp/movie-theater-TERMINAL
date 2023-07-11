package com.example.developer.MovieProjectApi.film;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.Menu;
import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.service.FilmService;

@Component
public class FilmStructure extends Film{
    
    private Scanner scanner = new Scanner(System.in);
    private FilmService filmService;

    public void deleteFilm() { //FilmService.java
        scanner.nextLine();
        System.out.println("Digite o nome do filme que deseja remover: ");
        String name = scanner.nextLine().toLowerCase();

        List<Film> films = filmService.getAllFilms();

        List<Film> matchingFilms = new ArrayList<>();
        for (Film film : films) {
            String filmTitle = film.getTitle().toLowerCase();
            if (filmTitle.contains(name)) {
                matchingFilms.add(film);
            }
        }

        if (matchingFilms.isEmpty()) {
            System.out.println("Nenhum filme encontrado com esse nome.");
        } else {
            System.out.println("Foram encontrados os seguintes filmes com esses atributos:");
            for (int i = 0; i < matchingFilms.size(); i++) {
                Film film = matchingFilms.get(i);
                System.out.println((i + 1) + " - " + film.getTitle());
            }

            System.out.println("Digite o número do filme que deseja remover: ");
            int filmIndex = scanner.nextInt();

            if (filmIndex >= 1 && filmIndex <= matchingFilms.size()) {
                Film selectedFilm = matchingFilms.get(filmIndex - 1);
                if (selectedFilm.getAvailableSeats() == 100) {
                    confirmDeleteFilm(selectedFilm);
                } else {
                    System.out.println("OPÇÃO INVÁLIDA - OS INGRESSOS JÁ COMEÇARAM A SER VENDIDOS!");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private void confirmDeleteFilm(Film film) { //FilmService.java
        System.out.println("Tem certeza que deseja remover o filme \"" + film.getTitle() + "\"?");
        System.out.println("Digite 1 para confirmar ou 2 para cancelar");
        int confirmation = scanner.nextInt();

        if (confirmation == 1) {
            long filmId = film.getId();
            filmService.deleteFilm(filmId);
            System.out.println("O filme foi removido com sucesso!");
        } else {
            System.out.println("Remoção do filme cancelada!");
        }
        Menu.employeeMenu();
    }
}
