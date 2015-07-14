import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//2015/6/16 Algospot.com Move 문제 https://algospot.com/judge/problem/read/MOVE
//제한시간 2000ms 메모리제한 65536kb
//ROUTING 문제에서 사용했던 다익스트라, 넓이우선탐색 복습
public class Main {
	private int cityNum; // vertex 수
	private int roadNum; // Edge 수
	private ArrayList<ArrayList<Edge>> EdgeList; // Edge 입력

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.in();
	}

	public void in() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for (int i = 0; i < cases; i++) {
			String temp[] = new String[3];
			temp = br.readLine().split(" ");
			cityNum = Integer.parseInt(temp[0]); // 도시 수
			roadNum = Integer.parseInt(temp[1]); // 도로 수

			// EdgeList 초기화
			EdgeList = new ArrayList<>(cityNum);
			for (int j = 0; j < cityNum; j++) {
				EdgeList.add(new ArrayList<Edge>());
			}

			// EdgeList에 경로 입력
			int a, b, c; // a,b 도로 (a에서 b로 가는 도로) , c= a <-> b의 거리
			for (int j = 0; j < roadNum; j++) {
				temp = br.readLine().split(" ");
				a = Integer.parseInt(temp[0]);
				b = Integer.parseInt(temp[1]);
				c = Integer.parseInt(temp[2]);
				EdgeList.get(a).add(new Edge(b, c));
				EdgeList.get(b).add(new Edge(a, c)); // 양방향이므로 반대방향도 입력
			}// /모든 입력 끝

			result[i]=calDistance();

		}
		for(int i=0; i<cases; i++)
			System.out.println(result[i]);
	}

	public int calDistance() {
		int distance[] = new int[cityNum]; // 다익스트라 알고리즘의 distance 배열
		boolean visited[] = new boolean[cityNum]; // 방문한 도시 ex)true면 방문한 도시
		Comparator<Edge> comp = new distcom();				//comparator 생성 priorityqueue 정렬 기준
		PriorityQueue<Edge> que = new PriorityQueue<>(comp);	//넓이우선탐색을 위해 필요한 큐, distance값이 가장 작은 도시부터 방문
		que.add(new Edge(0,0));		//첫 시작점은 0번 도시, 거리도 0
		int nowLoc,dist,to,dis;
		while(!que.isEmpty()){
			nowLoc=que.peek().to;
			dist=que.peek().dist;
			que.poll();
			visited[nowLoc]=true;
			//nowLoc위치에서 갈수 있는 모든 도시 검사
			for(int i=0; i<EdgeList.get(nowLoc).size(); i++){
				to=EdgeList.get(nowLoc).get(i).to;	//nowLoc에서 갈수 있는 도시 중 하나
				if(!visited[to]){					//방문하지 않은 도시면 distance 계산
					dis=dist+EdgeList.get(nowLoc).get(i).dist;	
					if(dis<distance[to]||distance[to]==0){		//새로운 distance값이 더 작으면 갱신,0=infinity이므로 0일경우도 갱신
						distance[to]=dis;
						que.add(new Edge(to,dis));
					}
				}
			}
			
		}
		
		return distance[cityNum-1];
	}
}

class distcom implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		if (e1.dist < e2.dist) {
			return -1;
		}
		if (e1.dist > e2.dist) {
			return 1;
		}
		return 0;
	}

}

class Edge {
	int to;
	int dist;

	public Edge(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}