package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_2116_주사위_쌓기 {
	static int maxVal = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][6];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 6; i++)
			dice(map, N, map[0][i], 0, 0);
		
		System.out.println(maxVal);

	}
	private static void dice(int[][] map, int n, int bottom, int res, int depth) {
		if(depth == n) {
			maxVal = Math.max(maxVal, res);
			return;
		}
		
		int top = 0;
		for(int i = 0; i < 6; i++)
			if(map[depth][i] == bottom) {
				top = check(map, i, depth);
				break;
			}
		
		int sum = bottom + top;
		// (5, 6)
		if(sum == 11) res += 4;
		// (4, 6)
		else if(sum == 10) res += 5;
		// 이건 6이 절대 안들어감.
		else if(sum < 7) res += 6;
		// 7 8 9 에 대해서
		// (2, 5) (3, 4) (3, 5) (4, 5)  
		else if(bottom != 6 && top != 6) res += 6;
		// (1, 6) (2, 6) (3, 6)
		else res += 5;

		dice(map, n, top, res, depth+1);	
	}
	
	private static int check(int[][] map, int idx, int depth) {
		switch(idx) {
		case 0:
			return map[depth][5];
		case 1:
			return map[depth][3];
		case 2:
			return map[depth][4];
		case 3:
			return map[depth][1];
		case 4:
			return map[depth][2];
		case 5:
			return map[depth][0];
		}
		return Integer.MAX_VALUE;
	}

}
