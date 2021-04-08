package company.test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        System.out.println(theatre.getTheatreName() + " theatre");

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if(theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);


        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(new Theatre.Seat("B00", 13.00));
        priceSeats.add(new Theatre.Seat("A00", 13.00));
        priceSeats.sort(Theatre.PRICE_ORDER);
        printList(priceSeats);

        for (Theatre.Seat priceSeat : priceSeats) {
            if (priceSeat.equals(new Theatre.Seat("A00", 13.00))) {
                priceSeat.cancel();
            }
        }

        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("======================================================================");
    }
}
