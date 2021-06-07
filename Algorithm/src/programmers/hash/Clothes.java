/**
 * 코딩테스트 연습 > 해시 > 위장
 */
package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Clothes {

	public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String[] item : clothes) {
        	map.put(item[1], map.getOrDefault(item[1], 0)+1);
        }
        
        for( String key : map.keySet() ){
        	answer = answer*(map.get(key)+1);
        }
        
        return answer-1;
    }
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Clothes sol = new Clothes();
		System.out.println(sol.solution(clothes));
	}

}
