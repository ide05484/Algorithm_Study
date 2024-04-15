import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class psy_9251_LCS {
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[][] arr = new int[str1.length()][str2.length()];

		for (int r = 0; r < str1.length(); r++) {
			for (int c = 0; c < str2.length(); c++) {
				if (str1.charAt(r) == str2.charAt(c))
					arr[r][c] = 1;
			}
		}
		int result = 0;
		for (int r = 0; r < str1.length(); r++) {
			for (int c = 0; c < str2.length(); c++) {
				if (r == 0 && c == 0)
					continue;
				else if (r == 0) {
					if (arr[r][c - 1] == 1)
						arr[r][c] = 1;
				} else if (c == 0) {
					if (arr[r - 1][c] == 1)
						arr[r][c] = 1;
				} else {
					if (arr[r][c] == 0)
						arr[r][c] = Math.max(arr[r - 1][c], arr[r][c - 1]);
					else
						arr[r][c] = arr[r - 1][c - 1] + 1;
				}
			}
		}
//		for (int r = 0; r < str1.length(); r++) {
//			for (int c = 0; c < str2.length(); c++) {
//				System.out.print(arr[r][c] + " ");
//			}
//			System.out.println();
//		}
		
//		for(int[] tmp : arr) {
//			System.out.println(Arrays.toString(tmp));
//		}

		System.out.println(arr[str1.length() - 1][str2.length() - 1]);
	}
}
