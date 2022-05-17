package net.guard.passer.entity;

import java.util.ArrayList;
import java.util.List;

public class App {
    List<Ticket> tickets = new ArrayList<>();

    public App() {
    }

    public App(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "net.guard.passer.entity.App{" +
                "tickets=" + tickets +
                '}';
    }
}
