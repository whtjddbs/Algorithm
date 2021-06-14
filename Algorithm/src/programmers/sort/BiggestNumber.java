/**
 * 코딩테스트 연습 > 정렬 > 가장 큰 수
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
        		//return 값이 양수이면 두 객체의 자리를 변경
        		// x.compareTo(y) : y > x 이면 음수, x == y 이면 0, x > y 이면 양수  
        		return (o1+o2).compareTo(o2+o1)*-1;
        	}
        });
        
        for(String str : strNumbers) {
        	answer += str;
        }
        
        // 0만 있는 경우 
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
