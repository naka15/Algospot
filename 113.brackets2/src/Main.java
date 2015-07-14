import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String result[] = new String[cases];

		for (int i = 0; i < cases; i++) {
			String str = sc.next();
			Stack stack = new Stack();
			for (int j = 0; j < str.length(); j++) {
				char t = str.charAt(j);
				if (t != '}' && t != ']' && t != ')')
					stack.add(str.charAt(j));
				else if (stack.empty()) {
					result[i] = "NO";
				} else {
					switch (t) {
					case ')':
						if (stack.peek().toString().equals("(")
								&& !stack.empty()) {
							stack.pop();
						} else {
							result[i] = "NO";
						}
						break;
					case '}':
						if (stack.peek().toString().equals("{")
								&& !stack.empty()) {
							stack.pop();
						} else {
							result[i] = "NO";
						}
						break;
					case ']':
						if (stack.peek().toString().equals("[")
								&& !stack.empty()) {
							stack.pop();
						} else {
							result[i] = "NO";
						}
						break;
					default:
						break;
					}// switch 끝
				}
			}// for j문 끝
			if (stack.empty()&&result[i]==null){
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
		}// for i문 끝
		for(int i=0; i<cases; i++){
		System.out.println(result[i]);
		}
	}

}
