import java.util.Scanner;
//DrawRect
//내가 생각한 핵심 : 주어진 세 점 중 중심점?을 찾아야 한다.
//벡터의 내적이 0이 되는 벡터 2개를 구하고 중심점을 찾는다.
//중심점에서 구한 벡터 2개의 합으로 남은 한 점을 구한다.

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] input = new int[num * 6];
		int[] result = new int[num*2];
		int[] vec = new int[6];
		for (int i = 0; i < num * 6; i++) {
			input[i] = sc.nextInt();
		}
		for (int i = 0; i < num; i++) {
			// 1번째 벡터
			vec[0] = input[0 + i * 6] - input[2 + i * 6];
			vec[1] = input[1 + i * 6] - input[3 + i * 6];
			// 2번째 벡터
			vec[2] = input[2 + i * 6] - input[4 + i * 6];
			vec[3] = input[3 + i * 6] - input[5 + i * 6];
			// 3번째 벡터
			vec[4] = input[4 + i * 6] - input[0 + i * 6];
			vec[5] = input[5 + i * 6] - input[1 + i * 6];
			int centx;
			int centy;

			if (vec[0] * vec[2] + vec[1] * vec[3] == 0) {
				centx = input[2 + i * 6];
				centy = input[3 + i * 6];
				result[0+i*2]=input[0+i*6]+input[4+i*6]-centx;
				result[1+i*2]=input[1+i*6]+input[5+i*6]-centy;
				
			} else if (vec[2] * vec[4] + vec[3] * vec[5] == 0) {
				centx = input[4 + i * 6];
				centy = input[5 + i * 6];
				result[0+i*2]=input[0+i*6]+input[2+i*6]-centx;
				result[1+i*2]=input[1+i*6]+input[3+i*6]-centy;
			} else {
				centx = input[0 + i * 6];
				centy = input[1 + i * 6];
				result[0+i*2]=input[2+i*6]+input[4+i*6]-centx;
				result[1+i*2]=input[3+i*6]+input[5+i*6]-centy;
			}

		}

		//결과 출력
		for(int i= 0 ; i<num; i++){
			System.out.println(result[0+i*2]+" "+result[1+i*2]);
		}
		
	}
}
