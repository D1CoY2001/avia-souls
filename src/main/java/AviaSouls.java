package werv;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSouls {
    private werv.Ticket[] tickets = new werv.Ticket[0];

    private werv.Ticket[] addToArray(werv.Ticket[] current, werv.Ticket ticket) {
        werv.Ticket[] tmp = new werv.Ticket[current.length + 1];

        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }

        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    public void add(werv.Ticket ticket) {
        tickets = addToArray(tickets, ticket);
    }

    public werv.Ticket[] findAll() {
        return tickets;
    }

    public werv.Ticket[] search(String from, String to) {
        werv.Ticket[] result = new werv.Ticket[0];

        for (werv.Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                result = addToArray(result, ticket);
            }
        }

        Arrays.sort(result);
        return result;
    }

    public werv.Ticket[] searchAndSortBy(String from, String to, Comparator<werv.Ticket> comparator) {
        werv.Ticket[] result = new werv.Ticket[0];

        for (werv.Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                result = addToArray(result, ticket);
            }
        }

        Arrays.sort(result, comparator);
        return result;
    }
}