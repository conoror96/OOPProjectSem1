package ie.gmit.sw;

import java.util.Scanner;

public class UI {
	private String file1;
	private String file2;
	private int shingleSize;
	private int option;

	public UI() {
		super();
	}

	public UI show() {
		// Project Header
		System.out.println("---------------------------------------------------------");
		System.out.println("     A Java API for Measuring Document Similarity");
		System.out.println("G00338592 - Conor O'Reilly - Software Development Year 3");
		System.out.println("----------------------------------------------------------");

		// do{
		/*
		 * System.out.println("Press 1 to start similarity check");
		 * System.out.println("Press 2 to exit");
		 */
		String menu = "Press 1 to start similarity check\nPress 2 to exit";
		option = getInputInt(menu);
		if (option == 1) {
			this.file1 = getInputString("Enter File 1 ");
			this.file2 = getInputString("Enter File 2 ");
			this.shingleSize = getInputInt("Enter Shingle Size ");
			System.out.println("| file1 = " + file1 + " | file2 = " + file2 + " | Shingle Size = " + shingleSize);
		}
		// }while(option!=2);

		return null;

	}

	// getters setters
	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public int getShingleSize() {
		// TODO Auto-generated method stub
		return shingleSize;
	}

	public void setShingleSize(int shingleSize) {
		this.shingleSize = shingleSize;
	}

	///////////////////////////////////////////////////
	// take in the file names
	public static String getInputString(String input) {
		Scanner scanner = new Scanner(System.in);
		String output = "";

		System.out.println(input);
		output = setFileName(scanner.next());
		return output;
	}

	// take in the int for menu choice
	public static int getInputInt(String input) {
		Scanner scanner = new Scanner(System.in);
		int output;

		System.out.println(input);
		output = scanner.nextInt();

		return output;
	}// getStringInput
		// add the .txt extension if not there already

	private static String setFileName(String fileName) {
		// TODO Auto-generated method stub
		String txt = ".txt";
		if (!fileName.contains(txt)) {
			return fileName + txt;
		}

		return fileName;
	}

}
