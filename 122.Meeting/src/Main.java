import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];

		for (int i = 0; i < cases; i++) {
			int size = Integer.parseInt(br.readLine());
			int male[] = new int[size];
			int female[] = new int[size];
			int sum = 0;
			StringTokenizer mst = new StringTokenizer(br.readLine());
			StringTokenizer fst = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				male[j] = Integer.parseInt(mst.nextToken());
				female[j] = Integer.parseInt(fst.nextToken());
			}
			Arrays.sort(male);
			Arrays.sort(female);

			for (int j = 0; j < size; j++) {
				sum += Math.abs(male[j] - female[j]);
			}
			result[i] = sum;
		}
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);
	}

}
