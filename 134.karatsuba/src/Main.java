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
//카라츠바 알고리즘을 123={1,2,3} 순으로 arraylist에 넣었더니 계산에 애로사항이 많다
//123 이면 {3,2,1} 순으로 넣어서 계산하는것이 편리하다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private ArrayList<Integer> m;
	private ArrayList<Integer> f;

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
			m = new ArrayList<Integer>();
			f = new ArrayList<Integer>();

			for (int j = 0; j < member.length; j++) {
				if (member[j] == 'F') {
					m.add(0);
				} else {
					m.add(1);
				}
			}

			for (int j = fan.length - 1; j >= 0; j--) {
				if (fan[j] == 'F') {
					f.add(0);
				} else {
					f.add(1);
				}
			}

			result[i] = FanMeeting(m, f);
		}
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);

	}

	public int FanMeeting(ArrayList<Integer> m, ArrayList<Integer> f) {
		int n = m.size();
		ArrayList<Integer> c = karatsuba(m, f);
		int all = 0;
		for (int i = n - 1; i < c.size() - n + 1; i++) {
			if (c.get(i) == 0)
				++all;
		}
		return all;
	}

	public ArrayList<Integer> karatsuba(ArrayList<Integer> a,
			ArrayList<Integer> b) {
		int an = a.size();
		int bn = b.size();
		if (an < bn)
			return karatsuba(b, a);
		if (an == 0 || bn == 0)
			return new ArrayList<>();
		if (an <= 50)
			return multiply(a, b);
		int half = an / 2;
		ArrayList<Integer> a0 = new ArrayList<>(a.subList(0, half));
		ArrayList<Integer> a1 = new ArrayList<>(a.subList(half, a.size()));
		ArrayList<Integer> b0 = new ArrayList<>(b.subList(0,
				Math.min(b.size(), half)));
		ArrayList<Integer> b1 = new ArrayList<>(b.subList(
				Math.min(b.size(), half), b.size()));
		ArrayList<Integer> z2 = karatsuba(a1, b1);
		ArrayList<Integer> z0 = karatsuba(a0, b0);
		addTo(a0, a1, 0);
		addTo(b0, b1, 0);
		ArrayList<Integer> z1 = karatsuba(a0, b0);
		subFrom(z1, z0);
		subFrom(z1, z2);
		ArrayList<Integer> ret = new ArrayList<>();
		addTo(ret, z0, 0);
		addTo(ret, z1, half);
		addTo(ret, z2, half + half);
		return ret;
	}

	public void addTo(ArrayList<Integer> a, ArrayList<Integer> b, int k) {
		int as = a.size();
		int bs = b.size();
		int s = Math.max(as, bs + k);
		for (int i = 0; i < s - as; i++) {
			a.add(0);
		}
		for (int i = 0; i < bs; i++) {
			a.set(i + k, a.get(i + k) + b.get(i));
		}
		/*
		 * //a가 사이즈가 작은 ArrayList로 오도록 bs가 더크면 자리 바꿈 if(as>bs) addTo(b,a,k);
		 * bs--; //ex) a -> 346={3,4,6} b->1234={1,2,3,4} 이므로
		 * a+b={1,3+2,4+3,6+4} a범위는 2~0 b범위는 3~1 for(int i =a.size()-1; i>=0;
		 * i--){ a.set(i,a.get(i)+b.get(bs--)); }
		 */
	}

	// a=a-b
	public void subFrom(ArrayList<Integer> a, ArrayList<Integer> b) {
		int s = Math.max(a.size(), b.size());
		for (int i = 0; i < s - a.size(); i++)
			a.add(0);
		for (int i = 0; i < b.size(); i++)
			a.set(i, a.get(i) - b.get(i));
	}

	public ArrayList<Integer> multiply(ArrayList<Integer> a,
			ArrayList<Integer> b) {
		ArrayList<Integer> c = new ArrayList<Integer>(Collections.nCopies(
				a.size() + b.size() - 1, 0));
		for (int i = 0; i < a.size(); ++i)
			for (int j = 0; j < b.size(); ++j) {
				c.set(i + j, c.get(i + j) + a.get(i) * b.get(j));
			}
		return c;
	}

}
