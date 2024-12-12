import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void afficherPlateau(char[][] morpion) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(morpion[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("--+---+--");
        }
    }

    public static boolean verifierVictoire(char[][] morpion, char symbole) {
        for (int i = 0; i < 3; i++) {
            if (morpion[i][0] == symbole && morpion[i][1] == symbole && morpion[i][2] == symbole) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (morpion[0][i] == symbole && morpion[1][i] == symbole && morpion[2][i] == symbole) {
                return true;
            }
        }

        if (morpion[0][0] == symbole && morpion[1][1] == symbole && morpion[2][2] == symbole) {
            return true;
        }
        if (morpion[0][2] == symbole && morpion[1][1] == symbole && morpion[2][0] == symbole) {
            return true;
        }

        return false;
    }

    public static boolean estMatchNul(char[][] morpion) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (morpion[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        String JUn, JDeux;
        int ligne = -1;
        int colonne = -1;
        boolean entreeValide = false;

        System.out.println("Quelle est le prenom du joueur 1 (X) : ");
        JUn = clavier.nextLine();

        System.out.println("Quelle est le prenom du joueur 2 (O) : ");
        JDeux = clavier.nextLine();

        char[][] morpion = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        boolean jeuEnCours = true;
        char joueurActuel = 'X';
        String JMoment = JUn;

        while (jeuEnCours) {
            System.out.println("\nC'est au tour de " + JMoment + " (" + joueurActuel + ")");
            afficherPlateau(morpion);

            while (!entreeValide) {
                System.out.print("Entrez la ligne (0, 1, 2): ");
                if (clavier.hasNextInt()) {
                    ligne = clavier.nextInt();
                    if (ligne >= 0 && ligne < 3) {
                        System.out.print("Entrez la colonne (0, 1, 2): ");
                        if (clavier.hasNextInt()) {
                            colonne = clavier.nextInt();
                            if (colonne >= 0 && colonne < 3) {
                                if (morpion[ligne][colonne] == ' ') {
                                    entreeValide = true;
                                } else {
                                    System.out.println("Cette case est déjà occupée. Essayez encore.");
                                }
                            } else {
                                System.out.println("Colonne invalide. Veuillez entrer un nombre entre 0 et 2.");
                            }
                        } else {
                            System.out.println("Colonne invalide. Veuillez entrer un nombre entre 0 et 2.");
                            clavier.next();
                        }
                    } else {
                        System.out.println("Ligne invalide. Veuillez entrer un nombre entre 0 et 2.");
                    }
                } else {
                    System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                    clavier.next();
                }
            }


            morpion[ligne][colonne] = joueurActuel;


            if (verifierVictoire(morpion, joueurActuel)) {
                afficherPlateau(morpion);
                System.out.println(JMoment + " a gagné !");
                jeuEnCours = false;
            } else if (estMatchNul(morpion)) {
                afficherPlateau(morpion);
                System.out.println("Match nul !");
                jeuEnCours = false;
            } else {
                if (joueurActuel == 'X') {
                    joueurActuel = 'O';
                    JMoment = JDeux;
                } else {
                    joueurActuel = 'X';
                    JMoment = JDeux;
                }
            }
        }



    }
}