package roundB_2014;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class TheRepeater {
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	final static String FILE_NAME = "teste";// <<<--------
	//final static String FILE_NAME = "B-small-practice";// <<<--------
	//final static String FILE_NAME = "B-large-practice";// <<<--------

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
		int n = in.nextInt();
		String[] str = new String[n];
		int i,j,k,cont=0;
		boolean v=true;
		int[] len = new int[n];
		int[] check = new int[200];
		for(i=0;i<n;i++) {
			str[i] = compress(in.next());
			len[i] = str[i].length();
			if(len[i]!=len[0]) v =false;
		}
		//for(i=0;i<n;i++) {
		//	System.out.println(str[i]);
		//	System.out.println(len[i]);
		//	if(len[i]!=len[0]) v =false;
		//}
		if(v==false){
			out.print("Fegla Won");
			System.out.println("Fegla Won");
			return;
		}
		//Check if is possible on cases like (ab/ba)
		for(i=1;i<n;i++)
			for(j=0;j<len[0]/2;j+=2)
				if(str[i-1].charAt(j) != str[i].charAt(j)) v=false;
		
		if(v==false){
			out.print("Fegla Won");
			System.out.println("Fegla Won");
			return;
		}
		//Get Min
		int Min = str[0].charAt(1),Max=str[0].charAt(1),Mid=str[0].charAt(1),lMax=str[0].charAt(1);
		
		int[] sum = new int[len[0]/2];
		for(i=1;i<len[0];i+=2){
			for(j=1;j<n;j++){
				if((int)str[j].charAt(1) < Min) Min = str[j].charAt(1);
			}
		}
		
		
		out.print(cont);
		System.out.println(cont);
	}
	
	public static String compress(String str){
		int cont=1;
		int l = str.length();
		StringBuilder ptr = new StringBuilder();
		for(int i =0 ; i<l ;i++){
			ptr.append(str.charAt(i));
			if(i+1 != l){
			while(str.charAt(i) == str.charAt(i+1)){
				cont++;
				i++;
				if(i+1==l) {break;}
			}
			}
			ptr.append(cont);
			cont=1;
		}

			str = ptr.toString();
		
		return str;
	}

}
