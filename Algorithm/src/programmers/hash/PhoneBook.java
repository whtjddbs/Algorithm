/**
 * �ڵ��׽�Ʈ ���� > �ؽ� > ��ȭ��ȣ ���
 */
package programmers.hash;

import java.util.Arrays;
import java.util.List;

public class PhoneBook {
	public boolean solution(String[] phone_book) {
        boolean answer = true;

        /** 2021-06-02 ȿ���� �׽�Ʈ ����
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=0; j<phone_book.length; j++) {
        		if(i!=j && phone_book[j].startsWith(phone_book[i])) {
        			return false;
        		}
        	}
        }
        */
        
        /** 2021-06-06 ���� �� ������ ��ȣ�� ���λ翩�� üũ **/
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
