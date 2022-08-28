package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_2839_설탕_배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		if(N / 5 != 0) {
			cnt = N / 5;
			N %= 5;
		}
		
		while(N != 0) {
			if(N % 3 != 0) {
				cnt -= 1; N += 5;
			}
			else {
				cnt += N/3; N = 0;
			}
			
			if(cnt == -1) break;
		}
		
		System.out.println(cnt);	
	}
}
