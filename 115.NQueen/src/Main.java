import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] col;
	public static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];

		for (int i = 0; i < cases; i++) {
			num = 0;
			n = sc.nextInt();
			col = new int[n]; // 각 행별로 여왕말이 놓인 위치
			queen(0);
			result[i] = num;
		}// cases만큼 반복 for문 끝

		for (int i= 0; i<cases; i++) {
			System.out.println(result[i]);
		}

	}// main 끝

	public static void queen(int i) {
		int j;
		for (j = 1; j <= n; j++) {
			col[i] = j;
			if (promissing(i)) {
				if (i == n - 1) {
					num++;
					return;
				} else {
					queen(i + 1);
				}
			}
		}
	}

	public static Boolean promissing(int i) {
		int k;
		for (k = 0; k < i; k++) {
			if (col[i] == col[k] || Math.abs(col[i] - col[k]) == i - k) {
				return false;
			}
		}
		return true;
	}
}
