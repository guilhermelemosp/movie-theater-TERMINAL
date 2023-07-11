package com.example.developer.MovieProjectApi.film.utils;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.service.FilmService;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class FilmUtils {
    
   @Autowired
    public FilmUtils(FilmService filmService) {
        this.filmService = filmService;
    }


    String gender[] = {"Ação", "Aventura", "Comédia", "Drama", "Fantasia", "Ficção científica", "Musical", "Romance", "Suspense", "Terror"};
    String tecnologyApplied[] = {"2D", "3D", "4D", "IMAX", "IMAX 3D", "Dolby Atmos", "Dolby Vision", "D-BOX", "4DX", "ScreenX"};
    int minimumAge[] = {0, 10, 12, 14, 16, 18};
    int availableSeats = 100;
    int value[] = {10, 15, 20, 25, 30, 35, 40, 45, 50};
    
   
    private FilmService filmService;

    public void filmList() {
        List<Film> films = filmService.getAllFilms();

        //CASO QUEIRA O RETORNO EM JSON, SEGUE O CÓDIGO ABAIXO:

        // //Configurar o OBJECTMAPPER do Jackson para imprimir o JSON;
        // ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // try {
        //     String filmJson = objectMapper.writeValueAsString(films);
        //     System.out.println(filmJson);
        // } catch (JsonProcessingException e) {
        // System.out.println("Erro ao serializar filmes em JSON: " + e.getMessage());
        // }

        if(films.isEmpty()) {
            System.out.println("Não há filmes cadastrados!");
        } else {
            System.out.println("------------------------");
            System.out.println("LISTA DE FILMES: ");
            System.out.println("------------------------");
            for(Film film : films) {
                System.out.println("Título: " + film.getTitle());
                System.out.println("Gênero: " + film.getGender());
                System.out.println("Faixa Etária: " + film.getMinimumAge());
                System.out.println("Duração: " + film.getDuration() + " minutos");
                System.out.println("Preço do Ingresso: R$" + film.getValue());
                System.out.println("Tecnologia: " + film.getTecnologyApplied());
                System.out.println("Assentos Disponíveis: " + film.getAvailableSeats());
                System.out.println("------------------------");
            }
        }

        System.out.println("Digite qualquer tecla para voltar ao menu principal e pressione ENTER:");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    public String[] getGender() {
        return gender;
    }
    public void setGender(String[] gender) {
        this.gender = gender;
    }
    public String[] getTecnologyApplied() {
        return tecnologyApplied;
    }
    public void setTecnologyApplied(String[] tecnologyApplied) {
        this.tecnologyApplied = tecnologyApplied;
    }
    public int[] getMinimumAge() {
        return minimumAge;
    }
    public void setMinimumAge(int[] minimumAge) {
        this.minimumAge = minimumAge;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public int[] getValue() {
        return value;
    }
    public void setValue(int[] value) {
        this.value = value;
    }
 
}
