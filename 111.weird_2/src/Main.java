import java.util.Scanner;

public class Main {
	public static String result[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		result = new String[cases];
		for (int i = 0; i < cases; i++) {
			int weird = sc.nextInt();
			int[] divisor = new int[200]; // 약수 집합
			// 약수 집합 및 약수의 합구하기
			int t = 2;
			int j = 1;
			int sum = 0; // 약수의 합
			divisor[0] = 1; // 1은 모든 수의 약수
			boolean a = true;
			boolean b = true;

			while (t <= weird / 2) {
				if (weird % t == 0) {
					divisor[j] = t;
					sum += t;
					j++;
				}
				t++;
			}// while문 끝
			int length = j;
			// 약수의 합이 weird이하면 weird가 아니다
			if (sum <= weird) {
				a = false;
				result[i] = "not weird";
			}
			
			// 첫번째 조건이 으면 두번째 조건을 확인
			int range= sum-weird;
			t=0;
			j=0;
			sum=0;
			int toPick[]= new int[200];
			if (a == true) {
				while(t<length+1){			//약수 중 합계에서 뺄수 있는것만 고름
					if(divisor[t]<=range){
						toPick[j]=divisor[t];
						sum+=toPick[j];
						j++;
					}else{
						return;
					}
					t++;
				}
			}
			int toPickLength=j;
			if(sum<range){
				b=true;
				result[i]="weird";
			}else if(sum==range){
				b=false;
				result[i]="not weird";
			}
			
			
			
		}// for case문 끝

	}//main 끝

	public void Pick(int toPick, int Picked){
		
	}

}
