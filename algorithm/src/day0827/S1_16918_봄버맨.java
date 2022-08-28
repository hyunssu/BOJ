package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16918_봄버맨 {
	static boolean[][] visited;
	static char[][] map;

	static int time = 1;	
	static int[] drow = {-1, 1, 0, 0};
	static int[] dcol = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// row col second
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		map = new char[R][C];
		
		for(int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();		
		
		if(time != N) game(R, C, N);
		
		print(R);
		
	}
	
	private static void game(int R, int C, int N) {
		//과정 3
		time++;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'O') visited[i][j] = true;
				else map[i][j] = 'O';
			}
		}
		
		if (time == N) return;
		
		// 과정 4
		time++;
		
		for(int i = 0; i < R; i++)
			for(int j = 0; j < C; j++)
				if(visited[i][j] == true) {
					visited[i][j] = false;
					map[i][j] = '.';
					bomb(R, C, i, j);
				}
		
		if (time == N) return;
		
		game(R, C, N);
	}
	
	private static void bomb(int R, int C, int row, int col) {
	
		for(int i = 0; i < 4; i++) {
			int nrow = row + drow[i];
			int ncol = col + dcol[i];
			
			if(0 <= nrow && nrow < R && 0 <= ncol && ncol < C) {
				map[nrow][ncol] = '.';
			}
		}
		
	}

	// 출력함수
	private static void print(int R) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++)
			sb.append(map[i]).append("\n");
		
		System.out.println(sb);
	}
}
