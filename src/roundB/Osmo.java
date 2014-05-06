package roundB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Osmo {
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	//final static String FILE_NAME = "teste";// <<<--------
	final static String FILE_NAME = "A-small-practice";// <<<--------
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
		int a = in.nextInt();
		int n = in.nextInt();
		int[] m = new int[n];
		int i,cont=0;
		int aux;
		
		for(i=0;i<n;i++){
			m[i] = in.nextInt();
		}
		if(a==1) {
			out.print(n);
			System.out.println(n);
			return;
		}
		Arrays.sort(m);
		i=0;
	
		while(true){
			if(a>m[i]) a+=m[i];
			else{
				aux = (int)((m[i]-a)/(a-1));
				if(aux==0) aux=1;
				if(aux < (n-i)) {
					if(a-1>1000000) a=a+(1000000)*aux;
					else a=a+(a-1)*aux;
					cont += aux;
					i--;
				}
				else{
					cont += n-i;
					break;
				}
			}
			i++;
			if(i>=n) break;
		}
		out.print(cont);
		System.out.println(cont);
	}

}
