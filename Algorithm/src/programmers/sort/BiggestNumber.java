/**
 * �ڵ��׽�Ʈ ���� > �ؽ� > ����Ʈ�ٹ�
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

public class BiggestNumber {
	public String solution(int[] numbers) {
        String answer = "";
        
        String[] strNumbers = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	strNumbers[i] = numbers[i]+"";
        }
        
        String temp = "";
        for(int i = 0; i < strNumbers.length-1; i++) {
        	for(int j=i+1; j<strNumbers.length; j++) {
        		
        		if(strNumbers[j].startsWith(strNumbers[i])) {
        			if(!strNumbers[i].equals(strNumbers[j]) && strNumbers[i].charAt(0) < strNumbers[j].charAt(strNumbers[i].length())) {
        				temp = strNumbers[i];
            			strNumbers[i] = strNumbers[j];
            			strNumbers[j] = temp;
        			}
        		} else if(strNumbers[i].startsWith(strNumbers[j])) {
        			temp = strNumbers[i];
        			strNumbers[i] = strNumbers[j];
        			strNumbers[j] = temp;
        		} else if (strNumbers[j].compareTo(strNumbers[i]) > 0) {
        			temp = strNumbers[i];
        			strNumbers[i] = strNumbers[j];
        			strNumbers[j] = temp;
        		}
        	}
        }
        
        System.out.println(Arrays.asList(strNumbers));
        
        for(String str : strNumbers) {
        	answer += str;
        }
        
        // 0�� �ִ� ��� 
        if(answer.startsWith("0")) return "0";
        
        return answer;
    }
	
	public static void main(String[] args) {
		//int[] numbers = {3, 30, 34, 5, 9};
		int[] numbers = {0, 0, 0};
		
		BiggestNumber bn = new BiggestNumber();
		System.out.println(bn.solution(numbers));
	}
}
