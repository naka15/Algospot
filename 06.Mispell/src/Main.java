import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		int nth[]=new int[cases];
		for(int i = 0; i<cases; i++){
			nth[i]=Integer.parseInt(sc.next());
			input.add(sc.next());
		}
		
		for(int i = 0; i <cases; i++){
			String result=input.get(i).substring(0,nth[i]-1);
			result=result+input.get(i).substring(nth[i]);
			System.out.println((i+1) +" " +result);
		}
		
	}

}
