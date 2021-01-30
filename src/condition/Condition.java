package condition;

public class Condition {

	public Dice dice = new Dice();
	public int[] dice_score = new int[13];

	public void con() { // ���� ��
		if (dice.roll_chance > 0) {
			for (int i = 0; i < dice_score.length; i++) {
				dice_score[i] = 0;
			}

			dice.rollDice();
			dice.ifhas();

			// 1���� 6���� ���ǿ� �´� ������ score�迭�� ����
			for (int i = 0; i < dice.numbers.length; i++) {
				if (dice.numbers[i] > 0) {
					dice_score[i] = dice.numbers[i] * (i + 1);
				}
				// Three-Of-A-Kind �ֻ��� 3�� �̻��� ���� ������ ��, �ֻ��� 5���� ��
				if (dice.numbers[i] >= 3) {
					dice_score[7] = dice.sum;
				}

				// Four-Of-A-Kind �ֻ��� 4�� �̻��� ���� ������ ��, �ֻ��� 5���� ��
				if (dice.numbers[i] >= 4) {
					dice_score[8] = dice.sum;
				}
				// Full House ���� ������ �ֻ����� ���� 3���� 2���� ���� ��, ���� 25��
				if (dice.numbers[i] == 3) {
					for (int j = 0; j < dice.numbers.length; j++) {
						if (dice.numbers[j] == 2 && i != j)
							dice_score[9] = 25;
					}
				}
				// Yahtzee �ֻ��� 5���� ���� ��� ���� ��, ���� 50��
				if (dice.numbers[i] == 5) {
					dice_score[12] = 50;
				}
			}

			// Small Straight �ֻ��� 4�� �̻��� ���� �̾����� ���� ��, ���� 30��
			if (dice.numbers[0] > 0 && dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0) {
				dice_score[10] = 30;
			} else if (dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0 && dice.numbers[4] > 0) {
				dice_score[10] = 30;
			} else if (dice.numbers[2] > 0 && dice.numbers[3] > 0 && dice.numbers[4] > 0 && dice.numbers[5] > 0) {
				dice_score[10] = 30;
			}

			// Large Straight �ֻ��� 5���� ���� �̾����� ���� ��, ���� 40��
			if (dice.numbers[0] > 0 && dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0
					&& dice.numbers[4] > 0) {
				dice_score[11] = 40;
			} else if (dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0 && dice.numbers[4] > 0
					&& dice.numbers[5] > 0) {
				dice_score[11] = 40;
			}

			// Chance �ֻ��� 5���� ����
			dice_score[6] = dice.sum;

			// �׽�Ʈ�ڵ�
//			System.out.println(" ");
//			for (int i = 0; i < dice_score.length; i++) {
//				System.out.print(dice_score[i] + " ");
//			}
		}
	}// con()

}
