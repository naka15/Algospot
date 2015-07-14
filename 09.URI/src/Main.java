import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String result[] = new String[cases];
		for (int i = 0; i < cases; i++) {
			String uri = sc.next();
			result[i] = "";
			for (int j = 0; j < uri.length(); j++) {
				if (uri.charAt(j) == '%' && uri.length() - j >= 3) {
					String str = "";
					str = str + uri.charAt(j + 1) + uri.charAt(j + 2);
					switch (str) {
					case "20":
						result[i] = result[i] + " ";
						j=j+2;
						break;
					case "21":
						result[i] = result[i] + "!";
						j=j+2;
						break;
					case "24":
						result[i] = result[i] + "$";
						j=j+2;
						break;
					case "25":
						result[i] = result[i] + "%";
						j=j+2;
						break;
					case "28":
						result[i] = result[i] + "(";
						j=j+2;
						break;
					case "29":
						result[i] = result[i] + ")";
						j=j+2;
						break;
					case "2a":
						result[i] = result[i] + "*";
						j=j+2;
						break;
					default:
						result[i] = result[i] + "%";
						break;
					}
					
				}
				else{
					result[i]=result[i]+uri.charAt(j);
				}//if문 끝
			}//for문 uri문자열 변환 for문 끝

		}//for문 cases 값만큼 반복 for문
		
		for(int i=0; i<cases; i++){
			System.out.println(result[i]);
		}
	}//main 끝
}