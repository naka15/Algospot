import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Main {
	int game[];
	int t=0;
	int result=0;
	int dy[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.In();
	}
	
	public void In() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		
		for(int i=0; i<cases; i++){
			int gameLength = Integer.parseInt(br.readLine());
			String s[]= new String[gameLength];
			s = br.readLine().split(" ");
			game= new int[gameLength];
			for(int j =0; j<gameLength; j++){
				game[j]=Integer.parseInt(s[j]);
			}
			dy= new int[gameLength][gameLength];
			for(int k=0; k<gameLength; k++)
				for(int j=0; j<gameLength; j++){
					dy[k][j]=-999999;
				}
			result[i]=getScore(0,gameLength-1);
		}
		for(int i=0; i<cases; i++){
			System.out.println(result[i]);
		}
		
	}
	
	public int getScore(int left, int right){
		int temp[]=new int[4];
		int ret=0;
		//왼쪽, 오른쪽 가져간 경우 비교
		if(left>right){
			return 0; 
		}
		if(dy[left][right]!=-999999){
			return dy[left][right];
		}
		if(right==left){
			return game[left];
		}
		
		temp[0]=game[left]-getScore(left+1,right);
		temp[1]=game[right]-getScore(left,right-1);
		temp[2]=-getScore(left+2,right);
		temp[3]=-getScore(left,right-2);
		ret = Math.max(temp[0], temp[1]);
		ret = Math.max(ret,temp[2]);
		ret = Math.max(ret,  temp[3]);
		dy[left][right]=ret;
		return ret;
	}

}
