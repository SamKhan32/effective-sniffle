package punnetSqaure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PunnetSqaure extends PunnetSqaureMethods {

	public static void main(String[] args) {
		// let's try to make a table UI

		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		System.out.println("Put in gene 1, press enter then put in gene 2");
		String gene1 = input.nextLine();
		String gene2 = input2.nextLine();
		ArrayList<String> geneTop = new ArrayList<String>();
		ArrayList<String> geneLeft = new ArrayList<String>();
		String[][] table1;
		int count = 1;
		int AlleleTypesOne = 0;
		int AlleleTypesTwo = 0;
		int counterTwo = 0;
		String previous = " ";
		String current1 = " ";
		if (gene1.length() != gene2.length() || gene1.length() % 2 != 0 || gene2.length() % 2 != 0) {
			System.out.println(
					"You put it in wrong, try again idiot (Problem: One or more genes is/are even or unequal genes or wrong amount of alleles)"
							+ "\nProgram Terminated");
			System.exit(0);
		}
		if (gene1.length() == 2) { // make it check for if there are two alleles to make a special check
			// execute method regular cross
			System.out.println("I have to make this program for regular cross cases");
			System.exit(0);
		}

		for (int i = gene1.length() - 2; i >= 0; i--) {
			previous = gene1.substring(i + 1, i + 2);
			current1 = gene1.substring(i, i + 1);
			if (previous.equalsIgnoreCase(current1)) {
				AlleleTypesOne++;
				count++;
			} else {
				count = 1;
			}
			if (count > 2) {
				System.out.println("Too many or too little alleles of one type in gene1");
				System.exit(0);
			}
		}
		count = 1;
		for (int i = gene2.length() - 2; i >= 0; i--) {
			previous = gene2.substring(i + 1, i + 2);
			current1 = gene2.substring(i, i + 1);
			if (previous.equalsIgnoreCase(current1)) {
				AlleleTypesTwo++;
				count++;
			} else {
				count = 1;
			}
			if (count > 2) {
				System.out.println("Too many or too little alleles of one type in gene2");
				System.exit(0);
			}
		}

		for (int i = 0; i < gene1.length(); i++) { // makes gene1 into geneTop Should this be an array finisher?
			geneTop.add(gene1.substring(i, i + 1));
			geneLeft.add(gene2.substring(i, i + 1));
		}
		String[][] geneOne = new String[AlleleTypesOne][2];
		String[][] geneTwo = new String[AlleleTypesTwo][2];
		for (int i = 0; i < geneTop.size() / 2; i++)
			for (int j = 0; j < 2; j++) {

				geneOne[i][j] = geneTop.get(counterTwo);
				counterTwo++;
			}
		counterTwo = 0;
		for (int i = 0; i < geneTop.size() / 2; i++)
			for (int j = 0; j < 2; j++) {

				geneTwo[i][j] = geneLeft.get(counterTwo);
				counterTwo++;
			}

		String[] realizedGene1 = alphabeta(realize(geneOne)); // this works AaBb x AaBb turns into a realized and order
		String[] realizedGene2 = alphabeta(realize(geneTwo));

		table1 = realizeTable(realizedGene1, realizedGene2);

		makeTable(table1, realizedGene1, realizedGene2); // making the bottom, it presumes that it is a 4x4 for some damn reason
														 // "for some damn reason" lmao, bottomTable and punnetSquare are hard coded
	}

	public static String[] realize(String[][] alleles) { // turns the alleles into actual genotypes
		if (alleles.length == 1) // base case
		{
			String[] combos = { alleles[0][0], alleles[0][1] };
			return combos;
		} else {
			String[] combos = new String[(int) Math.pow(2, alleles.length)]; // 2^alleles.length - reminder that
																				// alleles.lenght of a 2d array of AaBb
																				// would only equal 2!
			String[] otherTraits = realize(Arrays.copyOfRange(alleles, 1, alleles.length));
			for (int i = 0; i < combos.length; i++) {
				// System.out.println("TEST FOR COMBOS_LENGTH: " + i + "| " +
				// i*2/combos.length); //tester - Should delete
				combos[i] = otherTraits[i % otherTraits.length] + alleles[0][i * 2 / combos.length];
			}
			return combos;
		}
	}

	public static String[] alphabeta(String[] disorder) { // orders the genes along alphabetical lines, with no regards
															// to case
		String[] findABetterName = disorder; // I'm pretty sure this is useless as well
		String[] order = disorder; // useless, I just like the aesthetic of this - Order from Disorder
		int setter = 0;
		for (int i = 0; i < disorder.length; i++) {
			findABetterName = disorder[i].split("");
			Arrays.sort(findABetterName, String.CASE_INSENSITIVE_ORDER);
			order[setter] = String.join("", findABetterName);
			setter++;
		}
		return order;
	}

	public static String[][] realizeTable(String[] x, String[] y) { // makes the content of the table
		String[][] table = new String[x.length][y.length];
		String genotype = " ";
		int count = 0;
		for (int i = 0; i < x.length; i++) {

			for (int j = 0; j < y.length; j++) {
				genotype = x[j] + y[i];
				// could just make genotype into a String[]?
				// fuck actually just figure out the other way, it is simpler
				table[i][j] = alphabeta(genotype);

				count++;

			}
		}
		return table;

	}

	private static String alphabeta(String genotype) { // sorts the genotypes in alphabetical order
		String[] temp = genotype.split("");
		Arrays.sort(temp);
		Arrays.sort(temp, String.CASE_INSENSITIVE_ORDER);
		genotype = String.join("", temp);

		return genotype;
	}

	private static void makeTable(String[][] innerTable, String[] topLayer, String[] leftColumn) { // prints the Punnet Square
		String[][] bottomTable = new String[innerTable.length][innerTable.length+1];
		String[][] punnetSqaure = new String[innerTable.length+1][innerTable.length+1];

		for (int i = 0; i < bottomTable.length; i++) {
			for (int j = 0; j < 1; j++) {
				bottomTable[i][j] = leftColumn[i];
			}
		}
		int count1 = 0;
		int count = 0;
		for (int i = 0; i < innerTable.length; i++) {
			for (int j = 1; j < innerTable[0].length; j++) {
				bottomTable[i][j] = innerTable[count1][count];
				count++;
			}
			count1++;
			count = 0;
		}

		count = innerTable.length - 1;
		for (int i = 0; i < bottomTable.length; i++) {
			for (int j = bottomTable[0].length - 1; j < bottomTable[0].length; j++) {
				bottomTable[i][j] = innerTable[i][count];
			}
		}
		// bottom Table made
	//	System.out.print(Arrays.deepToString(bottomTable)); 
		// making full punnet square
		count = 0;
		for (int j = 1; j < punnetSqaure[0].length; j++) {
			punnetSqaure[0][0] = "  "; // Redundant but I don't care
			punnetSqaure[0][j] = topLayer[count];
			count++;
		}
		count = 0;
		for (int i = 1; i < punnetSqaure.length; i++) {
			for (int j = 0; j < punnetSqaure[0].length; j++) {
				punnetSqaure[i][j] = bottomTable[count][j];

			}
			count++;
		}

		for (int i = 0; i < punnetSqaure.length; i++) {
			for (int j = 0; j < punnetSqaure[0].length; j++) {
				System.out.print(String.format("%-10s", punnetSqaure[i][j])); 

			}
			System.out.println("\n");

		}

	}

}
