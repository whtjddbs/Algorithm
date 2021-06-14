/**
 * �ڵ��׽�Ʈ ���� > ���� > H-Index
 * ���� ����
 * H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.
 * 
 * � �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index�Դϴ�.
 * 
 * � �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���ѻ���
 * �����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
 * ���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
 * ����� ��
 * citations	return
 * [3, 0, 6, 1, 5]	3
 * ����� �� ����
 * �� �����ڰ� ��ǥ�� ���� ���� 5���̰�, ���� 3���� ���� 3ȸ �̻� �ο�Ǿ����ϴ�. �׸��� ������ 2���� ���� 3ȸ ���� �ο�Ǿ��� ������ �� �������� H-Index�� 3�Դϴ�.
 */
package programmers.sort;

import java.util.Arrays;

public class HIndex {
	public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations); // [0, 1, 3, 5, 6]
        
        int n = citations.length;
        for(int hIndex = citations[n-1]; hIndex >= 0; hIndex--) {
            if(hIndex == 0) return 0; // 0�� �ִ� ��� ����
            
        	if(n-hIndex >= 0 && citations[n-hIndex] >= hIndex) {
        		return hIndex;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5}; 
				
		HIndex sol = new HIndex();
		System.out.println(sol.solution(citations));
	}
}
