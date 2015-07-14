import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer> subset;
	public static boolean a;
	static int num;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		String[] result = new String[cases];
		subset = new ArrayList<Integer>();
		
		for (int i = 0; i < cases; i++) {
			a = false;
			boolean b = false;
			num = Integer.parseInt(br.readLine());
			sum = 0;
			subset.clear();
			if(num%2==0){
				
				// 약수 구하
				int z = 2;
				while (num % z == 0) {
					subset.add(num / z);
					sum += num / z;
					z++;
				}
				for (int j = 1; j <= num / z; j++) {
					if (num % j == 0) {
						subset.add(j);
						sum += j;
					}
				}
				//조건 만족
				if(sum>num){ b=true; } 
				 
				ArrayList<Integer> picked = new ArrayList<Integer>();
				if (b == true) {
					for (int x = 3; x <= subset.size(); x++) {
						if (a != true) {
							pick(subset.size(), picked, x);
						}
					}
				}
			}
			if (a == false && b == true) {
				result[i]="weird";
			} else {
				result[i]="not weird";
			}
		}// for문 끝
		for(int i = 0; i<cases; i++){
		System.out.println(result[i]);
		}
		/*long end = System.currentTimeMillis();
		System.out.println(end-start);*/
	}// main 끝

	public static void pick(int n, ArrayList<Integer> picked, int toPick) {
		// 기저사례 : 더 고를 원소가 없을 때 고른 원소들을 출력한다.
		if (a == true) {
			return;
		}
		if (toPick == 0) {
			if (picked.size() > 3) {
				int tsum = 0;
				for (int i = 0; i < picked.size(); i++) {
					tsum += subset.get(picked.get(i));
				}
				if (num == tsum) {
					a = true;
					return;
				}
			}
			return;
		}
		int smallest = picked.isEmpty() ? subset.size()-1 : picked.get(picked.size() - 1) - 1;
		
		for (int next = smallest; next >= 0; next--) {
			picked.add(next);
			pick(n, new ArrayList<Integer>(picked), toPick - 1);
			picked.remove(picked.size() - 1);
		}// for문 종
	}
	
	
}