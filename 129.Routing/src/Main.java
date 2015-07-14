import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//2015/6/10 Algospot.com 튜토리얼 그래프 routing 시간제한 2000ms 메모리제한 65536kb
//https://algospot.com/judge/problem/read/ROUTING
//다익스트라 알고리즘, 경로를 알아야하는 것은 아니므로 parent는 필요없다
//2015/6/11 계속 시간초과, ArrayList<path> cango[] ->이걸 바꿔야 할것 같다.
// ArrayList object가 컴퓨터(vertex) 수 만큼 생기는 게 문제인듯
//2차원 배열로 바꿧더니 runtime error... 메모리 리밋 초과
//컴퓨터 개수가 최대 10000개니 cango[10000][10000]선언하면 10000*10000*64/8/1000 = 80000kb 메모리 초과
//새로 시작해야겠다 edge 클래스를 만들어서 해봐야지
public class Main {
	static double cango[][];
	static double distance[];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException,
			IOException, AWTException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		double result[] = new double[cases];
		double start=System.currentTimeMillis();
		for (int k = 0; k < cases; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int comNum = Integer.parseInt(st.nextToken()); // 컴퓨터(vertex) 수
			int pathNum = Integer.parseInt(st.nextToken()); // 회로 수
			visited = new boolean[comNum]; // true면 방문한 컴퓨터
			cango = new double[comNum][comNum]; // 갈수 있는 vertex
			distance = new double[comNum];
			distance[0] = 1;
			int a;
			int b;
			double c;
			
			for (int i = 0; i < pathNum; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Double.parseDouble(st.nextToken());
				cango[a][b] = c;
				cango[b][a] = c;
			}
			start = System.currentTimeMillis();
			// dijkstra 알고리즘 응용
			int to;
			double dis;
			int n = 0;
			int nowLoc = 0;

			while (n < comNum) {
				nowLoc = 0;
				for (nowLoc = 0; nowLoc < comNum - 1; nowLoc++) {
					if (!visited[nowLoc] && distance[nowLoc] != 0) {
						for (int j = 0; j < comNum; j++) {
							if (cango[nowLoc][j] != 0) {
								to = j;
								if (!visited[to]) {
									dis = distance[nowLoc] * cango[nowLoc][j];
									if (distance[to] == 0 || dis < distance[to]) {
										distance[to] = dis;
									}
								}
							}
						}
						n++;
						visited[nowLoc] = true;
					}
				}
				n++;
			}

			result[k] = distance[comNum - 1];
		}// while문 끝
		String a = "";
		for (int i = 0; i < cases; i++) {
			a = String.format("%.10f", result[i]);
			System.out.println(a);
		}
		double end=System.currentTimeMillis();
		System.out.println(end-start);
	}
}

class path {
	int to;
	double dis;

	public path(int to, double dis) {
		this.to = to;
		this.dis = dis;
	}
}
