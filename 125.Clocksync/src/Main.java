import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int input[];
	static int buttonclock[][] = { { 0, 1, 2, -1, -1 }, { 3, 7, 9, 11, -1 },
			{ 4, 10, 14, 15, -1 }, { 0, 4, 5, 6, 7 }, { 6, 7, 8, 10, 12 },
			{ 0, 2, 14, 15, -1 }, { 3, 14, 15, -1, -1 }, { 4, 5, 7, 14, 15 },
			{ 1, 2, 3, 4, 5 }, { 3, 4, 5, 9, 13 } };

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		int r=0;
		for (int i = 0; i < cases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp;
			r=0;
			int remain [][]= { { 0, 3, 5, -1, -1 }, { 0, 8, -1, -1, -1 },
					{ 0, 5, 8, -1, -1 }, { 1, 6, 8, 9, -1 }, { 2, 3, 7, 8, 9 },
					{ 3, 7, 8, 9, -1 }, { 3, 4, -1, -1, -1 }, { 1, 3, 4, 7, -1 },
					{ 4, -1, -1, -1, -1 }, { 1, 9, -1, -1, -1 }, { 2, 4, -1, -1, -1 },
					{ 1, -1, -1, -1, -1 }, { 4, -1, -1, -1, -1 },
					{ 9, -1, -1, -1, -1 }, { 2, 5, 6, 7, -1 }, { 2, 5, 6, 7, -1 } };
			input= new int[16];
			// 처음 시계 상태 입력
			for (int j = 0; j < 16; j++) {
				temp = Integer.parseInt(st.nextToken());
				switch (temp) {
				case 12:
					input[j] = 0;
					break;
				case 3:
					input[j] = 3;
					break;
				case 6:
					input[j] = 2;
					break;
				case 9:
					input[j] = 1;
					break;
				}
			}
			
			
			// 한 개 남은 시계 찾기

			int x = 16;
			while (x > 0) {
				int count = 0;
				int button = 0;
				int location = 0;
				int clock = 0;
				ArrayList<element> array = new ArrayList<element>();
				
				for (int j = 0; j < 16; j++) {
					for (int k = 0; k < 5; k++) {
						if (remain[j][k] != -1) {
							count++;
							if (count > 1) {
								break;
							}
							button = remain[j][k];
							location = k;
						}

					}
					if (count == 1) {
						clock = j;
						array.add(new element(clock, location, button));
					}
					count = 0;
				}
				if (array.size() > 1) {
					int val = array.get(0).button;
					for (int j = 1; j < array.size(); j++) {
						if (val == array.get(j).button
						// 버튼 하나밖에 없는 것들끼리 비교해서 input의 값이 다르면 답이 없다 -1
								&& input[array.get(0).clock] != input[array
										.get(j).clock]) {

							result[i] = -1;
							break;
						}
					}
				}

				clock = array.get(0).clock;
				location = array.get(0).location;
				button = array.get(0).button;
				int j = 0;
				
				
			
				
				if (result[i] == -1) {
					break;
				} else {
					
					int spin = input[clock];
					r+= spin;// 시계를 돌리는 횟수
					while (j < 5 && buttonclock[button][j] != -1) { //
						input[buttonclock[button][j]] -= spin; // 누른 버튼의
						
						
						switch (input[buttonclock[button][j]]) {
						case -1:
							input[buttonclock[button][j]] = 3;
							break;
						case -2:
							input[buttonclock[button][j]] = 2;
							break;
						case -3:
							input[buttonclock[button][j]] = 1;
							break;
						}
						j++;
					}// while 끝
					
										
					int sum = 0;
					for (int k = 0; k < 16; k++) {
						sum += input[k];
						if (sum > 0)
							break;
					}
					if (sum == 0) {
						result[i] = r;
						break;
					}
					int l = 0;

					for (int k = 0; k < 16; k++) {
						l = 0;
						while (l < 5) { // 무한루프?
							if (remain[k][l] == button) {
								remain[k][l] = -1;
							}
							
							l++;
						}
					}
				}// if-else문 끝
				
				x--;
			}// while 끝
			if (result[i] == 0) {
				result[i] = -1;
			}
		}// for cases 끝
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);
	}// main 끝
}

class element {
	int clock;
	int location;
	int button;

	public element(int c, int l, int b) {
		this.clock = c;
		this.location = l;
		this.button = b;
	}
}
