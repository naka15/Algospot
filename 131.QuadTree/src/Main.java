import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//2015/6/17 Algospot.com 문제 QuadTree https://algospot.com/judge/problem/read/QUADTREE
//분할 정복

public class Main {
	static int i;
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main m = new Main();
		m.in();
	}

	public void in() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		String []result=new String[cases];
		for (int j = 0; j < cases; j++) {
			i=0;
			String s = br.readLine();
			result[j]=reverse(s);
		}

		for(int j=0; j<cases; j++)
			System.out.println(result[j]);

	}

	public String reverse(String s) {
		char head=s.charAt(i++);
		if(head!='x'){
			return head+"";
		}else{
			String a,b,c,d;
			a=reverse(s);
			b=reverse(s);
			c=reverse(s);
			d=reverse(s);
			return 'x'+c+d+a+b;
		}
	}

}
