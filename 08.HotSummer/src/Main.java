import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String result[] = new String[cases];
		for (int i = 0; i < cases; i++) {
			int limit = sc.nextInt();
			int sum = 0;
			for (int j = 0; j < 9; j++) {
				sum += Integer.parseInt(sc.next());
			}
			if (sum <= limit) {
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
		}
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);

	}

}
