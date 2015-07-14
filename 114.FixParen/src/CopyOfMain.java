/*import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CopyOfMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String result[] = new String[cases];
		for(int i =0; i<cases; i++) {
			result[i]="";
			String temp = sc.next();
			String temp2 = sc.next();
			String temp3 = "";
			for (int j = 0; j < 4; j++) {
				switch (temp2.charAt(j)) {
				case '{':
					temp3 = temp3 + "}";
					break;
				case '<':
					temp3 = temp3 + ">";
					break;
				case '[':
					temp3 = temp3 + "]";
					break;
				case '(':
					temp3 = temp3 + ')';
					break;
				}
			}
			char[] paren = temp.toCharArray();
			Stack stack = new Stack();
			Queue que = new LinkedList<>();
			int k = 0;
			for (int j = 0; j < paren.length; j++) {
				if (paren[j] == '{' || paren[j] == '[' || paren[j] == '<'
						|| paren[j] == '(') {
					stack.add(paren[j]);
					k++;
				} else {
					que.add(paren[j]);
					k--;
				}
				
				if (k == 0 && !stack.isEmpty()) {
					Queue tempstackc = new LinkedList<>();
					Stack tempqueo = new Stack();
					while (!stack.isEmpty()) {
						String s = stack.peek().toString();
						String q = que.peek().toString();
						if (temp2.indexOf(s) < temp3.indexOf(q)) {
							switch (s) {
							case "{":
								q = "}";
								break;
							case "(":
								q = ")";
								break;
							case "[":
								q = "]";
								break;
							case "<":
								q = ">";
								break;
							}
						} else {
							switch (q) {
							case "}":
								s = "{";
								break;
							case ")":
								s = "(";
								break;
							case "]":
								s = "[";
								break;
							case ">":
								s = "<";
								break;
							}// switch 끝
						}// if 끝
						tempqueo.add(s);
						tempstackc.add(q);
						stack.pop();
						que.poll();
					}// while 끝
					while(!tempqueo.isEmpty()){
						result[i]=result[i]+tempqueo.peek();
						tempqueo.pop();
					}
					while(!tempstackc.isEmpty()){
						result[i]=result[i]+tempstackc.peek();
						tempstackc.poll();
					}
					
					
				}// if 끝

			}// for 문 끝

		}//for문 끝
		for(int i =0; i<cases; i++)
		System.out.println(result[i]);
	}

}
*/