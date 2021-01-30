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

	private HashMap<String, int[]> hmRank = new HashMap<String, int[]>();// ���̵� �� �̸� ������ ����
	private HashMap<String, String> hmCom = new HashMap<String, String>();;// ���̵�� ����, value���� �·�+�ְ�����
	private ArrayList<String> arrRName = null;// rank�� ������� �̸��� ������ ����

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

		// ������ ���� ����
		// Ȯ��--------------------------------------------------------------------------------
		// ���̵� �� �� ���̵� ������ ���� ��� �� ���� �ҷ��´�.
		// 1. P1���̵� ����
		if (hmRank.containsKey(name1)) {
			score1 = hmRank.get(name1);// 0 : �� , 1 : ��, 2 : �ְ�����
		} else {
			score1 = new int[3];// 0 : �� , 1 : ��, 2 : �ְ�����
		}
		// 2. P2���̵� ����
		if (hmRank.containsKey(name2)) {
			score2 = hmRank.get(name2);// 0 : �� , 1 : ��, 2 : �ְ�����
		} else {
			score2 = new int[3];// 0 : �� , 1 : ��, 2 : �ְ�����
		}

		// ��, �� ��
		if (scoreP1 > scoreP2) {
			score1[0]++;
			score2[1]++;
		} else if (scoreP1 < scoreP2) {
			score1[1]++;
			score2[0]++;
		}

		// �ְ����� ����
		// 1. P1 ���̵� ����
		if (hmRank.containsKey(name1)) {
			if (score1[2] < scoreP1) {
				score1[2] = scoreP1;
			}
		} else {
			score1[2] = scoreP1;
		}
		// 2. P2���̵� ����
		if (hmRank.containsKey(name2)) {
			if (score2[2] < scoreP2) {
				score2[2] = scoreP2;
			}
		} else {
			score2[2] = scoreP2;
		}

		// hashmap�� ����
		hmRank.put(name1, score1);
		hmRank.put(name2, score2);

		// ----------------------------------------------------------------------------------------------

		// ��ŷ
		// ��----------------------------------------------------------------------------------------

		// �·� ���ϱ�(��, �а� 0�ΰ�� 1�� �������ش�)
		// 1. P1�÷��̾�
		if (score1[1] == 0) {
			dP1 = ((double) score1[0] / 1);
		} else {
			dP1 = ((double) score1[0] / score1[1]);
		}
		// 2. P2�÷��̾�
		if (score2[1] == 0) {
			dP2 = ((double) score2[0] / 1);
		} else {
			dP2 = ((double) score2[0] / score2[1]);
		}

		// hmCom�� �̸� ���� �� �·�, �ְ������� ������ �� ����
		hmCom.put(name1, String.format("%.2f", dP1) + String.format("%03d", hmRank.get(name1)[2]));
		hmCom.put(name2, String.format("%.2f", dP2) + String.format("%03d", hmRank.get(name2)[2]));

		// ������������ ����
		List<Entry<String, String>> list_enteries = new ArrayList<Entry<String, String>>(hmCom.entrySet());
		Collections.sort(list_enteries, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		arrRName = new ArrayList<String>();
		
		// arraylist�� ���������� ������� "�̸�"���� ����(list_enteries�� �ִ� �̸� ������ ���� ������� ����)
		for (int i = 0; i < list_enteries.size(); i++) {
			arrRName.add(list_enteries.get(i).getKey());
		}

		// ----------------------------------------------------------------------------------------------

		score1 = null;
		score2 = null;
		dP1 = 0;
		dP2 = 0;

	}// ������

}