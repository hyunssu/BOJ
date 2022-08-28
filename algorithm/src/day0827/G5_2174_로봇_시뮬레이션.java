package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class G5_2174_로봇_시뮬레이션 {
	//북동남서
	static int[] drow = {1, 0, -1, 0};
	static int[] dcol = {0, 1, 0, -1};
	static boolean bo = true;
	static int C;
	static int R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		robot[] ro = new robot[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int dir = direction(st.nextToken());
			ro[i] = new robot(row, col, dir); 
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if(bo)
			{
				int robotNum = Integer.parseInt(st.nextToken());
				String commend = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				check(ro, robotNum, commend, count);
			}
		}
		
		if(bo) System.out.println("OK");
		
	}// main
	
	// 로봇 클래스
	static class robot{
		int row;
		int col;
		int dir;
		
		public robot(int row, int col, int dir) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
		public boolean equals(robot bot) {
			if(this.row == bot.row && this.col == bot.col)
				return true;
			else
				return false;
			
		}
	}
	
	// 로봇이 바라보는 방향 설정.
	private static int direction(String nextToken) {
		switch(nextToken) {
			case "N":
				return 0;
			case "E":
				return 1;
			case "S":
				return 2;
			case "W":
				return 3;
		}
		return Integer.MAX_VALUE;
	}
	
	// 로봇이 움직일 때 충돌 여부 확인
	private static void check(robot[] ro, int robotNum, String commend, int count) {
		for(int i = 0; i < count; i++) 
		{
			if(bo) 
			{
			ro[robotNum] = move(ro[robotNum], commend);
			collisionCheck(ro, robotNum);
			} 
			else break;
			}	
	}
	
	// 입력받은 로봇을 움직이는 함수.
	private static robot move(robot bot, String commend) {
		switch(commend) 
		{
			case "L":
				bot.dir -= 1;
				if(bot.dir == -1) bot.dir = 3;
				break;
				
			case "R":
				bot.dir = (bot.dir+1) % 4;
				break;
				
			case "F":
				bot.row = bot.row + drow[bot.dir];
				bot.col = bot.col + dcol[bot.dir];
				break;
		}
		
		return bot;
	}
	
	// 충돌이 있었는지 확인.
	private static void collisionCheck(robot[] ro, int robotNum) {
		//벽과 충돌했는지를 확인
		if(!(1 <= ro[robotNum].row && ro[robotNum].row <= R && 1 <= ro[robotNum].col && ro[robotNum].col <= C)) {
			System.out.println("Robot " + robotNum + " crashes into the wall");
			bo =false;
			return;
		}
			
		//로봇끼리 충돌 여부 확인
		for(int i = 1; i < ro.length; i++) {
			if(robotNum != i && ro[robotNum].equals(ro[i])) {
				System.out.println("Robot " + robotNum + " crashes into robot "+ i);
				bo = false;
				return;
			}
		}
	}
	
}