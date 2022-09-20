import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class »Æ¿Œ {
	
	static int N;
	static int res;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			res = Integer.MAX_VALUE;
			StringTokenizer st;
			for(int i = 0; i  < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, visited);
			System.out.println("#" + tc + " " + res);
			
			
		}// tc

	}// main
	
	private static void dfs(int depth, int sum, boolean[][] visited) {
		if(depth == N/2) {
			int val = check(bit);
			res = Math.min(res, val);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(visited[i][j] == false) {
					visited[i][j]
				}
			}
		}
			if((bit & 1<<i) == 0)
				dfs(depth+1, bit | 1<<i);

	}
	
	private static int check(int bit) {
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < N; i++) {
			if((bit & 1<<i) != 0) {
				for(int j = i+1; j < N; j++) {
					if((bit & 1<<j) != 0) {
						sum1 += map[i][j];
						sum1 += map[j][i];
					}
				}
			}
			else {
				for(int j = i+1; j < N; j++) {
					if((bit & 1<<j) == 0) {
						sum2 += map[i][j];
						sum2 += map[j][i];
					}
				}
			}
		}
		return Math.abs(sum1-sum2);
	}
}