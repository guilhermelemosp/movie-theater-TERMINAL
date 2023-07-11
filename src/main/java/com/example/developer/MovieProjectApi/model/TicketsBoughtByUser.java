package com.example.developer.MovieProjectApi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "TicketsBoughtByUser")
public class TicketsBoughtByUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Film film;

    public TicketsBoughtByUser() {
    }

    public TicketsBoughtByUser(User user, Film film) {
        this.user = user;
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}