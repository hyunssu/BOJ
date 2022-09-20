import java.util.Scanner;

public class G4_1062_가르침 {
	
	static int n, k;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	static String[] word;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		sc.nextLine();
		word = new String[n];
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			str = str.replace("anta", "");
			str = str.replace("tica", "");
			word[i] = str;
		}
		
		if(k < 5) {	// a c i n t의 개수가 5개
			System.out.println("0");
			return;
		}else if (k == 26) { // 모든 알파벳을 다 읽을 수 있다.
			System.out.println(n);
			return;
		}
		
		visited = new boolean[26];
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		
		dfs(0, 0);
		System.out.println(max);
		
	}// main

	private static void dfs(int alpha, int len) {
		
		if(len == k - 5) {
			int count = 0;
			for(int i = 0; i < n; i++) {	// 뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
				boolean read = true;
				for(int j = 0; j < word[i].length(); j++) {
					if(!visited[word[i].charAt(j) - 'a']) {
						read = false;
						break;
					}
				}
				if(read) count++;
			}
			max = Math.max(max, count);
			return;
		}
		
		for(int i = alpha; i < 26; i++) {
			if(visited[i] ==false) {
				visited[i] = true;
				dfs(i, len + 1);
				visited[i] = false;
			}
		}
		
		
	}
	
}
