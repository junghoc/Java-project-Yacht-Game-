package condition;

import java.util.Random;

public class Dice {

	public int[] dice_score = new int[12];

	public int roll_chance = 3;

	// �ֻ��� �Ѱ�
	public int sum = 0;

	// �ֻ��� �ʱⰪ
	public int[] roll_dice = { 1, 1, 1, 1, 1 };
	public int[] save_dice = { 0, 0, 0, 0, 0 };

	// roll_dice�� save_dice�� �迭�� ��簪�� �ϳ��� ���� �迭
	public int[] total_dice = new int[10];

	// 1~6������ ���ڰ� ��ִ��� �����ϴ� �迭
	public void rollDice() {
		// roll �ֻ��� & �ֻ����� ŵ�� 0�ϰ�� ����������
		if (roll_chance > 0) {
			roll_chance--;
			for (int i = 0; i < roll_dice.length; i++) {
				if (roll_dice[i] != 0) {
					roll_dice[i] = (new Random().nextInt(6) + 1);
				} // if
			} // for
		} // if
	}// roll_dice()

	int[] numbers = new int[6];

	// �迭�� 1~6������ ���ڰ� ��� �ִ��� ���ϴ� ����
	public int[] ifhas() {
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int n5 = 0;
		int n6 = 0;
		sum = 0;
		for (int i = 0; i < 5; i++) {
			total_dice[i] = roll_dice[i];
			total_dice[i] += save_dice[i];
		}
		
		for (int i = 0; i < total_dice.length; i++) {
			if (total_dice[i] == 1) {
				++n1;
			}
			if (total_dice[i] == 2) {
				++n2;
			}
			if (total_dice[i] == 3) {
				++n3;
			}
			if (total_dice[i] == 4) {
				++n4;
			}
			if (total_dice[i] == 5) {
				++n5;
			}
			if (total_dice[i] == 6) {
				++n6;
			}

			sum += total_dice[i];
		} // for
		numbers[0] = n1;
		numbers[1] = n2;
		numbers[2] = n3;
		numbers[3] = n4;
		numbers[4] = n5;
		numbers[5] = n6;

		return numbers;
	}// ifhas()
	
	//rollDice�� saveDice�ʱ�ȭ
	public void reset() {
		for (int i = 0; i < roll_dice.length; i++) {
			roll_dice[i] = 1;
			save_dice[i] = 0;
		}
	}
	

}
