

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.abs;
import static java.util.Arrays.sort;

public class TheRepeater {
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	//final static String FILE_NAME = "teste";// <<<--------
	//final static String FILE_NAME = "A-small-practice1";// <<<--------
	final static String FILE_NAME = "A-large-practice1";// <<<--------

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
		String s[] = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = in.next();
		}
		String sig = null;
		int counts[][] = null;
		for (int i = 0; i < n; i++) {
			String cur = s[i];
			char curSig[] = new char[cur.length()];
			int curSigN = 0;
			for (int j = 0; j < cur.length(); j++) {
				if (j == 0 || cur.charAt(j) != cur.charAt(j - 1)) {
					curSig[curSigN++] = cur.charAt(j);
				}
			}
			String curSigS = new String(curSig, 0, curSigN);
			if (i == 0) {
				sig = curSigS;
				counts = new int[sig.length()][n];
			} else if (!sig.equals(curSigS)) {
				//printCase();
				out.print("Fegla Won");
				return;
			}
			for (int j = 0, k = 0; j < cur.length(); j++) {
				if (j > 0 && cur.charAt(j) != cur.charAt(j - 1)) {
					k++;
				}
				counts[k][i]++;
			}
		}
		int ans = 0;
		for (int i = 0; i < sig.length(); i++) {
			sort(counts[i]);
			for (int j = 0; j < n; j++) {
				ans += abs(counts[i][j] - counts[i][n / 2]);
			}
		}
		out.print(ans);
	}
	
	public static int getDist(List<Integer> lista){
		int i,j,dist=0,dist2,distMax=0,sum=0,sum2=0;
		if(lista.size() == 1) return 0;
		
		dist = Math.abs(lista.get(1)-lista.get(0));
		
		for(i=0; i<lista.size();i++){
			for(j=i+1;j<lista.size();j++){
				dist2 = Math.abs(lista.get(i)-lista.get(j));
				if(dist2 > dist){
					dist=dist2;
				}
				sum += dist2;
				}
				if(i!=0){
					if(sum < sum2){
						distMax = dist;
					}
				}
				else{
					distMax = dist;
				}
				sum2=sum;
		}
		return distMax;
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
