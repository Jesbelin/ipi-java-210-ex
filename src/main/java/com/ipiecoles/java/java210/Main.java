package com.ipiecoles.java.java210;

public class Main {
    public static void main(String[] args)
    {
        Sudoku monSudoku = new Sudoku();
        System.out.println("Merci de renseigner chaque coordonnées et de finir par FIN");
        String[] coordonnees = monSudoku.demandeCoordonneesSudoku();
        monSudoku.remplitSudokuATrous(coordonnees);
        monSudoku.ecrireSudoku(monSudoku.getSudokuAResoudre());
        //resolution

        //Il y a une solution -> on affiche sudoku
        //monSudoku.ecrireSudoku(monSudoku.getSudokuAResoudre());

        //Il n'y a pas de solution -> on affiche "pas de solution"
        //System.out.println("Pas de solution");
    }
}
