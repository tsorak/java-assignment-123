package uppgift2;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Anna", "Andersson", "Tekniska högskolan", 22);

        System.out.println("Förnamn: " + student.getFornamn());
        System.out.println("Efternamn: " + student.getEfternamn());
        System.out.println("Skola: " + student.getSkola());
        System.out.println("Ålder: " + student.getAlder());
    }
}
