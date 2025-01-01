import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longueurSequence = 5;
        int maxTentative = 12;
        int[] secretSequence = genererSecretSequence(longueurSequence);
        int tentatives = 0;

        System.out.println("Bienvenue dans le jeu MasterMind !");
        System.out.println("Devinez une séquence de " + longueurSequence + " chiffres uniques (1-9). Vous avez " + maxTentative + " tentatives.");

        while (tentatives < maxTentative) {
            tentatives++;
            System.out.print("Tentative " + tentatives + ": ");
            String input = scanner.nextLine();

            if (input.length() != longueurSequence || !input.matches("[1-9]+")) {
                System.out.println("Entrée invalide. Entrez exactement " + longueurSequence + " chiffres entre 1 et 9.");
                tentatives--;
                continue;
            }

            int[] guess = new int[longueurSequence];
            for (int i = 0; i < longueurSequence; i++) {
                guess[i] = Character.getNumericValue(input.charAt(i));
            }

            if (!chiffresUniques(guess)) {
                System.out.println("Les chiffres de votre proposition doivent être uniques.");
                tentatives--;
                continue;
            }

            int correctPosition = 0;
            int correctNumber = 0;

            for (int i = 0; i < longueurSequence; i++) {
                if (guess[i] == secretSequence[i]) {
                    correctPosition++;
                } else if (contains(secretSequence, guess[i])) {
                    correctNumber++;
                }
            }

            if (correctPosition == longueurSequence) {
                System.out.println("Félicitations ! Vous avez trouvé la séquence secrète !");
                break;
            } else {
                System.out.println("Bien placés: " + correctPosition + ", Mal placés: " + correctNumber);
            }

            if (tentatives == maxTentative) {
                System.out.print("Vous avez épuisé vos tentatives. La séquence secrète était : ");
                for (int num : secretSequence) {
                    System.out.print(num);
                }
                System.out.println();
            }
        }

        scanner.close();
    }

    public static int[] genererSecretSequence(int length) {
        Random random = new Random();
        int[] sequence = new int[length];
        int i = 0;

        while (i < length) {
            int num = random.nextInt(9) + 1;
            if (!contains(sequence, num)) {
                sequence[i++] = num;
            }
        }
        return sequence;
    }

    public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean chiffresUniques(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
