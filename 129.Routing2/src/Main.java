import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//2015/6/10 Algospot.com 튜토리얼 그래프 routing
//https://algospot.com/judge/problem/read/ROUTING
//다익스트라 알고리즘, 경로를 알아야하는 것은 아니므로 parent는 필요없다

public class Main {
	static ArrayList<path> cango[];
	static double distance[];
	static boolean visited[];
	static int comNum;
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		/*File f = new File("D:\\test.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		double result[] = new double[cases];
		for(int k=0; k<cases; k++) {
			String temp[] = new String[2];
			temp = br.readLine().split(" ");
			comNum = Integer.parseInt(temp[0]); // 컴퓨터(vertex) 수
			int pathNum = Integer.parseInt(temp[1]); // 회로 수
			visited = new boolean[comNum]; // true면 방문한 컴퓨터
			cango = new ArrayList[comNum]; // 갈수 있는 vertex
			distance = new double[comNum];
			distance[0]=1;
			for(int x=0; x<comNum; x++)
				cango[x]=new ArrayList<path>();
			int a;
			int b;
			double c;
			temp = new String[3];
			for (int i = 0; i < pathNum; i++) {
				temp = br.readLine().split(" ");
				a = Integer.parseInt(temp[0]);
				b = Integer.parseInt(temp[1]);
				c = Double.parseDouble(temp[2]);
				cango[a].add(new path(b, c));
				cango[b].add(new path(a, c));
			}
			
			// dijkstra 알고리즘 초기화
			getNoise(0);
			result[k]=distance[comNum-1];
		}//while문 끝
		String a="";
		for(int i=0; i<cases; i++){
			a = String.format("%.10f", result[i]);
			System.out.println(a);
	}
	}

	public static void getNoise(int nowLoc) {
		double dis;
		int to;
		int x = 0;
		while (x < comNum) {
			visited[nowLoc] = true;
			for (int j = 0; j < cango[nowLoc].size(); j++) {
				to = cango[nowLoc].get(j).to;
				if (!visited[to]) {
					dis = distance[nowLoc] * cango[nowLoc].get(j).dis;
					if (dis < distance[to] || distance[to] == 0) {
						distance[to] = dis;
					}
				}
			}
			double min = 999999999999999d;
			int loc = 0;
			double dist;
			// distant 에서 가장 작은 수 이면서 방문하지 않은 정점을 찾아라
			for (int i = 0; i < distance.length; i++) {
				dist=distance[i];
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

class path {
	int to;
	double dis;

	public path(int to, double dis) {
		this.to = to;
		this.dis = dis;
	}
}
