import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		long input;
		Long[] result = new Long[cases];
		for(int i =0; i<cases; i++){
			input=sc.nextLong();
			String s=Long.toHexString(input);
			while(s.length()<8){
				s="0"+s;
			}
			String reverse = "";
			for(int j = 7; j>0; j--){
			reverse=reverse+s.charAt(j-1)+s.charAt(j);
			j--;
			}
			result[i]=Long.parseLong(reverse,16);
		}
		for(int i=0; i<cases; i++){
			System.out.println(result[i]);
		}
	}

}
