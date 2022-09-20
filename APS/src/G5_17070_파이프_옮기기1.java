import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17070_파이프_옮기기1 {
	// 가로 대각선 세로
	static int[] drow = {0, 1, 1};
	static int[] dcol = {1, 1, 0};
	static int[][] map;
	static int N;
	static int cnt = 0;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * 가로 : mode 0
		 * 세로 : mode 2
		 * 대각선 : mode 1
		 */
		dfs(0, 1, 0);
		System.out.println(cnt);
	}


	private static void dfs(int row, int col, int mode) {

		if(row == (N-1) && col == (N-1)) {

			++cnt;
			return;
		}
		
		boolean bo = true;
		// 대각선 검사
		for(int i = 0; i < 3; i++) 
		{
			int nrow = row + drow[i];
			int ncol = col + dcol[i];
			
			if(!(0 <= nrow && nrow < N && 0 <= ncol && ncol < N && map[nrow][ncol] == 0)) {
				bo = false;
			} 
		}
		
		if(bo) {

			dfs(row + 1, col + 1, 1);
		}
		
		// 무조건 가로
		if(mode == 1 || mode == 0) {
			int nrow = row + drow[0];
			int ncol = col + dcol[0];
			if(0 <= nrow && nrow < N && 0 <= ncol && ncol < N && map[nrow][ncol] == 0) {

				dfs(nrow, ncol, 0);
				
			}
		}
		// 무조건 세로
		if (mode == 1 || mode == 2)  
		{
			int nrow = row + drow[2];
			int ncol = col + dcol[2];
			if(0 <= nrow && nrow < N && 0 <= ncol && ncol < N && map[nrow][ncol] == 0) {
				dfs(nrow, ncol, 2);
			}
		}
		
	}

}
