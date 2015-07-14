//2015/6/18 algospot.com FanMeeting https://algospot.com/judge/problem/read/FANMEETING
//카라츠바의 곱셈 알고리즘을 쓰지 않고는 시간 초과
//카라츠바의 곱셈은 두 수의 곱셈을 분할 정복으로 O(n2)을 O(n의 log3승)으로 단축
//4번의 곱을 3번으로 단축
//a1*b0+a0*b1 -> 원래 두번의 곱임
//(a0+a1)*(b0+b1)=a0*b0+a1*b0+a0*b1+a1*b1
//a1*b0+a0*b1 = (a0+a1)*(b0+b1)-a0*b0-a1*b1
//a0*b0, a1*b1 는 전 과정에 필요하기 때문에 이미 곱해놓음, 따라서 (a0+a1)*(b0+b1) 이거 한번만 곱하면 됨
//카라츠바만 다시 짜봄 플젝 이름 135.karatsuba
//카라츠바의 곱셍을 활용한 코드는 FanMeeting2에 다시 짬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private int m[];
	private int f[];

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
			char member[] = br.readLine().toCharArray();
			char fan[] = br.readLine().toCharArray();
			m = new int[member.length];
			f = new int[fan.length];
			for (int j = 0; j < m.length; j++) {
				if (member[j] == 'F') {
					m[j] = 0;
				} else {
					m[j] = 1;
				}
			}
			for (int j = 0; j < f.length; j++) {
				if (fan[j] == 'F') {
					f[j] = 0;
				} else {
					f[j] = 1;
				}
			}
			result[i] = FanMeeting();
		}
		for(int i=0; i<cases; i++)
			System.out.println(result[i]);
		
	}

	public int FanMeeting() {
		int mSize = m.length;
		int fSize = f.length;
		int r = 0;
		int sol=0;
		for (int j = mSize - 1; j <= fSize - 1; j++){
			int t=j;
			for (int i = mSize-1; i >= 0; i--) {
				r += m[i] * f[t--];
			}
			if(r==0){
				sol++;
			}
			r=0;
		}
		return sol;
	}
	
	
}
