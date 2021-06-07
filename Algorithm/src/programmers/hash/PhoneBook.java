/**
 * 코딩테스트 연습 > 해시 > 전화번호 목록
 */
package programmers.hash;

import java.util.Arrays;
import java.util.List;

public class PhoneBook {
	public boolean solution(String[] phone_book) {
        boolean answer = true;

        /** 2021-06-02 효율성 테스트 실패
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=0; j<phone_book.length; j++) {
        		if(i!=j && phone_book[j].startsWith(phone_book[i])) {
        			return false;
        		}
        	}
        }
        */
        
        /** 2021-06-06 정렬 후 인접한 번호만 접두사여부 체크 **/
        List<String> phoneList = Arrays.asList(phone_book);
        phoneList.sort(null);
        
        for(int i=0; i<phoneList.size()-1; i++) {
        	if(phoneList.get(i+1).startsWith(phoneList.get(i))) return false;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] phone_book = {"12","123","1235","567","88"};
		PhoneBook sol = new PhoneBook();
		System.out.println(sol.solution(phone_book));
	}
}
