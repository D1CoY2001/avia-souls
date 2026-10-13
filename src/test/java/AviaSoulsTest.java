package werv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void shouldCompareTicketsByPrice() {
        werv.Ticket cheap = new werv.Ticket("DME", "KZN", 3000, 10, 12);
        werv.Ticket expensive = new werv.Ticket("DME", "KZN", 5000, 10, 12);

        Assertions.assertTrue(cheap.compareTo(expensive) < 0);
        Assertions.assertTrue(expensive.compareTo(cheap) > 0);
    }

    @Test
    public void shouldSearchAndSortByPrice() {
        werv.AviaSouls manager = new werv.AviaSouls();

        manager.add(new werv.Ticket("DME", "KZN", 5000, 10, 12));
        manager.add(new werv.Ticket("DME", "KZN", 3000, 9, 11));
        manager.add(new werv.Ticket("DME", "KZN", 4000, 8, 10));
        manager.add(new werv.Ticket("SVO", "KZN", 2000, 7, 9));

        werv.Ticket[] expected = {
                new werv.Ticket("DME", "KZN", 3000, 9, 11),
                new werv.Ticket("DME", "KZN", 4000, 8, 10),
                new werv.Ticket("DME", "KZN", 5000, 10, 12)
        };

        Assertions.assertArrayEquals(expected, manager.search("DME", "KZN"));
    }

    @Test
    public void shouldCompareTicketsByFlightTime() {
        werv.TicketTimeComparator comparator = new werv.TicketTimeComparator();

        werv.Ticket fast = new werv.Ticket("DME", "KZN", 5000, 10, 12);
        werv.Ticket slow = new werv.Ticket("DME", "KZN", 3000, 10, 15);

        Assertions.assertTrue(comparator.compare(fast, slow) < 0);
        Assertions.assertTrue(comparator.compare(slow, fast) > 0);
    }

    @Test
    public void shouldSearchAndSortByFlightTime() {
        werv.AviaSouls manager = new werv.AviaSouls();
        werv.TicketTimeComparator comparator = new werv.TicketTimeComparator();

        manager.add(new werv.Ticket("DME", "KZN", 5000, 10, 15));
        manager.add(new werv.Ticket("DME", "KZN", 3000, 10, 12));
        manager.add(new werv.Ticket("DME", "KZN", 4000, 10, 14));
        manager.add(new werv.Ticket("SVO", "KZN", 1000, 10, 11));

        werv.Ticket[] expected = {
                new werv.Ticket("DME", "KZN", 3000, 10, 12),
                new werv.Ticket("DME", "KZN", 4000, 10, 14),
                new werv.Ticket("DME", "KZN", 5000, 10, 15)
        };

        Assertions.assertArrayEquals(
                expected,
                manager.searchAndSortBy("DME", "KZN", comparator)
        );
    }
}