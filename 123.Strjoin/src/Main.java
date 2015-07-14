import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//Algospot Strjoin 2015/6/1
//우선순위큐를 활용하여 가장 작은 수 2개를 더하는 방식으로 해결
public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int result[] = new int[cases];
		PriorityQueue<Element> pq = new PriorityQueue<Element>();

		for (int i = 0; i < cases; i++) {
			pq.clear();
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp = 0;
			for (int j = 0; j < size; j++) {
				pq.add(new Element(Integer.parseInt(st.nextToken())));
			}
			
			while (pq.size() >= 2) {
				temp = pq.poll().getNum() + pq.poll().getNum();
				result[i] += temp;
				pq.add(new Element(temp));
			}
			
		}// for case 끝

		for (int i = 0; i < cases; i++) {
			System.out.println(result[i]);
		}

	}// main 끝

}

class Element implements Comparable<Element> {

	private int num;

	public Element(int num) {
		this.num = num;
	}

	@Override
	public int compareTo(Element o) {

		return num <= o.num ? -1 : 1;
	}

	public int getNum() {
		return num;
	}

}