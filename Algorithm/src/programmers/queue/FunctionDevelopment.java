/**
 * �ڵ��׽�Ʈ ���� > ����/ť > ��ɰ���
 * 
 * ���� ����
 * ���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
 * 
 * ��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
 * 
 * ���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * ���� ����
 * �۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
 * �۾� ������ 100 �̸��� �ڿ����Դϴ�.
 * �۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
 * ������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.
 * ����� ��
 * progresses	speeds	return
 * [93, 30, 55]	[1, 30, 5]	[2, 1]
 * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 * ����� �� ����
 * ����� �� #1
 * ù ��° ����� 93% �Ϸ�Ǿ� �ְ� �Ϸ翡 1%�� �۾��� �����ϹǷ� 7�ϰ� �۾� �� ������ �����մϴ�.
 * �� ��° ����� 30%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 30%�� �۾��� �����ϹǷ� 3�ϰ� �۾� �� ������ �����մϴ�. ������ ���� ù ��° ����� ���� �ϼ��� ���°� �ƴϱ� ������ ù ��° ����� �����Ǵ� 7��° �����˴ϴ�.
 * �� ��° ����� 55%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 5%�� �۾��� �����ϹǷ� 9�ϰ� �۾� �� ������ �����մϴ�.
 * 
 * ���� 7��°�� 2���� ���, 9��°�� 1���� ����� �����˴ϴ�.
 * 
 * ����� �� #2
 * ��� ����� �Ϸ翡 1%�� �۾��� �����ϹǷ�, �۾��� ��������� ���� �ϼ��� ���� 5��, 10��, 1��, 1��, 20��, 1���Դϴ�. � ����� ���� �ϼ��Ǿ����� �տ� �ִ� ��� ����� �ϼ����� ������ ������ �Ұ����մϴ�.
 * 
 * ���� 5��°�� 1���� ���, 10��°�� 3���� ���, 20��°�� 2���� ����� �����˴ϴ�.
 */
package programmers.queue;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<Integer>();
        
        // �ʱ� ���� ����
        int day = 1; // ���� ������
        int progress = 0; 
        int speed = 0;
        int index = 0;
        answerList.add(0);
        
        for(int i = 0; i < progresses.length; i++) {
        	progress = progresses[i];
        	speed = speeds[i];
        	
        	// ���� ������ ���� �̹� �۾��Ϸ� �Ǿ����� ����
        	if(progress + speed * day >= 100) {
    			index = answerList.size()-1;
    			answerList.set(index, answerList.get(index)+1);
        		continue;
        	} else if(i == 0) {
        		answerList.remove(i);
        	}
        	
        	// ���� �۾��Ͽ� �۾����� �Ϸ���� �ʾ����� �۾��� ��� �� ���� ������ ����
        	day = (int)Math.ceil((100.0 - progress)/speed); 
        	answerList.add(1);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		FunctionDevelopment fd = new FunctionDevelopment();
		System.out.println(fd.solution(progresses, speeds));
	}
}
