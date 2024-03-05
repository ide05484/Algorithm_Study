package IM;

import java.util.Scanner;

public class 일회용 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 신입사원수
			int min = sc.nextInt(); // 분반 최소
			int max = sc.nextInt(); // 분반 최대

			int[] count = new int[101]; // 점수 100점까지있음

			for (int i = 0; i < N; i++) {
				count[sc.nextInt()]++; // 하나씩 더해줘!
			}

			// 세 팀의 인원수
			int team1 = 0;
			int team2 = 0;
			int team3 = 0;

			int answer = Integer.MAX_VALUE;


			out: for (int i = 1; i < 101 - min * 2; i++) {
				
				
				team1 += count[i];

				if (team1 <= max && team1 >= min) {
					for (int j = i + 1; j < 101 - min; j++) {
						team2 += count[j];

						if (team2 <= max && team2 >= min) {
							for (int k = j + 1; k < 101; k++) {
								team3 += count[k];

								if (team1 + team2 + team3 > N)
									continue out;
							}
							
							int kmax = 0;
							int kmin = Integer.MAX_VALUE;
							
							kmax = Math.max(kmax, team1);
							kmin = Math.min(kmin, team1);
							
							kmax = Math.max(kmax, team2);
							kmin = Math.min(kmin, team2);
							
							kmax = Math.max(kmax, team3);
							kmin = Math.min(kmin, team3);
							
							System.out.println(kmax + ":max");
							System.out.println(kmin + ":min");
							
							answer = Math.min(answer, kmax - kmin);

						}
					}
				}
			}

			if (team1 == 0 || team2 == 0 || team3 == 0) {
				answer = -1;
			}

			System.out.println("#" + tc + " " + answer);
		} // 테케마감
	}// main마감
}
