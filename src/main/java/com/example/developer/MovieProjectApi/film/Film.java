package com.example.developer.MovieProjectApi.film;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.Menu;
import com.example.developer.MovieProjectApi.film.utils.FilmUtils;

@Component
public abstract class Film extends Menu{

    FilmUtils filmUtils;
    Scanner scanner;

    public Film(FilmUtils filmUtils, Scanner scanner) {
        this.filmUtils = filmUtils;
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }



    public FilmUtils getFilmUtils() {
        return filmUtils;
    }

    public void setFilmUtils(FilmUtils filmUtils) {
        this.filmUtils = filmUtils;
    }


    
}
