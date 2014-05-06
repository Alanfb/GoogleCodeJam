import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class ManageyourEnergy {
	
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	final static String FILE_NAME = "teste";// <<<--------

	final static String BASE = "C:/CodeJam/" + FILE_NAME;
	final static String INPUT = BASE + ".in";
	final static String OUTPUT = BASE + ".out";
	static Scanner in;
	static PrintWriter out;
	
	public static class A implements Comparable<A>{
		long value;
		int pos;
		
		public A(long v,int pos){
			value = v;
			this.pos = pos;
		}
		
		public int compareTo(A a){
			if(this.value < a.value) return -1;
			if(this.value > a.value) return 1;
			return 0;
		}
		
		public String toString(){
			return "Valor:" + value + "Posicao:" + pos;
		}
	}
	
	public static void caseSolver(){
		long E = in.nextLong();
		long R = in.nextLong();
		if (R>E) R=E;
		int N = in.nextInt();
		int i;
		long aux = 0;
		A[] v = new A[N];
		for(i =0;i<N;i++){
			aux = in.nextLong();
			v[i] = new A(aux,i);
		}
		Arrays.sort(v);
		for(i=0;i<N;i++){
			System.out.println(v[i]);
		}
	}

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
	

}
