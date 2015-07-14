import java.io.IOException;
//C++로는 1000ms로 해결되는데 java로는 왜 안되는지 알수없음.... 아무리 자바가 무거워도 1000ms 안에는 성공할것 같은데
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		System.out.println(value*(value+1)*(value+2)/2);
	}
}
