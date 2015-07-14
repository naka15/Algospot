//2015/07/14 Algospot TSP1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private double Edge[][];
	double res;
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.In();
	}

	public void In() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		double result[] = new double[cases];
		for (int i = 0; i < cases; i++) {
			int num = Integer.parseInt(br.readLine());
			Edge = new double[num][num];
			String s[] = new String[num];
			for (int j = 0; j < num; j++) {
				s = br.readLine().split("  ");
				for (int k = 0; k < num; k++){
					Edge[j][k] = Double.parseDouble(s[k]);
				}
			}
			res=999999999d;
			for(int j=0; j<num; j++){
				boolean []visited = new boolean[num];
				
				getDis(j,visited,1,0);
			}
			result[i]=res;
		}
		for(int i=0; i<cases; i++){
			String t = String.format("%.10f", result[i]);
			System.out.println(t);
		}
	}
	
	public void getDis(int nowLoc,boolean[] visited,int c,double sum){
		/*System.out.println("c :"+ c+"  nowLoc : "+nowLoc);*/
		visited[nowLoc]=true;
		if(c==visited.length){
			res=Math.min(sum,res);
			return;
		}
		
		for(int i=0; i<visited.length; i++){
			if(visited[i]==false&&Edge[nowLoc][i]>0){
				boolean temp[] = visited.clone();
				getDis(i,temp,c+1,sum+Edge[nowLoc][i]);
			}
		}
		
	}
}


