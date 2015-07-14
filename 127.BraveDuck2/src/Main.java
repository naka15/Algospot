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
	static int edge[][];
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
			vertexList.add(start);
			for (int j = 0; j < vertexnum; j++) {
				st = new StringTokenizer(br.readLine());
				vertexList.add(new vertex(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			vertexList.add(end);
			//이동 가능 경로 계산
			int size=vertexList.size();
			edge= new int[size][size];
			for(int j=0; j<size; j++){
				for(int k=j; k<size; k++){
					double dis=Math.sqrt(Math.pow((vertexList.get(j).x-vertexList.get(k).x),2)+Math.pow((vertexList.get(j).y-vertexList.get(k).y),2));
					if(j==k){
						edge[j][k]=0;
					}else if(dis<=jump){
						edge[j][k]=1;
					}else{
						edge[j][k]=0;
					}
					
				}
			}
			for(int j=1; j<vertexnum; j++){
				for(int k=0; k<j; k++){
					edge[j][k]=edge[k][j];
				}
			}
			
			
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
	
	public static void findpath(int nowloc){
		vertex now = vertexList.get(nowloc);
		if(nowloc==vertexList.size()-1){
			haspath=true;
			return;
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
