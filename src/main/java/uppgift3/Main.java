package uppgift3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person jag = new Person(LocalDate.of(2000, 5, 12));
        jag.setNamn("Alex");
        jag.setAdress("Storgatan 1", "111 22", "Stockholm");

        Person kompis = new Person(LocalDate.of(2001, 9, 3));
        kompis.setNamn("Kim");
        kompis.setAdress("Lillgatan 7", "753 20", "Uppsala");

        System.out.println("Före flytten:");
        skrivUtPerson(jag);
        skrivUtPerson(kompis);

        // Kim flyttar in hos Alex.
        kompis.setAdress(jag.getGatuadress(), jag.getPostnummer(), jag.getPostort());

        System.out.println("\nEfter att " + kompis.getNamn() + " har flyttat in hos " + jag.getNamn() + ":");
        skrivUtPerson(jag);
        skrivUtPerson(kompis);
    }

    private static void skrivUtPerson(Person person) {
        System.out.printf(
                "%s (född %s): %s, %s %s%n",
                person.getNamn(),
                person.getFodelsedatum(),
                person.getGatuadress(),
                person.getPostnummer(),
                person.getPostort()
        );
    }
}
