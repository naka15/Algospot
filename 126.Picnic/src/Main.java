import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int stnum;
	static int pairnum;
	static int count;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];

		for (int i = 0; i < cases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			stnum = Integer.parseInt(st.nextToken());
			pairnum = Integer.parseInt(st.nextToken());
			ArrayList<pair> pairArr = new ArrayList<pair>();
			count = 0;
			// 친구 쌍 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < pairnum; j++) {
				pairArr.add(new pair(Integer.parseInt(st.nextToken()), Integer
						.parseInt(st.nextToken())));
			}
			
			pick(pairArr, stnum / 2 );
			result[i] = count;

		}// for cases 끝
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);
	}// main 끝

	// topick : 픽할 수 있는 남은 쌍
	// pickcount : 앞으로 픽해야 할 횟수
	public static void pick(ArrayList<pair> topick, int pickCount) {
		int a = 0;
		int b = 0;
		
		if(topick.size()==0&&pickCount==0){
			count++;
			return;
		}
		if(topick.size()==0&&pickCount>0){
			return;
		}
		ArrayList<pair> nextPick;
		 // 다음에 픽 가능한 것들
		for (int i = 0; i < topick.size(); i++) {
			pair pickpair = topick.get(i); // 하나를 픽함
			nextPick = new ArrayList<pair>();
			
			// 다음에 픽 가능한 것들을 nextPick에 넣음
			for (int j = i + 1; j < topick.size(); j++) {
				a = topick.get(j).a;
				b = topick.get(j).b;
				if (a == pickpair.a || b == pickpair.b || a == pickpair.b
						|| b == pickpair.a) {

				} else {
					nextPick.add(topick.get(j));
				}
			}
			pick(nextPick, pickCount - 1);
		}
		
		/*System.out.println("count : " + count + " nextPick size : "
				+ nextPick.size());
		for (int i = 0; i < nextPick.size(); i++)
			System.out
					.print(nextPick.get(i).a + "," + nextPick.get(i).b + "  ");
		System.out.println();*/
		return;
	}

}

class pair {
	int a;
	int b;

	public pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
