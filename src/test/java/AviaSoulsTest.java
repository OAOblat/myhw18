import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket(
            "Saint-Petersburg",
            "Moscow",
            5000,
            15,
            17
    );

    Ticket ticket2 = new Ticket(
            "Sochi",
            "Krasnodar",
            3000,
            17,
            18
    );

    Ticket ticket3 = new Ticket(
            "Saint-Petersburg",
            "Krasnodar",
            10000,
            12,
            16
    ); //4 часа

    Ticket ticket4 = new Ticket(
            "Saint-Petersburg",
            "Krasnodar",
            9000,
            15,
            18
    ); // 3 часа

    Ticket ticket5 = new Ticket(
            "Saint-Petersburg",
            "Krasnodar",
            8000,
            15,
            20
    ); // 5 часов

    Ticket ticket6 = new Ticket(
            "Sochi",
            "Krasnodar",
            3000,
            16,
            17
    );


//   @Test
//   public void shouldSortTickets() {
//       AviaSouls aviaSouls = new AviaSouls();
//       Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
//       Ticket [] expected = {ticket2,ticket6,ticket1, ticket5, ticket4, ticket3}
//       Ticket [] actual = aviaSouls.search("Saint-Petersburg", "Krasnodar");
//   }

    @Test
    public void shouldSearchWhen0Result() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Moscow", "Krasnodar");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenThreeResultByPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket5, ticket4, ticket3};
        Ticket[] actual = aviaSouls.search("Saint-Petersburg", "Krasnodar");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPriceWhenEquals() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);


        Ticket[] expected = {ticket2, ticket6};
        Ticket[] actual = aviaSouls.search("Sochi", "Krasnodar");
        Assertions.assertArrayEquals(expected, actual);
    }

//   @Test
//   public void shouldCompareByTime() {
//       TicketTimeComparator timeComparator = new TicketTimeComparator();
//       Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
//       Arrays.sort(tickets, timeComparator);
//       //      Ticket[] expected = {ticket2, ticket1, ticket3...};      ???
//       //      Assertions.assertArrayEquals(expected, actual);       ???

//   }

    @Test
    public void shouldSearchWhenThreeResultByTime() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket4, ticket3, ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Saint-Petersburg", "Krasnodar", Ticket::compareTo);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenThreeResultByTimeWhenEquals() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket2, ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Sochi", "Krasnodar", Ticket::compareTo);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenThreeResultByTimeWhen0() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Krasnodar", Ticket::compareTo);
        Assertions.assertArrayEquals(expected, actual);
    }
}