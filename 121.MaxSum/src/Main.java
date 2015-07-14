import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//algospot MaxSum 문제 2015/5/27
public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for (int i = 0; i < cases; i++) {
			int size = Integer.parseInt(br.readLine());
			int max = 0;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				if (sum < 0)
					sum = 0;
				if (sum > max)
					max = sum;
			}
			result[i] = max;
		}
		for (int i = 0; i < cases; i++) {
			System.out.println(result[i]);
		}

	}

}
