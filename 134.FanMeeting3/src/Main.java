//multiply만 사용 시간초과
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
		ArrayList<Integer> c = multiply(m, f);
		int all = 0;
		for (int i = n - 1; i < c.size() - n + 1; i++) {
			if (c.get(i) == 0)
				++all;
		}
		return all;
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
