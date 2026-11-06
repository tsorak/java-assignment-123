package uppgift1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Matratt> lunchmeny = new ArrayList<>();
        lunchmeny.add(new Matratt("Linsgryta", 109.0, MatrattTyp.VEGANSK, 520));
        lunchmeny.add(new Matratt("Halloumiburgare", 125.0, MatrattTyp.VEGETARISK, 680));
        lunchmeny.add(new Matratt("Köttbullar med potatismos", 119.0, MatrattTyp.KOTT, 750));

        System.out.println("Dagens lunchmeny");
        System.out.println("-----------------");

        for (Matratt matratt : lunchmeny) {
            System.out.printf(
                    "%s – %.2f kr (%s, %d kcal)%n",
                    matratt.getNamn(),
                    matratt.getPris(),
                    matratt.getTyp(),
                    matratt.getAntalKalorier()
            );
        }
    }
}
