package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_10157_자리배정 {
	//상우하좌 순으로 순회
	static int[] drow = {1, 0, -1, 0};
	static int[] dcol = {0, 1, 0, -1};
	static int start = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		K = check(row, col, K);
		if(K == -1) {
			System.out.println(0);
			return;
		}
		itinerate(row, col, K);
	}
	

	private static int check(int r, int c, int k) {
		if(r*c < k) return -1;
		
		while(true) 
		{
			int num = 2*(r + c) - 4;
			r -= 2;
			c -= 2;
			if(k - num <= 0) break;
			start++;
			k -= num;
		}
		return k;
	}

	
	private static void itinerate(int r, int c, int k) {
		int row = start;
		int col = start;
		int i = 0;
		while(k > 1) {
			row += drow[i];
			col += dcol[i];
			if( start <= row && row < r - start && start <= col && col < c - start) {
				k--;
			}else {
				row -= drow[i];
				col -= dcol[i];
				i++;
			}
		}
		System.out.println((col+1) + " " + (row+1));
		
	}
}
