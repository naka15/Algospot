import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String result[] = new String[cases];
		for (int i = 0; i < cases; i++) {
			result[i] = "";
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
			Stack<Character> stack = new Stack<Character>();
			char[] modify = new char[paren.length];
			int x=0;
			while(x<modify.length){
				modify[x]='a';
				x++;
			}
			for (int j = 0; j < paren.length; j++) {
				if (paren[j] == ')' || paren[j] == '}' || paren[j] == '>'
						|| paren[j] == ']') {
					char op = (char) stack.peek();
					char cl = paren[j];
					if (temp2.indexOf(op) < temp3.indexOf(cl)) { // op 쪽이 우선순위 더 높을 때
						switch (op) {
						case '{':
							cl = '}';
							break;
						case '[':
							cl = ']';
							break;
						case '<':
							cl = '>';
							break;
						case '(':
							cl = ')';
							break;
						}

					} else { // cl 쪽이 우선순위 더 높거나 같을 때
						switch (cl) {
						case '}':
							op = '{';
							break;
						case ']':
							op = '[';
							break;
						case ')':
							op = '(';
							break;
						case '>':
							op = '<';
							break;
						}
					}
					modify[j] = cl;
					for(int k=j-1; k>=0; k--){
						if(modify[k]=='a'){
							modify[k]=op;
							break;
						}
					}
					
					stack.pop();
				} else {
					stack.add(paren[j]);
				}//if-else 끝
				
			}//for 문 끝
			result[i]="";
			for(int h=0; h<modify.length; h++)
				result[i]=result[i]+modify[h];
		}// cases for문 끝
		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);
	}
}
