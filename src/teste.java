import java.util.Scanner;


public class teste {

	public static void main(String[] args) {

		String a = "c54a3";
		String x = "a90b33";
		int b,d;
		Scanner[] n = new Scanner[2];
		n[0] = new Scanner(a);
		n[1] = new Scanner(x);
		b = n[0].useDelimiter("[^\\d]+").nextInt();
		d = n[1].useDelimiter("[^\\d]+").nextInt();
		//String numberOnly= a.replaceAll("[^0-9]", "");
		//String k = String.valueOf(a.charAt(1));
		//b = Integer.parseInt(k);
		//System.out.println(numberOnly);
		System.out.println(b);
		System.out.println(d);
		b = n[0].useDelimiter("[^\\d]+").nextInt();
		d = n[1].useDelimiter("[^\\d]+").nextInt();
		System.out.println(b);
		System.out.println(d);

	}

}
