/**
 * 코딩테스트 연습 > 해시 > 베스트앨범
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 입출력 예
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
        
        // 0만 있는 경우 
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
