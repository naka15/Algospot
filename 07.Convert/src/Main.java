import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		float num[] = new float[cases];
		String str[] = new String[cases];

		// 값 입력
		for (int i = 0; i < cases; i++) {
			num[i] = Float.parseFloat(sc.next());
			str[i] = sc.next();
		}
		for (int i = 0; i < cases; i++) {
			switch (str[i]) {
			case "kg":
				num[i] = Math.round(num[i] * 2.2046F * 10000F) / 10000F;
				str[i] = "lb";
				break;
			case "lb":
				num[i] = Math.round(num[i] * 0.4536F * 10000F) / 10000F;
				str[i] = "kg";
				break;
			case "l":
				num[i] = Math.round(num[i] * 0.2642F * 10000F) / 10000F;
				str[i] = "g";
				break;
			case "g":
				num[i] = Math.round(num[i] * 3.7854F * 10000F) / 10000F;
				str[i] = "l";
				break;
			}
			String t = String.format("%.4f", num[i]);
			System.out.println((i + 1) + " " + t + " " + str[i]);
		}
	}
}
