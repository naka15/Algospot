import java.util.Scanner;

public class Main {
	private static int[][] diamond;
	private static int[][] dp; // dp[x][y] = x,y의 위치에서 경로의 합이 최대인 값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int result[] = new int[cases];
		for (int i = 0; i < cases; i++) {
			int maxLength = sc.nextInt();
			int inputCount = (maxLength) * (maxLength - 1) + maxLength;
			// 다이아몬드에 속한 숫자들의 개수
			diamond = new int[maxLength * 2 - 1][maxLength];

			int temp[] = new int[inputCount];
			for (int x = 0; x < inputCount; x++) {
				temp[x] = sc.nextInt();
			}
			int t = 0;
			for (int x = 0; x < maxLength; x++)
				// 다이아몬드 상위부분 경로 값 받기
				for (int j = 0; j <= x; j++) {
					diamond[x][j] = temp[t];
					t++;
				}

			for (int x = maxLength; x < maxLength * 2 - 1; x++) {
				for (int y = 0; y < maxLength * 2 - x - 1; y++) {
					diamond[x][y] = temp[t];
					t++;
				}
			}

			dp = new int[maxLength * 2 - 1][maxLength];
			/*for (int x = 0; x < maxLength * 2 - 1; x++)
				for (int y = 0; y < maxLength; y++)
					dp[x][y] = 0;*/

			dp[0][0] = diamond[0][0]; // 초기값 설정

			for (int x = 1; x < maxLength; x++) { // 다이아 윗분
				for (int y = 0; y < x + 1; y++) {
					if (y == 0) {
						dp[x][y] = dp[x - 1][y] + diamond[x][y];
					} else if (y == x) {
						dp[x][y] = dp[x - 1][y - 1] + diamond[x][y];
					} else {
						dp[x][y] = Math.max(dp[x - 1][y - 1]
								+ diamond[x][y], dp[x - 1][y]
								+ diamond[x][y]);
					}
				}
			}
			for (int x = maxLength; x < maxLength * 2 - 1; x++) {
				for (int y = 0; y < maxLength * 2 - x - 1; y++) {
					dp[x][y] = Math.max(dp[x - 1][y], dp[x - 1][y + 1])
							+ diamond[x][y];
				}

			}

			result[i] = dp[maxLength * 2 - 2][0];
			/*for (int x = 0; x < maxLength * 2 - 1; x++) {
				for (int y = 0; y < maxLength; y++) {
					System.out.print(dp[x][y] + "\t");
				}
				System.out.println();
			}*/

		}// case for문 끝
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);
	}// main 끝
}
