//2015/6/26 Algospot.com RATIO https://www.algospot.com/judge/problem/read/RATIO
//DOUBLE,float의 비교, 연산은 정확하지 않다. 1.99999999999999의 더블 변수에 저장하고 출력하면 2가 출력된다
//11000*1.15 = 12649.999999999998 정확한 값이 나오지 않는다.
//더블값을 비교할 때는 compare를 쓰거나 
//BigDecimal로 풀었지만 같은 알고리즘으로 BigDecimal안 쓰고도 해결할 수 있는 방법이 있다.
//승률이 1프로 올라갈 때까지 승리 횟수를 증가 시키는 방법도 있다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.In();
	}

	public void In() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for (int i = 0; i < cases; i++) {

			String s[] = new String[2];
			s = br.readLine().split(" ");
			// double n = Double.parseDouble(s[0]); // 플레이 횟수
			// double w = Double.parseDouble(s[1]); // 승리 횟수
			BigDecimal n = new BigDecimal(s[0]);
			BigDecimal w = new BigDecimal(s[1]);
			result[i] = getWin(n, w);
		}
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);

	}

	public int getWin(BigDecimal n, BigDecimal w) {
		BigDecimal g = (w.divide(n,2,BigDecimal.ROUND_DOWN)).multiply(new BigDecimal("100")).add(
				new BigDecimal("1")); // 목표 승률
		long y = g.longValue();		
		if (y >= 100)
			return -1;
		BigDecimal t = new BigDecimal(y);
		w = w.multiply(new BigDecimal("100"));
		n = n.multiply(t);
		w = w.subtract(n);
		t = t.subtract(new BigDecimal("100"));
		BigDecimal o = w.divide(t, 2, BigDecimal.ROUND_UP);
		int x = o.intValue();				//소수점 버린 값
		double tempo = o.doubleValue();		//본래 값
		if (Double.compare(tempo, (double) x) != 0)		//연승횟수가 정수로 나오지않으면 +1, 예로 연승 횟수가 1.xx 이런식으로 나오면 2연승을 해야 한다.
			x++;
		return x;
	}
}
