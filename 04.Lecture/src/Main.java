import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String input[] = new String[num];
		ArrayList<String> arr = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			input[i] = sc.next();
		}
		for(int j = 0; j<num; j++){
		int l = input[j].length();
		for (int i = 0; i < l; i++) {
			
			arr.add(input[j].substring(i,i+2));
			i++;
		}
		Collections.sort(arr);
		for(int i=0; i<l/2; i++){
			System.out.print(arr.get(i));
		}
		System.out.println();
		arr.clear();
		}
	}

}
