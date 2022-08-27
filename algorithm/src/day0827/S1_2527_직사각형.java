package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2527_직사각형 {
	
	static class rectangle {
		double xFocus;
		double yFocus;
		int width;
		int height;
		
		public rectangle(int x1, int y1, int x2, int y2) {
			super();
			this.xFocus = (double) (x1+x2)/2;
			this.yFocus = (double) (y1+y2)/2;
			this.width = Math.abs(x1-x2);
			this.height = Math.abs(y1-y2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 0; tc < 4; tc++) 
		{
			
			rectangle[] arr = new rectangle[2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++) 
			{
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				int q = Integer.parseInt(st.nextToken());
				arr[i] = new rectangle(x, y, p, q);
			}
			
			check(arr);
			
		}//main
	}

	private static void check(rectangle[] arr) {
		// 각 직사각형의 중점 사이의 간격을 각 변수에 할당
		double xInterval = Math.abs(arr[0].xFocus - arr[1].xFocus);
		double yInterval = Math.abs(arr[0].yFocus - arr[1].yFocus);
		// 너비와 높이의 평균
		double xLen = (double) (arr[0].width + arr[1].width)/2;
		double yLen = (double) (arr[0].height + arr[1].height)/2;
		
		
		// 공통부분이 없음
		if(xInterval > xLen || yInterval > yLen)
			System.out.println("d");
		// 점
		else if(xInterval == xLen && yInterval == yLen)
			System.out.println("c");
		// 직사각형
		else if(xInterval < xLen && yInterval < yLen)
			System.out.println("a");
		// 선분
		else
			System.out.println("b");
	}

}
