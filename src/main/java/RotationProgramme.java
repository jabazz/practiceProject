package main.java;

import java.util.Scanner;

public class RotationProgramme {
	public static void main(String... args) {
		System.out.println("Rotational programe stated");
		int[][] table = new int[4][4];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (j == 0) {
					table[i][j] = sc.nextInt();
				} else {
					table[i][j] = 0;
				}

		showTable(table);
		 rotateTableBottom(table);
		 rotateTableRight(table);
		 rotateTableUp(table);
		 rotateDiagonal(table);

	}

	public static void showTable(int[][] table) {
		for (int x[] : table) {
			for (int y : x) {
				System.out.print(y);
			}
			System.out.println();
		}
	}
	public static void putTable(int[][] newtable, int[][] oldtable){
		for(int i=0; i<4; i++)
			for(int j=0 ; j<4; j++){
				newtable[i][j] = oldtable[i][j];
			}
	}
	
	public static void rotateTableBottom(int[][] table) {
		System.out.println("bottom rotate");
		int[][] bottomtable = new int[4][4];
		putTable(bottomtable, table);
		for (int i = 3; i >= 0; i--)
			for (int j = 3; j >= 0; j--)
				if (i == 3) {
					bottomtable[i][j] = bottomtable[j][0];
					bottomtable[j][0] = 0;
				}
		showTable(bottomtable);
	}

	public static void rotateTableRight(int[][] table) {
		System.out.println("right rotate");
		int[][] righttable = new int[4][4];
		putTable(righttable, table);
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (j == 3) {
					righttable[i][j] = righttable[i][0];
					righttable[i][0] = 0;
				}
		showTable(righttable);
	}

	public static void rotateTableUp(int[][] table) {
		System.out.println("rotate up");
		int[][] uptable = new int[4][4];
		putTable(uptable, table);
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (i == 0) {
					uptable[i][j] = uptable[j][0];
					if (j != 0)
						uptable[j][0] = 0;
				}
		showTable(uptable);
	}

	public static void rotateDiagonal(int[][] table) {
		System.out.println("Diagonal rotate");
		int[][] diatable = new int[4][4];
		putTable(diatable, table);
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (i == j) {
					diatable[i][j] = diatable[i][0];
					if (j != 0)
						diatable[j][0] = 0;
				}
		showTable(diatable);
	}
}
