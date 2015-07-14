//2015/06/23 Algospot.com 문제 Shisensho https://algospot.com/judge/problem/read/SHISENSHO
//같은 타일끼리 모으기 위해 우선순위 큐 사용
//사천성은 두 타일로 사각형을 만들어 그사각형이 사방으로 뻗어나가는 십자가 모양의 범위만큼 경로가 될수 있다.
//두 타일의 경로가 위 아래로 나가는 경우, 좌우로 나가는 경우로 나누어 찾음
//위 아래로 나갈 경우 어디까지 나갈 수 있는지 범위를 찾고(hdown,hup), 그 범위 안에서 가로 길이 존재하면 1을 리턴한다.
//좌우로 나갈 경우도 마찬가지로 범위를 찾고(wleft,wright), 그 범위 안에서 세로 길이 존재하면 1을 리턴한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	private int h;
	private int w;
	private char s[][];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.in();
	}

	public void in() throws NumberFormatException, IOException {
		int cases;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for (int i = 0; i < cases; i++) {
			String t[] = new String[2];
			t = br.readLine().split(" ");
			h = Integer.parseInt(t[0]); // 높이
			w = Integer.parseInt(t[1]); // 넓이
			Comparator<tile> comp = new charcomp();
			PriorityQueue<tile> p = new PriorityQueue<>(comp); // 같은 타일끼리 모으기 위한
																// 우선순위 큐
																// ex)aaaabbbeee
																// 이런 식

			s = new char[h][w]; // 사천성 문제를 저장할 배열
			char st;
			for (int j = 0; j < h; j++) {
				s[j] = br.readLine().toCharArray();
				for (int k = 0; k < w; k++) {
					st = s[j][k];
					if (st != '.') {
						p.add(new tile(st, j, k)); // 같은 타일끼리 모으기 위해 우선순위 큐로 모음
					}
				}
			}

			/*
			 * System.out.println(); for(int j=0; j<h; j++){ for(int k=0; k<w;
			 * k++) System.out.print(s[j][k]+"  "); System.out.println(); }
			 * while(!p.isEmpty()){ System.out.println(p.peek().c); p.poll(); }
			 */
			result[i] = findLevel(s, p);
		}// cases 끝
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);
	}// in 끝

	public int findLevel(char s[][], PriorityQueue<tile> p) {
		ArrayList<tile> list = new ArrayList<>();
		int level = 0;
		while (p.size() > 1) {
			list.clear();
			tile t = p.peek();
			list.add(t);
			p.poll();
			while (!p.isEmpty() && t.c == p.peek().c) {
				t = p.peek();
				list.add(t);
				p.poll();
			}
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					level += Connected(list.get(i), list.get(j));
				}
			}
		}
		return level;
	}// findlevel 끝

	public int Connected(tile t1, tile t2) {
		// 가로로 붙어있는경우
		if (t1.x == t2.x && Math.abs(t1.y - t2.y) == 1) {
			return 1;
		}
		// 세로로 붙어있는 경우
		if (t1.y == t2.y && Math.abs(t1.x - t2.x) == 1)
			return 1;

		// t1,t2 가로 길 있는지 찾기
		int hdown, hup;
		// hdown 구하기, 아래방향
		int x = t1.x + 1;
		while (x < h && s[x][t1.y] == '.') {
			x++;
		}
		hdown = x - 1;
		x = t2.x + 1;
		while (x < h && s[x][t2.y] == '.') {
			x++;
		}
		hdown = Math.min(hdown, x - 1);
		// hup구하기
		x = t1.x - 1;
		while (x >= 0 && s[x][t1.y] == '.') {
			x--;
		}
		hup = x + 1;
		x = t2.x - 1;
		while (x >= 0 && s[x][t2.y] == '.') {
			x--;
		}
		hup = Math.max(hup, x + 1);

		int ymin, ymax;
		if (t1.y < t2.y) {
			ymin = t1.y;
			ymax = t2.y;
		} else {
			ymin = t2.y;
			ymax = t1.y;
		}
		// 한칸 위 한칸 옆에 있는 경우==대각선으로 한칸 떨어져 있는경우
		// ex)
		// x.
		// ax ymin,ymax때문에 따로 예외를 설정해야 함. ymin+1>ymax-1이 되므로 아래의 for문을 지나쳐버리기 때문
		if (ymax - ymin == 1 && (hdown - hup) >= 0)
			return 1;
		
		// 높이가 hup~hdown 인 범위에서 가로 길을 찾음 
		// hup > hdown인 경우는 위 아래로 나가는 경우의 길이 없다
		if (hup <= hdown)
			for (int i = hup; i <= hdown; i++) {
				for (int j = ymin + 1; j <= ymax - 1; j++) {
					if (s[i][j] != '.') {
						break;
					}
					if (j == ymax - 1)
						return 1;
				}
			}

		// t1,t2 세로 길 있는지 찾기
		int wleft, wright;
		// wright 구하기, 아래방향
		int y = t1.y + 1;
		while (y < w && s[t1.x][y] == '.') {
			y++;
		}
		wright = y - 1;
		y = t2.y + 1;
		while (y < w && s[t2.x][y] == '.') {
			y++;
		}
		wright = Math.min(wright, y - 1);
		// wleft구하기
		y = t1.y - 1;
		while (y >= 0 && s[t1.x][y] == '.') {
			y--;
		}
		wleft = y + 1;
		y = t2.y - 1;
		while (y >= 0 && s[t2.x][y] == '.') {
			y--;
		}
		wleft = Math.max(wleft, y + 1);

		int xmin, xmax;
		if (t1.x < t2.x) {
			xmin = t1.x;
			xmax = t2.x;
		} else {
			xmin = t2.x;
			xmax = t1.x;
		}

		// 한칸 위 한칸 옆에 있는 경우==대각선으로 한칸 떨어져 있는경우
		// ex)
		// xa
		// .x xmin,xmax때문에 따로 예외를 설정해야 함. xmin+1>xmax-1 이 되므로 아래의 for문을 거치지 않기 때문에 예외 설정해야함.
		if (xmax - xmin == 1 && (wright - wleft) >= 0)
			return 1;
		
		// 넓이가(가로로) wleft~wright 범위에서 세로 길이 있는지 찾는다
		//wleft>wright인 경우는 좌우로 나갈 경우의 길이 없다. 
		if (wleft <= wright)
			for (int i = wleft; i <= wright; i++) {
				for (int j = xmin + 1; j <= xmax - 1; j++) {
					if (s[j][i] != '.') {
						break;
					}
					if (j == xmax - 1) {
						return 1;
					}
				}
			}
		//위아래로, 좌우로 나가는 길 모두 없으므로 0을 리턴
		return 0;
	}
}

class charcomp implements Comparator<tile> {

	@Override
	public int compare(tile t1, tile t2) {
		if (t1.c < t2.c) {
			return -1;
		}
		if (t1.c > t2.c) {
			return 1;
		}
		return 0;
	}

}

class tile {
	char c;
	int x, y;

	public tile(char c, int x, int y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}
}