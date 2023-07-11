package com.example.developer.MovieProjectApi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.model.TicketsBoughtByUser;
import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.repository.TicketsRepo;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepo ticketsRepo;

    public TicketsService(TicketsRepo ticketsRepo) {
        this.ticketsRepo = ticketsRepo;
    }

   public List<TicketsBoughtByUser> getAllTickets() {
    return ticketsRepo.findAll();
    }

    public TicketsBoughtByUser getTicketById(Long id) {
        return ticketsRepo.findById(id).orElse(null);
    }

    public TicketsBoughtByUser addTicket(TicketsBoughtByUser ticket) {
        return ticketsRepo.save(ticket);
    }

   public CompletableFuture<Void> getTicketsByUser(User user) {
    return CompletableFuture.supplyAsync(() -> {
        List<TicketsBoughtByUser> tickets = ticketsRepo.findByUser(user);

        // Map para armazenar o número de ingressos por título do filme
        Map<String, Integer> ingressosPorFilme = new HashMap<>();

        for (TicketsBoughtByUser ticket : tickets) {
            Film film = ticket.getFilm();

            if (film != null) {
                String tituloFilme = film.getTitle();
                ingressosPorFilme.merge(tituloFilme, 1, Integer::sum);
                // Verifica se o título do filme já está no mapa
                if (ingressosPorFilme.containsKey(tituloFilme)) {
                    // Incrementa o número de ingressos para o filme existente
                    int numeroIngressos = ingressosPorFilme.get(tituloFilme);
                    ingressosPorFilme.put(tituloFilme, numeroIngressos + 1);
                } else {
                    // Adiciona o título do filme com 1 ingresso inicialmente
                    ingressosPorFilme.put(tituloFilme, 1);
                }
            }
        }

        System.out.println("INGRESSOS ENCONTRADOS:");

        int contador = 1;
        for (Map.Entry<String, Integer> entry : ingressosPorFilme.entrySet()) {
            String tituloFilme = entry.getKey();
            int numeroIngressos = entry.getValue();

            System.out.println(contador + " - " + tituloFilme);
            System.out.println("Quantidade de ingressos: " + numeroIngressos);

            contador++;
        }

        return null;
    });
}


}
