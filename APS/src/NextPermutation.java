import java.util.Arrays;

public class NextPermutation {
	
	// NextPermutation : �ٷ� ū ���� ������ ���ؼ�....
	
	public static void main(String[] args) {
	
		/*
		 * 1. �������� ����
		 * 2. ����� ã�� (�ڿ��� ����)
		 * 3. i��°�� ������� ��, i-1��°�� �����Ѵٸ� 
		 * 4. �ٽ� ���� �ڿ������� i-1��°���� ū���� ã���� swap
		 * 5. �������� ���� �ڱ��� swap
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
		
		
		// ������ i��°�̰� ���������� ����
		
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