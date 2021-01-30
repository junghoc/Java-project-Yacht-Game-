package condition;

public class Condition {

	public Dice dice = new Dice();
	public int[] dice_score = new int[13];

	public void con() { // 조건 비교
		if (dice.roll_chance > 0) {
			for (int i = 0; i < dice_score.length; i++) {
				dice_score[i] = 0;
			}

			dice.rollDice();
			dice.ifhas();

			// 1부터 6까지 조건에 맞는 점수를 score배열에 넣음
			for (int i = 0; i < dice.numbers.length; i++) {
				if (dice.numbers[i] > 0) {
					dice_score[i] = dice.numbers[i] * (i + 1);
				}
				// Three-Of-A-Kind 주사위 3개 이상의 눈이 동일할 때, 주사위 5개의 합
				if (dice.numbers[i] >= 3) {
					dice_score[7] = dice.sum;
				}

				// Four-Of-A-Kind 주사위 4개 이상의 눈이 동일할 때, 주사위 5개의 합
				if (dice.numbers[i] >= 4) {
					dice_score[8] = dice.sum;
				}
				// Full House 눈이 동일한 주사위가 각각 3개와 2개가 있을 때, 고정 25점
				if (dice.numbers[i] == 3) {
					for (int j = 0; j < dice.numbers.length; j++) {
						if (dice.numbers[j] == 2 && i != j)
							dice_score[9] = 25;
					}
				}
				// Yahtzee 주사위 5개의 눈이 모두 같을 때, 고정 50점
				if (dice.numbers[i] == 5) {
					dice_score[12] = 50;
				}
			}

			// Small Straight 주사위 4개 이상의 눈이 이어지는 수일 때, 고정 30점
			if (dice.numbers[0] > 0 && dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0) {
				dice_score[10] = 30;
			} else if (dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0 && dice.numbers[4] > 0) {
				dice_score[10] = 30;
			} else if (dice.numbers[2] > 0 && dice.numbers[3] > 0 && dice.numbers[4] > 0 && dice.numbers[5] > 0) {
				dice_score[10] = 30;
			}

			// Large Straight 주사위 5개의 눈이 이어지는 수일 때, 고정 40점
			if (dice.numbers[0] > 0 && dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0
					&& dice.numbers[4] > 0) {
				dice_score[11] = 40;
			} else if (dice.numbers[1] > 0 && dice.numbers[2] > 0 && dice.numbers[3] > 0 && dice.numbers[4] > 0
					&& dice.numbers[5] > 0) {
				dice_score[11] = 40;
			}

			// Chance 주사위 5개의 총합
			dice_score[6] = dice.sum;

			// 테스트코드
//			System.out.println(" ");
//			for (int i = 0; i < dice_score.length; i++) {
//				System.out.print(dice_score[i] + " ");
//			}
		}
	}// con()

}
