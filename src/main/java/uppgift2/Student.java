package uppgift2;

public class Student {
    private String fornamn;
    private String efternamn;
    private String skola;
    private int alder;

    public Student(String fornamn, String efternamn, String skola, int alder) {
        this.fornamn = fornamn;
        this.efternamn = efternamn;
        this.skola = skola;
        this.alder = alder;
    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public String getSkola() {
        return skola;
    }

    public void setSkola(String skola) {
        this.skola = skola;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }
}
