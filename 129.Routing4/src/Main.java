//2015/6/16 PriorityQueue사용해서 넓이 우선 탐색, 다익스트라 알고리즘 활용해서 해결
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	int comNum;
	int EdgeNum;
	double distance[];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.in();
	}

	public void in() throws NumberFormatException, IOException {
		int cases;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cases = Integer.parseInt(br.readLine());
		double result[] = new double[cases];
		for (int i = 0; i < cases; i++) {
			String temp[] = new String[3];
			temp = br.readLine().split(" ");
			comNum = Integer.parseInt(temp[0]);
			EdgeNum = Integer.parseInt(temp[1]);
			distance = new double[comNum];
			ArrayList<ArrayList<Edge>> edgeList;
			edgeList = new ArrayList<ArrayList<Edge>>(comNum);
			
			for(int j=0; j<comNum; j++){
				edgeList.add(new ArrayList<Edge>());
			}
			
			int a, b;
			double c;
			for (int j = 0; j < EdgeNum; j++) {
				temp = br.readLine().split(" ");
				a = Integer.parseInt(temp[0]);
				b = Integer.parseInt(temp[1]);
				c = Double.parseDouble(temp[2]);

				edgeList.get(a).add(new Edge(b, c));
				edgeList.get(b).add(new Edge(a, c));
			}

			calNoise(edgeList);
			result[i] = distance[comNum-1];
			
		}
		String ts = "";
		for (int i = 0; i < cases; i++) {
			ts = String.format("%.10f", result[i]);
			System.out.println(ts);
		}
		
	}

	private void calNoise(ArrayList<ArrayList<Edge>> edgeList) {

		Comparator<Edge> comp = new EdgeCom();
		PriorityQueue<Edge> queue = new PriorityQueue<>(comp);
		distance[0] = 1.0;

		queue.add(new Edge(0, 1.0));
		int x = 0;
		while (!queue.isEmpty()) {
			double dist = queue.peek().dist;
			int nowLoc = queue.peek().to;
			queue.poll();
			//뒤로 돌아가지 않는다, distance 계산이 않된곳은 방문하지 않는다
			if(distance[nowLoc]<dist||distance[nowLoc]==0) continue;
			for (int i = 0; i < edgeList.get(nowLoc).size(); i++) {
				int to = edgeList.get(nowLoc).get(i).to;
				double dis = dist * edgeList.get(nowLoc).get(i).dist;
				if (dis < distance[to]||distance[to]==0) {
					distance[to] = dis;
					queue.add(new Edge(to, dis));
				}
			}

		}
	}

}

class EdgeCom implements Comparator<Edge> {

	@Override
	public int compare(Edge e, Edge e2) {
		if (e.dist < e2.dist)
			return -1;
		if (e.dist > e2.dist)
			return 1;
		return 0;
	}

}

class Edge {
	int to;
	double dist;

	public Edge(int to, double dist) {
		this.to = to;
		this.dist = dist;
	}
}