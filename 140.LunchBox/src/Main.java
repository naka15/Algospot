import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//2016/6/30 Algospot.com LUNCHBOX https://algospot.com/judge/problem/read/LUNCHBOX
//greedy
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.In();
	}
	public void In() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		for(int i=0; i<cases; i++){
			int pNum = Integer.parseInt(br.readLine());
			String s[] = new String[pNum];
			String t[] = new String[pNum];
			s= br.readLine().split(" ");
			t= br.readLine().split(" ");
			Comparator<lunch> comp = new comp();
			PriorityQueue<lunch> p = new PriorityQueue<lunch>(comp);
			for(int j=0; j<pNum; j++){
				p.add(new lunch(Integer.parseInt(s[j]),Integer.parseInt(t[j])));
			}
			result[i]=getTime(p);
		}
		for(int i=0; i<cases; i++)
			System.out.println(result[i]);
	}
	public int getTime(PriorityQueue<lunch> p){
		int ret=0;
		int wt=0;
		while(!p.isEmpty()){
			wt+=p.peek().wt;
			ret=Math.max(p.peek().et+wt,ret);
			p.poll();
		}
		return ret;
	}
}


//et 내림차순
class comp implements Comparator<lunch>{

	@Override
	public int compare(lunch l1, lunch l2) {
		if(l1.et<l2.et){
			return 1;
		}
		if(l1.et>l2.et)
			return -1;
		return 0;
	}
}

class lunch{
	int wt;
	int et;
	public lunch(int wt, int et){
		this.wt=wt;
		this.et=et;
	}
}

