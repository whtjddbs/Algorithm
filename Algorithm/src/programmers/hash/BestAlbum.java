/**
 * �ڵ��׽�Ʈ ���� > �ؽ� > ����Ʈ�ٹ�
 * 
 * ���� ����
 * ��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
 * ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
 * �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
 * �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
 * �뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��, ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * ���ѻ���
 * genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
 * plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
 * genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
 * �帣 ������ 100�� �̸��Դϴ�.
 * �帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
 * ��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
 * ����� ��
 * genres		
 * ["classic", "pop", "classic", "classic", "pop"]
 * plays
 * [500, 600, 150, 800, 2500]
 * return
 * [4, 1, 3, 0]
 * ����� �� ����
 * classic �帣�� 1,450ȸ ����Ǿ�����, classic �뷡�� ������ �����ϴ�.
 * 
 * ���� ��ȣ 3: 800ȸ ���
 * ���� ��ȣ 0: 500ȸ ���
 * ���� ��ȣ 2: 150ȸ ���
 * pop �帣�� 3,100ȸ ����Ǿ�����, pop �뷡�� ������ �����ϴ�.
 * 
 * ���� ��ȣ 4: 2,500ȸ ���
 * ���� ��ȣ 1: 600ȸ ���
 * ���� pop �帣�� [4, 1]�� �뷡�� ����, classic �帣�� [3, 0]�� �뷡�� �״����� �����մϴ�.
 */
package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        /* 2021-06-07 Map�ȿ� Map ��� */
        Map<String, Map<Integer, Integer>> map = new HashMap<String, Map<Integer,Integer>>();
        Map<String, Integer> totalPlayMap = new HashMap<String, Integer>();
        
        for(int i=0; i<genres.length; i++) {
        	if(map.containsKey(genres[i])) {
        		map.get(genres[i]).put(i, plays[i]);
        	} else {
        		Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        		temp.put(i, plays[i]);
        		map.put(genres[i], temp);
        	}
        	totalPlayMap.put(genres[i], totalPlayMap.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<String> keySetList = new ArrayList<String>(totalPlayMap.keySet());
        // �������� ���� //
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return totalPlayMap.get(o2).compareTo(totalPlayMap.get(o1));
            }
        });
        
        int i=0;
        answer = new int[totalPlayMap.size()*2];
        for(String key : keySetList) {
        	List<Integer> playKeyList = new ArrayList<Integer>(map.get(key).keySet());
        	
        	Collections.sort(playKeyList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(key).get(o2).compareTo(map.get(key).get(o1));
                }
            });
        	
//        	System.out.println(playKeyList);
        	
        	int j=0;
        	for(Integer itg : playKeyList) {
        		answer[i++] = itg;
        		j++;
        		if(j>=2) break;
        	}
        }
        
//        System.out.println(keySetList);
//        System.out.println(map);
//        System.out.println(totalPlayMap);
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		BestAlbum bestAlbum = new BestAlbum();
		System.out.println(Arrays.asList(bestAlbum.solution(genres, plays)));
	}

}
