package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_11399_ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sum = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sum[0] = arr[0];
		
		for(int i = 1 ; i < N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		int res = 0;
		for(int i = 0; i < N; i++)
			res += sum[i];
		
		System.out.println(res);

	}

}
