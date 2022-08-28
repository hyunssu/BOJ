package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_8320_직사각형을_만드는_방법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = i; i*j <= N; j++)
				res++;
		}
		System.out.println(res);
		
	}

}
