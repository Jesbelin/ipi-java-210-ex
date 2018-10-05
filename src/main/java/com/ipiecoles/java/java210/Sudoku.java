package com.ipiecoles.java.java210;

import java.util.Scanner;

public class Sudoku {
		public static final String FIN_SAISIE = "FIN";

		public boolean resolu = false;

		public short [][] sudokuAResoudre;

		public short [][] getSudokuAResoudre ()
		{
			return sudokuAResoudre;
		}

		public void setSudokuAResoudre (short [][] tab)
		{
			sudokuAResoudre = tab;
		}

	/**
	 * Constructeur par défaut
	 */
	public Sudoku() {
		sudokuAResoudre = new short [9] [9];
		//autre méthode : setSudokuAResoudre(new short [9][9])
	}

	public static boolean ligneSaisieEstCoherente(String ligneSaisie) {
		//ligne ne doit pas être nulle ou vide
		if (ligneSaisie == null || ligneSaisie.trim().equals(""))
		{
			System.out.println("Les coordonnées du chiffre et/ou sa valeur ne peuvent pas être nulles, vides ou remplies avec des espaces");
			return false;
		}
		//ligne doit faire 3 caractères
		else if(ligneSaisie.length() != 3)
		{
			System.out.println("Les coordonnées du chiffre et/ou sa valeur doit faire 3 caractères");
			return false;
		}
		//1er chiffre doit être entre 0 et 8, 2ème doit être entre 0 et 8 et le 3ème entre 1 et 9
		//utiliser un '!' devant ligneSaisie pour être sûr de bien avoir false si c'est false et non l'inverse
		else if(!ligneSaisie.matches("[0-8][0-8][1-9]"))
		{
			System.out.println("L'abscisse et l'ordonnée doivent être compris entre 0 et 8, la valeur entre 1 et 9");
			return false;
		}
		return true;
	}

	/**
	 * Cette méthode invite l'utilisateur à saisir un ensemble de coordonnées pour initialiser un sudoku à résoudre.
	 * Les coordonnées prennent la forme XYZ avec X correspondant à l'abscisse, Y l'ordonnée et Z la valeur. Seules les
	 * chiffres présents sont à saisir et l'utilisateur doit appuyer sur entrée après chaque saisie. 
	 * Lorsqu'il a terminé sa saisie, il entre la chaîne FIN. La fonction remplit au fur et à mesure un tableau de String
	 * comportant les coordonnées des chiffres saisis.
	 * 
	 * A noter que pour chaque ligne saisie, sa cohérence est vérifiée en appelant la méthode ligneSaisieEstCoherente
	 * En cas de mauvaise saisie, la saisie ne doit pas être prise en compte et l'utilisateur doit pouvoir saisie une nouvelle ligne
	 * La fonction doit également gérer le cas où l'utilisateur ne rentre rien mais appuye sur Entrée
	 *
	 * @return Un tableau comportant les coordonnées des chiffres présents dans le sudoku à résoudre
	 */
	public static String[] demandeCoordonneesSudoku() {
		//Un sudoku fait 9 par 9, soit potentiellement 81 valeurs à remplir même si ce n'est pas très intéressant
		String[] tableauCoordonnees = new String[81]; //on déclare le tableau de coordonnes

		Scanner scanner = new Scanner(System.in); //permet de récupérer la saisie de l'utilisateur

		String ligneSaisie = scanner.nextLine(); // bloque tout tant que l'utilisateur n'a rien saisi ni tapé Entrée

		int i =0;

		while (!ligneSaisie.equals("FIN"))
			//Tester si ligne cohérente
			//Si oui, on la rentre dans le tableau
			//Si non, on informe l'utilisateur de l'erreur et lui redemande de saisir de nouvelles coordonnées
		{
			if (ligneSaisieEstCoherente(ligneSaisie))
			{
				tableauCoordonnees[i] = ligneSaisie; //la saisie de l'utilisateur sera aux coordonnées 'i'
				i++; //on passe à la coordonnée suivante
			}
			else
			{
				System.out.println("Coordonnées fausses, réessayer");
			}

			ligneSaisie = scanner.nextLine(); //Pour passer à la ligne de saisie suivante
		}

		scanner.close(); //Plus de saisie à faire, on ferme donc le scanner.

		return tableauCoordonnees; //on renvoie le tableau
	}
	
	/**
	 * La méthode prend un tableau de coordonnées de chiffre soud la forme XYZ avec X correspondant 
	 * à l'abscisse, Y l'ordonnée et Z la valeur et remplit le tableau sudokuAResoudre avec les bonnes valeurs
	 * au bon endroit. Ex 012, première ligne deuxième colonne, on met la valeur 2. Lorsqu'une valeur nulle est 
	 * rencontrée dans le tableau, on arrête le traitement
	 * 
	 * Pour passer d'une String à un short, on pourra utiliser la méthode stringToInt(string)
	 * 
	 * @param tableauCoordonnees
	 */
	public void remplitSudokuATrous(String[] tableauCoordonnees) {
		//définir ligne colonne valeur
		int ligne = 0;
		int colonne = 0;
		short valeur = 1;
		Short.parseShort(valeur);

		//parcourir le tableau tableauCoordonnees
		

		//pour chacune des valeurs
			//-> extrait ligne colonne valeur


		//on met la valeur au bon endroit dans sudokuAResoudre
		sudokuAResoudre[ligne][colonne] = valeur;
    }
	
	private int stringToInt(String s) {
		return Integer.parseInt(s);

	}
	
	/**
	 * Cette méthode affiche un sudoku de manière formatée sur la console.
	 * Cela doit ressembler exactement à :
	 * -----------------------
	 * |   8   | 4   2 |   6   |
	 * |   3 4 |       | 9 1   |
	 * | 9 6   |       |   8 4 |
	 *  -----------------------
	 * |       | 2 1 6 |       |
	 * |       |       |       |
	 * |       | 3 5 7 |       |
	 *  -----------------------
	 * | 8 4   |       |   7 5 |
	 * |   2 6 |       | 1 3   |
	 * |   9   | 7   1 |   4   |
	 *  -----------------------
	 * 
	 * @param sudoku tableau de short représentant les valeurs d'un sudoku (résolu ou non). 
	 * Ce tableau fait 9 par 9 et contient des chiffres de 0 à 9, 0 correspondant à une valeur 
	 * non trouvée (dans ce cas, le programme affiche un blanc à la place de 0
	 */
	public void ecrireSudoku(short[][] sudoku) {
		
    }
	
	/**
	 * Cette méthode vérifie si un chiffre est autorisé à la position d'abscisse et
	 * d'ordonnée donnés dans le sudoku en appliquant les règles suivantes : 
	 * 
	 * 1 : Si la valeur est déjà dans la ligne, le chiffre n'est pas autorisé
	 * 2 : Si le valeur est déjà dans la colone, le chiffre n'est pas autorisé
	 * 3 : Si la valeur est est déjà dans la boite, le chiffre n'est pas autorisé
	 * 
	 * @param abscisse
	 * @param ordonnee
	 * @param chiffre
	 * @param sudoku
	 * @return
	 */
	public static boolean estAutorise(int abscisse, int ordonnee, short chiffre, short[][] sudoku) {
		return true;
    }

	public boolean resoudre(int abscisse, int ordonnee, short[][] sudoku) {
		return true;
    }
}