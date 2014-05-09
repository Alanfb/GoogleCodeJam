package roundB_2014;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TheBoredTravelingSalesman {
	static int[] trip = new int [8];
	static int cont=0;
	final static Boolean DEBUG_ENABLE = true;
	final static Boolean TIMER_ENABLE = true;

	final static String FILE_NAME = "teste";// <<<--------
	//final static String FILE_NAME = "C-small-practice";// <<<--------
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
		int i,j,k;
		int n = in.nextInt();
		int m = in.nextInt();
		cont =0;
		for(i=0;i<n;i++) trip[i]=0;
		City[] city = new City[n];
		//City[] aux = new City[n];
		for(i=0;i<n;i++){
			city[i] = new City(i,in.nextInt(),n);
		}
		for(i=0;i<m;i++){
			j = in.nextInt();
			k = in.nextInt();
			city[j-1].add(k-1);
			city[k-1].add(j-1);
		}
		//for(i=0;i<n;i++) city[i].copy();
		//aux = city;
		Arrays.sort(city);
		for(i=0;i<n;i++){
			city[i].recovery(city, n);
		}
		
		//for(i=0;i<n;i++) System.out.println(city[i].zip +"-->" + city[i].n);
		for(i=0;i<n;i++){
			if(travel(city,i,n)) break;
		}
		StringBuilder ptr = new StringBuilder();
		int[] a = new int[8];
		a=trip;
		for(i=0;i<n;i++){
			ptr.append(city[trip[i]].zip);
		}
		System.out.println(ptr.toString());
		out.print(ptr.toString());
	}
	
	public static boolean travel(City[] a,int i,int n){
		int j;
		boolean v=false;
		trip[cont] = i;
		if(cont+1==n-1) {
			cont++;
			for(j=0;j<n;j++){
				if(a[j].checked == false) trip[cont] = j;
			}
			return true;
		}
	
		for(j=0;j<n;j++){
			if(a[i].path[j] && a[j].checked == false) {
				a[j].checked = true;
				cont++;
				v = travel(a,j,n);
				if(v==true) break;
				a[j].checked = false;
				cont--;
			}
		}
		return v;
	}
	
	public static class City implements Comparable<City>{
		public int n,m;
		public int zip;
		public boolean[] path;
		public boolean[] pathBack = new boolean[8];
		public boolean[] pathaux;
		public boolean checked;
		
		City(int n,int zip,int m){
			this.zip = zip;
			this.n = n;
			this.m = m;
			path = new boolean[m];
			pathaux = new boolean[m];
			checked = false;
		}
		
		public void add(int n){
			path[n] = true;
			pathaux[n] = true;
		}
		
		public void remove(int n){
			pathaux[n] = false;
			pathBack[n] = true;
		}
		public void reset(){
			for(int i=0;i<m;i++) path[i] =false;
		}
		
		public void recovery(City[] a,int x){
			this.reset();
			for(int i=0;i<m;i++){
				if(pathaux[i]){
					for(int j=0;j<x;j++){
						if(a[j].n == i){
							path[j] = true;
						}
					}
				}
			}
			
			
		}
		public int compareTo(City a){
			if(this.zip < a.zip) return -1;
			if(this.zip > a.zip) return 1;
			return 0;
		}
	
	}
}

