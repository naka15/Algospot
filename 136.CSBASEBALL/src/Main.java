import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for (int i = 0; i < cases; i++) {
			int a = 0, b = 0;
			String t[] = new String[2];
			t = br.readLine().split(" ");
			a = Integer.parseInt(t[0]);
			b = Integer.parseInt(t[1]);

			a = b - a;
			if (a < 0) {
				result[i] = 0;
				continue;
			}
			result[i]= a+4;
		}
		for(int i=0; i<cases; i++)
			System.out.println(result[i]);
	}

}
