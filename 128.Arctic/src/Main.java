//2015/6/8 Algospot.com 튜토리얼 그래프 Arctic

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<base> baseList;
	static double baseDist[][];
	static PriorityQueue<Double> distant;
	static double resultDis;
	static LinkedList<Integer> remainBase;
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());	
		double result[] = new double[cases];
		
		//cases만큼 반복
		for (int i = 0; i < cases; i++) {
			// base 개수
			int baseNum = Integer.parseInt(br.readLine());
			
			// 초기화
			baseList = new LinkedList<base>();
			baseDist = new double[baseNum][baseNum];
			distant = new PriorityQueue<>();
			LinkedList<Integer> remainList = new LinkedList<Integer>();
			resultDis=0d;
			// 기지 좌표 입력
			StringTokenizer st;
			for (int j = 0; j < baseNum; j++) {
				st = new StringTokenizer(br.readLine());
				baseList.add(new base(Double.parseDouble(st.nextToken()),
						Double.parseDouble(st.nextToken())));
				remainList.add(j);
			}
			if(baseNum==1){
				result[i]=0;
				continue;
			}
			
			// 기지 간 거리 계산 baseDist[][]
			double Linemin = 0;
			double max = 0;
			Iterator<base> iter_j = baseList.iterator();
			Iterator<base> iter_k = baseList.iterator();
			for (int j = 0; j < baseNum; j++) {
				base b_j = iter_j.next();
				iter_k = baseList.iterator();
				for (int k = 0; k < baseNum; k++) {
					base b_k = iter_k.next();
					if (j != k) {
						if (j < k) {
							baseDist[j][k] = Math.sqrt(Math.abs(Math.pow(b_j.x
									- b_k.x, 2)
									+ Math.pow(b_j.y - b_k.y, 2)));
							distant.add(baseDist[j][k]);
						} else {
							baseDist[j][k] = baseDist[k][j];
						}
						if (baseDist[j][k] < Linemin || Linemin == 0) {
							Linemin = baseDist[j][k];
						}

					}

				}
				Linemin = 0;
			}
			
			while (distant.peek() < max&&distant.size()>1) {
				distant.poll();
			}
			int t = distant.size();
			
			for (int j = 0; j < t; j++) {
				remainBase = new LinkedList<Integer>();
				remainBase= (LinkedList<Integer>) remainList.clone();
				if(Find(0,distant.peek())){
					break;
				}
				distant.poll();
			}
			/*System.out.println("baseDist----");
			for (int j = 0; j < baseNum; j++) {
				for (int k = 0; k < baseNum; k++) {
					System.out.print(baseDist[j][k] + "\t");
				}
				System.out.println();
			}*/
			
			result[i]=Math.round(resultDis*100d)/100d;
		}//for cases 끝
		for (int i = 0; i < cases; i++) {
			String t = String.format("%.2f", result[i]);
			System.out.println(t);
		}

	}// main 끝
	
	
	
	public static boolean Find(int nowLoc, double dist) {
		ArrayList<Integer> canGo= new ArrayList<>();
		if(remainBase.size()==0){
			resultDis=dist;
			return true;
		}
		//현재 위치에서 갈수 있는 기지 찾기
		Iterator<Integer> iter = remainBase.iterator();
		while(iter.hasNext()){
			int t = iter.next();
			if(dist>=baseDist[nowLoc][t]){
				canGo.add(t);
				iter.remove();
			}
		}
		if(canGo.size()==0)
			return false;
		
		for(int i=0; i<canGo.size(); i++){
			if(Find(canGo.get(i),dist)){
				return true;				
			}
		}
		return false;
	}

}

class base {
	double x;
	double y;

	public base(double x, double y) {
		this.x = x;
		this.y = y;
	}
}