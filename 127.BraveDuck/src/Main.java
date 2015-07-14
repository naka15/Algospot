import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int jump;
	static vertex start;
	static vertex end;
	static ArrayList<vertex> vertexList;
	static boolean haspath;
	static ArrayList<vertex> remainList;
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		String result[] = new String[cases];

		// cases 횟수만큼 반복
		for (int i = 0; i < cases; i++) {
			haspath = false;
			// 점프 거리 입력
			jump = Integer.parseInt(br.readLine());

			// 시작점 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new vertex(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));

			// 끝점 입력
			st = new StringTokenizer(br.readLine());
			end = new vertex(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));

			// 돌 개수
			int vertexnum = Integer.parseInt(br.readLine());

			// 돌 좌표 입력
			vertexList = new ArrayList<vertex>();
			remainList = new ArrayList<>();
			for (int j = 0; j < vertexnum; j++) {
				st = new StringTokenizer(br.readLine());
				vertex t =new vertex(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				vertexList.add(t);
				remainList.add(t);
				
			}
			vertexList.add(end);
			remainList.add(end);
			findPath(start);
			if (haspath == true) {
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
		}// for cases 끝
		for (int i = 0; i < cases; i++) {
			System.out.println(result[i]);
		}
		
	}// main 끝

	// nowloc 현재위치
	// remainList 지나지 않은 돌들
	static void findPath(vertex nowLoc) {
		ArrayList<vertex> canGo = new ArrayList<vertex>();
		ArrayList<Integer> location = new ArrayList<>();
		int x = 0;
		int y = 0;
		for (int i = 0; i < remainList.size(); i++) {
			x = remainList.get(i).x;
			y = remainList.get(i).y;
			double temp = Math.sqrt(Math.pow(nowLoc.x - x, 2)
					+ Math.pow(nowLoc.y - y, 2));
			if (temp <= jump) {
				if (x == end.x && y == end.y) {
					haspath = true;
					return;
				}
				canGo.add(remainList.get(i));
				//location.add(i); // canGo에 입력한 vertex의 remainList에서의 위치를 저장
				remainList.remove(i);
			}
		}
		if (canGo.size() == 0) {
			return ;
		}
		/*System.out.println("canGo");
		for(int z=0; z<canGo.size(); z++){
			System.out.print(canGo.get(z).x+","+canGo.get(z).y+"  ");
		}System.out.println();*/
		
		for (int i = 0; i < canGo.size(); i++) {
			if (haspath == true) {
				return;
			}
			nowLoc = canGo.get(i); // 다음 위치
		/*	System.out.println("nowLoc : "+nowLoc.x+","+nowLoc.y);*/
			//int t = location.get(i);
			/*if(remainList.size()>t)
				remainList.remove(t); // 왜 삭제 안될까? object로 인식해서 삭제 안됬었던 것 같다
*/			/*System.out.println("remainList");
			for(int z=0; z<remainList.size(); z++){
				System.out.print(remainList.get(z).x+","+remainList.get(z).y+"  ");
			}System.out.println();*/
			findPath(nowLoc);
		}

	}

}

class vertex {
	int x;
	int y;

	public vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
