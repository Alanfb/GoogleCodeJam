package Pratice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fixit {
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	final static String FILE_NAME = "teste";// <<<--------
	//final static String FILE_NAME = "A-small-practice";// <<<--------
	//final static String FILE_NAME = "A-large-practice";// <<<--------

	final static String BASE = "C:/CodeJam/" + FILE_NAME;
	final static String INPUT = BASE + ".in";
	final static String OUTPUT = BASE + ".out";
	static Scanner in;
	static PrintWriter out;
	public static void main(String[] args) {
		try {
			in = new Scanner(new FileReader(INPUT));
			out = new PrintWriter(OUTPUT);

			int number_of_cases = in.nextInt();
			in.nextLine();
			for (int c = 0; c < number_of_cases; c++) {
				out.print("Case #" + (c + 1) + ": ");

				if (DEBUG_ENABLE)
					System.out.println("Solving case " + (c + 1) + "...");
				if (TIMER_ENABLE) {
					long startTime = System.currentTimeMillis();
					caseSolver();
					long endTime = System.currentTimeMillis();
					System.out.println((endTime - startTime) + " ms");
				} else
					caseSolver();

				out.println();
			}
			out.println();
			out.flush();
			out.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void caseSolver(){
		
	}

}