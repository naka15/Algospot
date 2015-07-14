import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//2015/6/26 Algospot.com LIS https://www.algospot.com/judge/problem/read/LIS

public class Main {
	int input[];
	int dp[];
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.In();
	}

	public void In() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];

		for (int i = 0; i < cases; i++) {
			int num = Integer.parseInt(br.readLine());
			String s[] = new String[num];
			s = br.readLine().split(" ");
			input= new int[num];
			for(int j=0; j<num; j++){
				input[j]=Integer.parseInt(s[j]);
			}
			dp = new int[num+1];
			Arrays.fill(dp, -10);
			result[i]=getLis(0);
			
		}
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);

	}

	private int getLis(int s) {
		if(dp[s+1]!=-10){
			return dp[s+1];
		}
		dp[s+1]=1;
		for(int i=s+1; i<input.length; ++i){
			if(s==0||input[s]<input[i]){
				dp[s+1]=Math.max(dp[s+1],getLis(i)+1);
			}
		}
		return dp[s+1];
		
	}
}
