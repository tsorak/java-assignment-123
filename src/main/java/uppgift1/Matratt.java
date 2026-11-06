package uppgift1;

public class Matratt {
    // Använder final här för att tydliggöra att fälten inte kommer byta värden under programmets gång. 
    // I framtiden vill man kanske kunna ändra pris på existerande maträtter, men det är inte en del av speccen!
    private final String namn;
    private final double pris;
    private final MatrattTyp typ;
    private final int antalKalorier;

    public Matratt(String namn, double pris, MatrattTyp typ, int antalKalorier) {
        this.namn = namn;
        this.pris = pris;
        this.typ = typ;
        this.antalKalorier = antalKalorier;
    }

    public String getNamn() {
        return namn;
    }

    public double getPris() {
        return pris;
    }

    public MatrattTyp getTyp() {
        return typ;
    }

    public int getAntalKalorier() {
        return antalKalorier;
    }
}
