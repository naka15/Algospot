import java.util.Scanner;

public class Boggle {
	static char[][] word = { { 'u', 'r', 'l', 'p', 'm' },
			{ 'x', 'p', 'r', 'e', 't' }, { 'g', 'i', 'a', 'e', 't' },
			{ 'x', 't', 'n', 'z', 'y' }, { 'x', 'o', 'q', 'r', 's' } };
	static char[][] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		result = new char[5][5];
		while (!input.equals("!")) {
			input = sc.next();
			boolean b = false;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					for (int x = 0; x < 5; x++)
						for (int y = 0; y < 5; y++) {
							result[x][y] = '.';
						}
					if (hasWord(j, i, input)) {
						b = true;
						for (int x = 0; x < 5; x++) {
							for (int y = 0; y < 5; y++) {
								System.out.print(result[x][y] + "  ");
							}
							System.out.println();
						}
						System.out.println();
						System.out.println();
					}
				}
			}

			System.out.println(b);
		}
		return;

	}

	public static boolean hasWord(int y, int x, String input) {
		if (input.length() < 1) {
			return false;
		}
		if (word[x][y] != (char) input.charAt(0)) {
			return false;
		} else {
			result[x][y] = input.charAt(0);
		}
		if (input.length() == 1) {
			return true;
		}
		for (int i = x - 1; i <= x + 1; i++)
			for (int j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && j >= 0 && i < 5 && j < 5 && !(i == x && j == y)) {
					if (hasWord(j, i, input.substring(1))) {
						return true;
					}
				}
			}
		result[x][y]='.';
		return false;

	}

}
