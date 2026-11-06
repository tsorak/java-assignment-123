package uppgift3;

import java.time.LocalDate;

public class Person {
    // Endast födelsedatum är omuterbart, resterande variabler kan komma att ändras i framtiden.
    private final LocalDate fodelsedatum;
    private String namn;
    private String gatuadress;
    private String postnummer;
    private String postort;

    public Person(LocalDate fodelsedatum) {
        this.fodelsedatum = fodelsedatum;
    }

    public LocalDate getFodelsedatum() {
        return fodelsedatum;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getGatuadress() {
        return gatuadress;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public String getPostort() {
        return postort;
    }

    public void setAdress(String gatuadress, String postnummer, String postort) {
        this.gatuadress = gatuadress;
        this.postnummer = postnummer;
        this.postort = postort;
    }
}
