/**
 * 코딩테스트 연습 > 해시 > 베스트앨범
 * 
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres		
 * ["classic", "pop", "classic", "classic", "pop"]
 * plays
 * [500, 600, 150, 800, 2500]
 * return
 * [4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 * 
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 * 
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 */
package programmers.hash;

import java.util.*;

public class BestAlbum {
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        /* 2021-06-07 Map안에 Map 사용 */
        Map<String, Map<Integer, Integer>> map = new HashMap<String, Map<Integer,Integer>>(); // 장르별 Map<고유번호, 플레이수>
        Map<String, Integer> totalPlayMap = new HashMap<String, Integer>(); // 장르별 플레이수 총합
        
        // 데이터 적재
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
        
        // 총 플레이수가 높은 순서대로 장르 정렬
        List<String> keySetList = new ArrayList<String>(totalPlayMap.keySet());
        // 내림차순 정렬
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return totalPlayMap.get(o2).compareTo(totalPlayMap.get(o1));
            }
        });
        
        int i=0;
        List<Integer> answerList = new ArrayList<Integer>();
        
        // 우선순위 장르별 상위 플레이수 정렬 및 상위 2개 추출 
        for(String key : keySetList) {
        	List<Integer> playKeyList = new ArrayList<Integer>(map.get(key).keySet());
        	
        	Collections.sort(playKeyList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(key).get(o2).compareTo(map.get(key).get(o1));
                }
            });
        	
        	int j=0;
        	for(Integer itg : playKeyList) {
        		answerList.add(i++, itg);
        		j++;
        		if(j>=2) break;
        	}
        }
        
        answer = new int[answerList.size()];
        for(int k=0; k<answer.length; k++) {
        	answer[k] = answerList.get(k);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		BestAlbum bestAlbum = new BestAlbum();
		System.out.println(Arrays.asList(bestAlbum.solution(genres, plays)));
	}

}
