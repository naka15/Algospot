import java.util.Scanner;

//AlgoSpot coins 튜토리얼 DP 문제
public class Main {
	private static long[] result; // 결과, 화전할 수 있는 가지 수
	private int coinCount; // 코인종류 수
	private int tMoney; // 환전할 금액
	private static int[] coins; // 코인별 금액
	private static long[][] DP; // DP는 코인으로 환금 가능한 가지수를 저장할 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		result = new long[cases];
		for (int i = 0; i < cases; i++) {
			Main m = new Main();
			m.tMoney = sc.nextInt();
			m.coinCount = sc.nextInt();
			coins = new int[m.coinCount];
			for (int j = 0; j < m.coinCount; j++) { // 코인 금액 입력
				coins[j] = sc.nextInt();
			}

			DP = new long[m.coinCount][Math.max(m.tMoney + 1,
					coins[m.coinCount - 1])]; // DP값을 저장할 배열 초기화

			for (int j = 0; j < m.coinCount; j++) {
				DP[j][0] = 1L;
			}//초기값 설정 

			for (int x = coins[0]; x <= m.tMoney; x += coins[0]) {
				for (int j = 0; j < m.coinCount; j++) {
					for (int z = j; z < m.coinCount; z++)
						DP[j][x] += DP[z][Math.abs(x - coins[z])];
				}// DP(xi,y) = DP(x,y-xi) + DP( x, y-(xi+1)) + DP(x,
					// y-(xi+2))......+DP(x,y-(xi+n)
			} // DP(xi,y) = xi 코인과 같거나 보다 큰 코인으로 y의 값을 만들 수 있는 가지 수
			if (DP[0][m.tMoney] > 1000000007) {
				result[i] = DP[0][m.tMoney] % 1000000007;
			} else {
				result[i] = DP[0][m.tMoney];
			}
		}// cases for 문 끝

		for (int i = 0; i < cases; i++)
			System.out.println(result[i]); //결과 출력
	}// main 종료
}
