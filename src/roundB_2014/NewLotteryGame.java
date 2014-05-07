package roundB_2014;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class NewLotteryGame {
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	//final static String FILE_NAME = "teste";// <<<--------
	//final static String FILE_NAME = "B-small-practice";// <<<--------
	final static String FILE_NAME = "B-large-practice";// <<<--------

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
		long a = in.nextLong();
		long b = in.nextLong();
		long k = in.nextLong();
		long cont=0;
		long i,j;
		if(a<=k || b<=k){
			out.print(a*b);
			System.out.println(a*b);
			return;
		}
		cont=k*(a+b-k);
		for(i=k;i<a;i++){
			for(j=k;j<b;j++){
				if((i&j)<k){
					cont++;
					//System.out.println("<" + i + "," + j + ">");
				}
			}
		}
		
		out.print(cont);
		System.out.println(cont);
	}
}
