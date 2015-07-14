import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for(int i= 0; i<cases; i++){	
			input.add(sc.next());
		}
		for(int i = 0; i<cases; i++){
			int length = input.get(i).length();	//문자열 길이
			String result = "";
			for(int j=0; j<length; j++){
				
				result=result+input.get(i).charAt(j);
				j++;
			}
			for(int j=1; j<length; j++){
				result=result+input.get(i).charAt(j);
				j++;
			}
			System.out.println(result);
		}
		
			
	}
}
