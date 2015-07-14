import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int result[] = new int[cases];
		
		for(int i=0; i<cases; i++){
			int size = sc.nextInt();
			int input[] = new int[size];
			int r=0;
			for(int j=0; j<size; j++){
				if(j+1==sc.nextInt()){
					r++;
				}
			}
			result[i]=r;
		}
		for(int i=0; i<cases; i++)
		System.out.println(result[i]);
		
	}

}
