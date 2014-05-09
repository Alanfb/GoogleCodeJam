package roundB_2014;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TheRepeater {
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	//final static String FILE_NAME = "teste";// <<<--------
	//final static String FILE_NAME = "A-small-practice";// <<<--------
	final static String FILE_NAME = "A-large-practice";// <<<--------

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
		String[] auxS = new String[n];
		int i,j;
		boolean v=true;
		int[] len = new int[n];
		for(i=0;i<n;i++) {
			str[i] = compress(in.next());
			len[i] = str[i].length();
			auxS[i] = str[i].replaceAll("[0-9]","");
		}
		
		//for(i=0;i<n;i++) {
		//	System.out.println(str[i]);
		//	System.out.println(len[i]);
		//	if(len[i]!=len[0]) v =false;
		//}
		//Check if it is possible dif lenghts
		for(i=0;i<n;i++){
			if(v==false) break;
			for(j=i+1;j<n;j++){
				if(auxS[i].length() != auxS[j].length()){
					v=false;
					break;
				}
			}
		}
		//Check if is possible on cases like (ab/ba) 	
		for(i=1;i<n;i++){
			if(v==false) break;
			for(j=0;j<auxS[i].length();j++){
				if(auxS[i-1].charAt(j)!=auxS[i].charAt(j)){
					v=false;
					break;
				}
			}
		}
		
		if(v==false){
			out.print("Fegla Won");
			System.out.println("Fegla Won");
			return;
		}
		//Get Min
		int s=1;
		for(i=1;i<n;i++){
			if(str[i-1].equals(str[i])) s++;
		}
		if(s==n){
			out.print(0);
			System.out.println(0);
			return;
		}
		//Read Number on String
		Scanner[] read = new Scanner[n];
		for(i=0;i<n;i++){
			read[i] = new Scanner(str[i]);
		}
		
		//int[] qnt = new int[100];
		int sum = 0,aux;
		List<Integer> lista = new ArrayList<Integer>();
		
		for(i=0;i<auxS[0].length();i++){
			int[] qnt = new int[100];
			for(j=0;j<n;j++){
				aux = read[j].useDelimiter("[^\\d]+").nextInt();
				qnt[aux-1]++;
				if(lista.contains(aux)==false) lista.add(aux);
			}
			sum += getDist(lista,qnt);
			lista.clear();
		}
		
		
		out.print(sum);
		System.out.println(sum);
	}
	
	public static int getDist(List<Integer> lista, int[] qnt){
		int i,j,dist=0,dist2,sum=0;
		if(lista.size() == 1) return 0;
		int[] soma = new int[lista.size()];
		Collections.sort(lista);
		
		
		if(lista.size()==2){
			if(qnt[lista.get(1)-1] > qnt[lista.get(0)-1]) return Math.abs(lista.get(1)-lista.get(0))*qnt[lista.get(0)-1];
			if(qnt[lista.get(1)-1] <= qnt[lista.get(0)-1]) return Math.abs(lista.get(1)-lista.get(0))*qnt[lista.get(1)-1];
		}

		for(i=0; i<lista.size();i++){
			dist=-1;
			for(j=0;j<lista.size();j++){
				dist2 = Math.abs(lista.get(i)-lista.get(j));
				soma[i] += dist2*qnt[lista.get(j)-1];
				}
		}
		sum = soma[0];
		for(i=1;i<lista.size();i++){
			if(soma[i]<sum) {
				sum = soma[i];
			}
		}
		return sum;
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
