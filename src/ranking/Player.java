package ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;

public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<String, int[]> hmRank = new HashMap<String, int[]>();// 아이디 및 이름 저장할 공간
	private HashMap<String, String> hmCom = new HashMap<String, String>();;// 아이디는 동일, value값을 승률+최고점수
	private ArrayList<String> arrRName = null;// rank의 순서대로 이름만 저장할 공간

	private int[] score1 = null;
	private int[] score2 = null;
	private double dP1;
	private double dP2;

	public HashMap<String, int[]> gethmRank() {
		return hmRank;
	}

	public HashMap<String, String> gethmCom() {
		return hmCom;
	}

	public ArrayList<String> getarrRName() {
		return arrRName;
	}

	// save
	public void saveplayer(String name1, String name2, int scoreP1, int scoreP2) {

		// 점수에 따라 승패
		// 확인--------------------------------------------------------------------------------
		// 아이디 비교 후 아이디가 같은게 있을 경우 그 값을 불러온다.
		// 1. P1아이디 유무
		if (hmRank.containsKey(name1)) {
			score1 = hmRank.get(name1);// 0 : 승 , 1 : 패, 2 : 최고점수
		} else {
			score1 = new int[3];// 0 : 승 , 1 : 패, 2 : 최고점수
		}
		// 2. P2아이디 유무
		if (hmRank.containsKey(name2)) {
			score2 = hmRank.get(name2);// 0 : 승 , 1 : 패, 2 : 최고점수
		} else {
			score2 = new int[3];// 0 : 승 , 1 : 패, 2 : 최고점수
		}

		// 승, 패 비교
		if (scoreP1 > scoreP2) {
			score1[0]++;
			score2[1]++;
		} else if (scoreP1 < scoreP2) {
			score1[1]++;
			score2[0]++;
		}

		// 최고점수 갱신
		// 1. P1 아이디 유무
		if (hmRank.containsKey(name1)) {
			if (score1[2] < scoreP1) {
				score1[2] = scoreP1;
			}
		} else {
			score1[2] = scoreP1;
		}
		// 2. P2아이디 유무
		if (hmRank.containsKey(name2)) {
			if (score2[2] < scoreP2) {
				score2[2] = scoreP2;
			}
		} else {
			score2[2] = scoreP2;
		}

		// hashmap에 저장
		hmRank.put(name1, score1);
		hmRank.put(name2, score2);

		// ----------------------------------------------------------------------------------------------

		// 랭킹
		// 비교----------------------------------------------------------------------------------------

		// 승률 구하기(단, 패가 0인경우 1로 나누어준다)
		// 1. P1플레이어
		if (score1[1] == 0) {
			dP1 = ((double) score1[0] / 1);
		} else {
			dP1 = ((double) score1[0] / score1[1]);
		}
		// 2. P2플레이어
		if (score2[1] == 0) {
			dP2 = ((double) score2[0] / 1);
		} else {
			dP2 = ((double) score2[0] / score2[1]);
		}

		// hmCom에 이름 저장 및 승률, 최고점수를 나열한 값 저장
		hmCom.put(name1, String.format("%.2f", dP1) + String.format("%03d", hmRank.get(name1)[2]));
		hmCom.put(name2, String.format("%.2f", dP2) + String.format("%03d", hmRank.get(name2)[2]));

		// 오름차순으로 정렬
		List<Entry<String, String>> list_enteries = new ArrayList<Entry<String, String>>(hmCom.entrySet());
		Collections.sort(list_enteries, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		arrRName = new ArrayList<String>();
		
		// arraylist로 오름차순한 순서대로 "이름"만을 저장(list_enteries에 있는 이름 데이터 값을 순서대로 저장)
		for (int i = 0; i < list_enteries.size(); i++) {
			arrRName.add(list_enteries.get(i).getKey());
		}

		// ----------------------------------------------------------------------------------------------

		score1 = null;
		score2 = null;
		dP1 = 0;
		dP2 = 0;

	}// 생성자

}