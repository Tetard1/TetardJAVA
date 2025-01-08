import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String rejouer;

        do {
            int[] sequenceSecrete = new int[5];

            boolean[] utilise = new boolean[10];

            System.out.println("j2 : Entrez une séquence de 5 chiffres entre 1 et 9 (entre chaque chiffre veuillez mettre un espace) :");

            for (int i = 0; i < 5; i++) {

                int chiffre;

                do {

                    chiffre = scanner.nextInt();

                    if (chiffre < 1 || chiffre > 9 || utilise[chiffre]) {

                        System.out.println("Chiffre invalide ou déjà utilisé. Essayez à nouveau :");

                    }

                } while (chiffre < 1 || chiffre > 9 || utilise[chiffre]);

                sequenceSecrete[i] = chiffre;

                utilise[chiffre] = true;

            }

            scanner.nextLine();

            System.out.println("La séquence a été donner par le j2 !");

            int tentativesRestantes = 12;

            boolean victoire = false;

            while (tentativesRestantes > 0 && !victoire) {

                System.out.println("\nIl vous reste " + tentativesRestantes + " tentatives.");

                System.out.println("Proposez une séquence de 5 chiffres (séparés par des espaces) :");


                int[] proposition = new int[5];

                for (int i = 0; i < 5; i++) {

                    proposition[i] = scanner.nextInt();

                }

                int bienPlaces = 0;

                int malPlaces = 0;

                boolean[] utiliseDansSecrete = new boolean[5];

                boolean[] utiliseDansProposition = new boolean[5];

                for (int i = 0; i < 5; i++) {

                    if (proposition[i] == sequenceSecrete[i]) {

                        bienPlaces++;

                        utiliseDansSecrete[i] = true;

                        utiliseDansProposition[i] = true;

                    }

                }

                for (int i = 0; i < 5; i++) {

                    if (!utiliseDansProposition[i]) {

                        for (int j = 0; j < 5; j++) {

                            if (!utiliseDansSecrete[j] && proposition[i] == sequenceSecrete[j]) {

                                malPlaces++;

                                utiliseDansSecrete[j] = true;

                                break;

                            }

                        }

                    }

                }

                if (bienPlaces == 5) {

                    victoire = true;

                    System.out.println("\nBien joué! Vous avez deviné la séquence!");

                } else {

                    System.out.println("\nIndices :");

                    System.out.println("- Chiffres bien placés : " + bienPlaces);

                    System.out.println("- Chiffres mal placés : " + malPlaces);

                }

                tentativesRestantes--;

            }

            if (!victoire) {

                System.out.println("\nVous n'avez plus de tentatives. La séquence était : ");

                for (int chiffre : sequenceSecrete) {

                    System.out.print(chiffre + " ");

                }

                System.out.println();

            }

            System.out.println("\nVoulez-vous rejouer ? (oui/non)");

            scanner.nextLine();

            rejouer = scanner.nextLine().trim().toLowerCase();

        } while (rejouer.equals("oui"));

        System.out.println("Merci d'avoir joué !");
    }

}
