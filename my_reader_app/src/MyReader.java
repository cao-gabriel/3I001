import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyReader {
	
	private int[][] values;
	private int nbColumn;
	private int nbLine;
	
	public void initFromFile(String fichier) throws FileNotFoundException {
		BufferedReader in;
		in = new BufferedReader ( new FileReader (new File(fichier)));
		try {
			/*-------FORMAT FILE CHECK----------*/
			System.out.println("Initalisation of a data table with the file : " + fichier);
			/*FIRST LINE CHECK*/
			String[] buffer = in.readLine().split(" ");
			if(!lengthOK(buffer, 1)) {
				System.err.println("First line of the file should only contain the number"
						+ "of lines of your data table");
				return ;
			}
			if(!this.isNumber(buffer[0])) return ;
			nbLine = Integer.parseInt(buffer[0]);
			
			/*SECOND LINE CHECK*/
			buffer = in.readLine().split(" ");
			if(!this.lengthOK(buffer, 1)) {
				System.err.println("Second line of the file should only contain the number"
						+ "of columns of your data table");
				return;
			}
			if(!this.isNumber(buffer[0])) return ;
			nbColumn = Integer.parseInt(buffer[0]);
		
			
			/*VALUES TABLE CREATION*/
			values = new int[this.nbLine][this.nbColumn];
			
			for (int i = 0; i < values.length; i++) {
				
				buffer = in.readLine().split(" ");
				/*CHECK THE NUMBER OF COLUMNS OF EACH LINE*/
				if(!this.lengthOK(buffer, values[i].length)) {
						System.out.println("The line " + i + " doesn't have the right number of colum");
						return;
				}
				/*FILLING OUR TABLE*/
				for (int j = 0; j < values[0].length; j++) {
					if(!this.isNumber(buffer[j])) {
						System.out.println(buffer[j] + " is not an number");
						return;
					}
					values[i][j] = Integer.parseInt(buffer[j]);
					
				}
			}
			
			System.out.println("The file has been processed. Your data is available.");
			this.printData();
		} catch (IOException e) {
			System.out.println("Nothing opened, can't read");
			return;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("Nothing to close");
			}
		}
	}
	
	
	private void printData() {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				System.out.print(String.format("%3d",values[i][j]) + " ");
			}
			System.out.println();
		}
		
	}


	private boolean lengthOK(String[] buffer, int i) {
		if(buffer.length != i) {
			
			return false;
			
		}
		return buffer.length == i;
	}


	private boolean isNumber(String s) {
		try {				
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException nb) {
			System.out.println("Write a number instead of " + s);
			return false;
		}
	}
	
	public static void main(String[] args) {
		MyReader reader = new MyReader();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name containing your data :");
		String file = input.nextLine();
		boolean existFile = false;
		while(!existFile ) {
			try {
				reader.initFromFile(file);
				existFile = true;
			} catch (FileNotFoundException e) {
				System.out.println("Error while opening the file. Try again.");
				file = input.nextLine();
			} 
		}
		
		
	}
	
}