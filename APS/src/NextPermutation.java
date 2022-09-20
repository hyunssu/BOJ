import java.util.Arrays;

public class NextPermutation {
	
	// NextPermutation : 바로 큰 다음 순열을 구해서....
	
	public static void main(String[] args) {
	
		/*
		 * 1. 오름차순 정렬
		 * 2. 꼭대기 찾기 (뒤에서 부터)
		 * 3. i번째가 꼭대기일 때, i-1번째가 존재한다면 
		 * 4. 다시 제일 뒤에서부터 i-1번째보다 큰값을 찾으면 swap
		 * 5. 꼭대기부터 제일 뒤까지 swap
		 */
		
		
		int[] iArr = {1, 2, 3, 5, 4, 6};
		int cnt = 0;
		Arrays.sort(iArr);
		do {
			cnt++;
			System.out.println(Arrays.toString(iArr));
		}while(perm(iArr));
		System.out.println(cnt);

	}

	private static boolean perm(int[] iArr) {
		int N = iArr.length;
		int i = N - 1;
		for(; i > 0; --i)
			if(iArr[i-1] < iArr[i]) break;
		
		
		// 꼭대기는 i번째이고 낭떠리지가 존재
		
		int j = N - 1;
		
		for(; j >= i; --j) {
			if(iArr[i-1] < iArr[j]) {
				swap(iArr, i-1, j);
				break;
			}
		}
		
		int k = N - 1;
		for(; i < k; ++i, --k) {
			swap(iArr, i, k);
		}
	
		return true;
		
	}

	private static void swap(int[] iArr, int i, int j) {
		int temp = iArr[i];
		iArr[i] = iArr[j];
		iArr[j] = temp;
		return;
	}

}
