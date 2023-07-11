package com.example.developer.MovieProjectApi.loginUserMenu;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.Menu;
import com.example.developer.MovieProjectApi.loginUserMenu.utils.UserUtils;
import com.example.developer.MovieProjectApi.service.FilmService;
import com.example.developer.MovieProjectApi.service.TicketsService;
import com.example.developer.MovieProjectApi.service.UserService;

@Component
public abstract class LoginUserMenu extends Menu{
    
    private static Scanner scanner;
    protected static UserUtils userUtils;
    protected static UserService userService;

    public LoginUserMenu(UserService userService, FilmService filmService, TicketsService ticketsService) {
        }


    public static Scanner getScanner() {
        return scanner;
    }


    public void setScanner(Scanner scanner) {
        LoginUserMenu.scanner = scanner;
    }


    public UserUtils getUserUtils() {
        return userUtils;
    }


    public void setUserUtils(UserUtils userUtils) {
        LoginUserMenu.userUtils = userUtils;
    }


    public UserService getUserService() {
        return userService;
    }


    public void setUserService(UserService userService) {
        LoginUserMenu.userService = userService;
    }
    
}
