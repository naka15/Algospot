import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String result[] = new String[cases];
		for (int i = 0; i < cases; i++) {
			String quiz[] = new String[5];
			int quizsol = 0;

			// 입력
			for (int j = 0; j < 5; j++) {
				quiz[j] = sc.next();
			}

			// 연산
			switch (quiz[1]) {
			case "+":
				quizsol = convert(quiz[0]) + convert(quiz[2]);
				break;
			case "-":
				quizsol = convert(quiz[0]) - convert(quiz[2]);
				break;
			case "*":
				quizsol = convert(quiz[0]) * convert(quiz[2]);
				break;
			default:
				break;
			}// switch 끝
			result[i] = eval(quizsol, quiz[4]);

		}// cases 횟수만큼 for문 끝

		for (int i = 0; i < cases; i++)
			System.out.println(result[i]);
	}// main 끝

	// 문자->숫자 변형
	public static int convert(String num) {
		int value = 0;
		switch (num) {
		case "zero":
			value = 0;
			break;
		case "one":
			value = 1;
			break;
		case "two":
			value = 2;
			break;
		case "three":
			value = 3;
			break;
		case "four":
			value = 4;
			break;
		case "five":
			value = 5;
			break;
		case "six":
			value = 6;
			break;
		case "seven":
			value = 7;
			break;
		case "eight":
			value = 8;
			break;
		case "nine":
			value = 9;
			break;
		default:
			break;
		}
		return value;
	}

	public static String eval(int quizsol, String subsol) {

		switch (quizsol) {
		case 1:
			// one
			int x[] = new int[3];
			if (subsol.length() == 3) {
				for (int i = 0; i < 3; i++) {
					if (subsol.charAt(i) == 'o') {
						x[0]++;
					} else if (subsol.charAt(i) == 'n') {
						x[1]++;
					} else if (subsol.charAt(i) == 'e') {
						x[2]++;
					} else {
						return "No";
					}
				}
				if (x[0] == 1 && x[1] == 1 && x[2] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}

		case 2:
			// two
			int t[] = new int[3];

			if (subsol.length() == 3) {
				for (int i = 0; i < 3; i++) {
					if (subsol.charAt(i) == 't') {
						t[0]++;
					} else if (subsol.charAt(i) == 'w') {
						t[1]++;
					} else if (subsol.charAt(i) == 'o') {
						t[2]++;
					} else {
						return "No";
					}
				}
				if (t[0] == 1 && t[1] == 1 && t[2] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}

		case 3:
			// three
			int three[] = new int[4];
			if (subsol.length() == 5) {
				for (int i = 0; i < 5; i++) {
					if (subsol.charAt(i) == 't') {
						three[0]++;
					} else if (subsol.charAt(i) == 'h') {
						three[1]++;
					} else if (subsol.charAt(i) == 'r') {
						three[2]++;
					} else if (subsol.charAt(i) == 'e') {
						three[3]++;
					} else {
						return "No";
					}
				}
				if (three[0] == 1 && three[1] == 1 && three[2] == 1
						&& three[3] == 2) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}

		case 4:
			// four
			int four[] = new int[4];
			if (subsol.length() == 4) {
				for (int i = 0; i < 4; i++) {
					if (subsol.charAt(i) == 'f') {
						four[0]++;
					} else if (subsol.charAt(i) == 'o') {
						four[1]++;
					} else if (subsol.charAt(i) == 'u') {
						four[2]++;
					} else if (subsol.charAt(i) == 'r') {
						four[3]++;
					} else {
						return "No";
					}
				}
				if (four[0] == 1 && four[1] == 1 && four[2] == 1
						&& four[3] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}
		case 5:
			// five
			int five[] = new int[4];
			if (subsol.length() == 4) {
				for (int i = 0; i < 4; i++) {
					if (subsol.charAt(i) == 'f') {
						five[0]++;
					} else if (subsol.charAt(i) == 'i') {
						five[1]++;
					} else if (subsol.charAt(i) == 'v') {
						five[2]++;
					} else if (subsol.charAt(i) == 'e') {
						five[3]++;
					}

					else {
						return "No";
					}
				}
				if (five[0] == 1 && five[1] == 1 && five[2] == 1
						&& five[3] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}
		case 6:
			// six
			int six[] = new int[3];
			if (subsol.length() == 3) {
				for (int i = 0; i < 3; i++) {
					if (subsol.charAt(i) == 's') {
						six[0]++;
					} else if (subsol.charAt(i) == 'i') {
						six[1]++;
					} else if (subsol.charAt(i) == 'x') {
						six[2]++;
					} else {
						return "No";
					}
				}
				if (six[0] == 1 && six[1] == 1 && six[2] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}
		case 7:
			// seven
			int seven[] = new int[4];
			if (subsol.length() == 5) {
				for (int i = 0; i < 5; i++) {
					if (subsol.charAt(i) == 's') {
						seven[0]++;
					} else if (subsol.charAt(i) == 'e') {
						seven[1]++;
					} else if (subsol.charAt(i) == 'v') {
						seven[2]++;
					} else if (subsol.charAt(i) == 'n') {
						seven[3]++;
					}

					else {
						return "No";
					}
				}
				if (seven[0] == 1 && seven[1] == 2 && seven[2] == 1
						&& seven[3] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}

		case 8:
			// eight
			int eight[] = new int[5];
			if (subsol.length() == 5) {
				for (int i = 0; i < 5; i++) {
					if (subsol.charAt(i) == 'e') {
						eight[0]++;
					} else if (subsol.charAt(i) == 'i') {
						eight[1]++;
					} else if (subsol.charAt(i) == 'g') {
						eight[2]++;
					} else if (subsol.charAt(i) == 'h') {
						eight[3]++;
					} else if (subsol.charAt(i) == 't') {
						eight[4]++;
					} else {
						return "No";
					}
				}
				if (eight[0] == 1 && eight[1] == 1 && eight[2] == 1
						&& eight[3] == 1&&eight[4]==1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}
		case 9:
			//nine
			int nine[] = new int[3];
			if (subsol.length() == 4) {
				for (int i = 0; i < 4; i++) {
					if (subsol.charAt(i) == 'n') {
						nine[0]++;
					} else if (subsol.charAt(i) == 'i') {
						nine[1]++;
					} else if (subsol.charAt(i) == 'e') {
						nine[2]++;
					} else {
						return "No";
					}
				}
				if (nine[0] == 2 && nine[1] == 1 && nine[2] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}
		case 0:
			//zero
			int zero[] = new int[4];
			if (subsol.length() == 4) {
				for (int i = 0; i < 4; i++) {
					if (subsol.charAt(i) == 'z') {
						zero[0]++;
					} else if (subsol.charAt(i) == 'e') {
						zero[1]++;
					} else if (subsol.charAt(i) == 'r') {
						zero[2]++;
					} else if (subsol.charAt(i) == 'o'){
						zero[3]++;
					}
					else {
						return "No";
					}
				}
				if (zero[0] == 1 && zero[1] == 1 && zero[2] == 1 && zero[3]==1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}
		case 10 : 
			int ten[] = new int[3];
			if (subsol.length() == 3) {
				for (int i = 0; i < 3; i++) {
					if (subsol.charAt(i) == 't') {
						ten[0]++;
					} else if (subsol.charAt(i) == 'e') {
						ten[1]++;
					} else if (subsol.charAt(i) == 'n') {
						ten[2]++;
					} else {
						return "No";
					}
				}
				if (ten[0] == 1 && ten[1] == 1 && ten[2] == 1) {
					return "Yes";
				} else {
					return "No";
				}

			} else {
				return "No";
			}
			
		}// switch문 끝
		return "No";
	}// eval함수 끝
}// main class 끝