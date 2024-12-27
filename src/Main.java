import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longueurSequence = 5;
        int maxTentative = 12;
        int tentatives = 0;

        System.out.println("Bienvenue dans le jeu MasterMind !");
        System.out.println("Devinez une séquence de " + longueurSequence + " chiffres uniques (1-9). Vous avez " + maxTentative + " tentatives.");

        while (tentatives < maxTentative) {
            tentatives++;
            System.out.print("Tentative " + tentatives + ": ");
            String input = scanner.nextLine();

        }
    }
}
