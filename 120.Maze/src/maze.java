//자료구조 교재 미로 문제 2015/5/27

import java.util.Stack;

public class maze {
	public static int maze[][] = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, // [1][1] 입구
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, // [9][9] 출구
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }};

	public static enum directions {
		N(0), NE(1), E(2), SE(3), S(4), SW(5), W(6), NW(7);
		
		private int value;
		directions(int value){
			this.value=value;
		}
		
		public int getValue(){
			return value;
		}
	};

	public static void main(String[] args) {
		Stack<items> st = new Stack<items>();
		offsets move[] = new offsets[8];
		move[0] = new offsets(-1, 0);	//N
		move[1] = new offsets(-1, 1);	//NE
		move[2] = new offsets(0, 1);		//E
		move[3] = new offsets(1, 1);		//SE
		move[4] = new offsets(1, 0);		//S
		move[5] = new offsets(1, -1);	//SW
		move[6] = new offsets(0, -1);	//W
		move[7] = new offsets(-1, -1);	//NW
		
		
		int mark[][] = new int[11][11];		//경로를 저장해둘 곳
		mark[1][1]=1;
		items temp = new items(1,1,directions.E.getValue());
		st.push(temp);
		while(!st.isEmpty()){
			temp=st.peek();
			st.pop();
			
			int i = temp.a;
			int j = temp.b;
			int d = temp.dir;
			while(d<8){
				int g = i+move[d].a;
				int h = j+move[d].b;
				if(g==10&&h==10){
					
					
					System.out.println("i&j:"+i+"  "+ j);
					return;
				}
				
				if(maze[g][h]==0&&mark[g][h]==0){
					mark[g][h]=1;
					
					temp.a=i;
					temp.b=j;
					temp.dir=d+1;
					st.push(temp);
					System.out.println("test :" + temp.a+"  " + temp.b+"  "+temp.dir);
					i=g; j=h; d=directions.N.getValue();
				}
				else d++;
			}
		}
		System.out.println("No path");
	}
}
