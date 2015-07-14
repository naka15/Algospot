import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//2015/6/10 Algospot.com 튜토리얼 그래프 routing 시간제한 2000ms 메모리제한 65536kb
//https://algospot.com/judge/problem/read/ROUTING
//다익스트라 알고리즘, 경로를 알아야하는 것은 아니므로 parent는 필요없다
//2015/6/11 계속 시간초과, ArrayList<path> cango[] ->이걸 바꿔야 할것 같다.
//ArrayList object가 컴퓨터(vertex) 수 만큼 생기는 게 문제인듯
//2차원 배열로 바꿧더니 runtime error... 메모리 리밋 초과
//컴퓨터 개수가 최대 10000개니 cango[10000][10000]선언하면 10000*10000*64/8/1000 = 80000kb 메모리 초과
//새로 시작해야겠다 edge 클래스를 만들어서 해봐야지
//3번째인데 답은 제대로 나온다 시간초과
public class Main3 {
	static int comNum;
	static int lineNum;
	static boolean visited[];
	static ArrayList<Edge> cango[];
	static double distant[];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main3 s = new Main3();
		s.in();
	}

	public void in() throws NumberFormatException, IOException {
		double start = System.currentTimeMillis();
		File f = new File("D:\\test.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
		int cases = Integer.parseInt(br.readLine());

		int a;
		int b;
		double c;
		double result[] = new double[cases];
		
		
		String[] temp = new String[2];
		String[] edgeTemp = new String[3];
		for (int i = 0; i < cases; i++) {
			temp = br.readLine().split(" ");
			comNum = Integer.parseInt(temp[0]);
			lineNum = Integer.parseInt(temp[1]);
			// 초기화
			visited = new boolean[comNum];
			cango = new ArrayList[comNum];
			distant = new double[comNum];
			distant[0] = 1;

			for (int j = 0; j < comNum; j++) {
				cango[j] = new ArrayList<Edge>();
			}
			for (int j = 0; j < lineNum; j++) {
				edgeTemp = br.readLine().split(" ");
				a = Integer.parseInt(edgeTemp[0]);
				b = Integer.parseInt(edgeTemp[1]);
				c = Double.parseDouble(edgeTemp[2]);
				cango[a].add(new Edge(b, c));
				cango[b].add(new Edge(a, c));
			}
			
			MainLogic(0);
			result[i] = distant[comNum - 1];
		}
		String ts = "";
		for (int i = 0; i < cases; i++) {
			ts = String.format("%.10f", result[i]);
			System.out.println(ts);
		}
		double end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public void MainLogic(int nowLoc) {

		double dis;
		int to;
		int x = 0;
		while (x < comNum) {
			visited[nowLoc] = true;
			for (int j = 0; j < cango[nowLoc].size(); j++) {
				to = cango[nowLoc].get(j).to;
				if (!visited[to]) {
					dis = distant[nowLoc] * cango[nowLoc].get(j).dis;
					if (dis < distant[to] || distant[to] == 0) {
						distant[to] = dis;
					}
				}
			}
			double min = 999999999999999d;
			int loc = 0;
			double dist;
			// distant 에서 가장 작은 수 이면서 방문하지 않은 정점을 찾아라
			for (int i = 0; i < distant.length-1; i++) {
				dist=distant[i];
				if (min > dist && !visited[i] && dist != 0) {
					min = dist;
					loc = i;
				}
			}
			nowLoc = loc;
			x++;
		}
	}

	
}

class Edge {
	int to;
	double dis;

	public Edge(int to, double dis) {
		this.to = to;
		this.dis = dis;
	}
}