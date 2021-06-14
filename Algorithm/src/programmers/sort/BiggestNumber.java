/**
 * �ڵ��׽�Ʈ ���� > ���� > ���� ū ��
 * ���� ����
 * 0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.
 * 
 * ���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.
 * 
 * 0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���� ����
 * numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
 * numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
 * ������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
 * ����� ��
 * numbers	return
 * [6, 10, 2]	"6210"
 * [3, 30, 34, 5, 9]	"9534330"
 */
package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
	public String solution(int[] numbers) {
        String answer = "";
        
        String[] strNumbers = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	strNumbers[i] = numbers[i]+"";
        }
        
        Arrays.sort(strNumbers, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		//return ���� ����̸� �� ��ü�� �ڸ��� ����
        		// x.compareTo(y) : y > x �̸� ����, x == y �̸� 0, x > y �̸� ���  
        		return (o1+o2).compareTo(o2+o1)*-1;
        	}
        });
        
        for(String str : strNumbers) {
        	answer += str;
        }
        
        // 0�� �ִ� ��� 
        if(answer.startsWith("0")) return "0";
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
//		int[] numbers = {0, 0, 0};
		
		BiggestNumber bn = new BiggestNumber();
		System.out.println(bn.solution(numbers));
	}
}
