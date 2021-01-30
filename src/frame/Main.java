package frame;

import condition.*;
import ranking.Player;
import ranking.PlayerLoader;
import ranking.PlayerWriter;

public class Main {
	public static void main(String[] args) {

		// LoadFrame 호출
		LoadFrame lf = new LoadFrame();

		while (lf.loadFrame.isActive()) {
		}

		// GameFrame 호출
		GameFrame gf = null;
		// LoadFrame 시작 버튼 클릭시
		while (true) {
			if (!lf.loadFrame.isDisplayable()) {
				gf = new GameFrame(lf.getPlayer1Name(), lf.getPlayer2Name());
				gf.startVoid(lf.getPlayer1Name(), lf.getPlayer2Name());
				gf.gFrame.setVisible(true);
				break;
			}
		}

		// 차례 설정
		boolean playerTurn = true; // true : 1P / false : 2P

		// GameFrame 기본설정
		gf.enableButton_P1(false);
		gf.enableButton_P2(false);
		gf.enableDiceButton(false);

		// Condition 호출
		Condition ct = new Condition();

		int turn = 1;
		int[] totalScore_P1 = new int[13];
		int[] totalScore_P2 = new int[13];

		for (int i = 0; i < totalScore_P1.length; i++) {
			totalScore_P1[i] = 0;
			totalScore_P2[i] = 0;
		}

		boolean[] writeScore_P1 = new boolean[13];
		boolean[] writeScore_P2 = new boolean[13];

		for (int i = 0; i < writeScore_P1.length; i++) {
			writeScore_P1[i] = true;
			writeScore_P2[i] = true;
		}

		boolean[] saveDice = new boolean[5];

		for (int i = 0; i < saveDice.length; i++) {
			saveDice[i] = false;
		}

		while (true) {

			// 버그 방지
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 플에이어 턴
			if (gf.nextplayer) {
				// 기본 턴이 넘어갈 때의 설정
				int[] score = new int[13];
				for (int i = 0; i < score.length; i++) {
					score[i] = 0;
				}
				gf.p1setScore(score);
				gf.p2setScore(score);

				ct.dice.roll_chance = 3;
				gf.enableDiceButton(false);
				gf.rollEnable = true;
				gf.roll.setEnabled(true);
				gf.setTryDicelb(ct.dice.roll_chance);
				gf.setDefaultDiceLocation();
				ct.dice.reset();
				for (int i = 0; i < saveDice.length; i++) {
					gf.diceLocation[i] = true;
					saveDice[i] = false;
					gf.diceKeep[i] = false;
				}

				if (playerTurn) {
					// P2의 차례로 넘어감
					playerTurn = false;
					gf.setPlayerTurnlb(playerTurn);

					// P1의 totalScore 등록 및 버튼 이름 변경
					for (int i = 0; i < gf.usedButton_P1.length; i++) {
						if (gf.usedButton_P1[i] && writeScore_P1[i]) {
							writeScore_P1[i] = false;
							gf.p1ScoreButton[i].setText("" + ct.dice_score[i]);
							totalScore_P1[i] = ct.dice_score[i];
						}

					}
					gf.p1Total(totalScore_P1);
					gf.p2Total(totalScore_P2);

				} else {
					// p1의 차례로 넘어감
					playerTurn = true;
					gf.setPlayerTurnlb(playerTurn);
					turn++;
					gf.setTurnLabel(turn);

					// P2의 totalScore 등록 및 버튼 이름 변경
					for (int i = 0; i < gf.usedButton_P2.length; i++) {
						if (gf.usedButton_P2[i] && writeScore_P2[i]) {
							writeScore_P2[i] = false;
							gf.p2ScoreButton[i].setText("" + ct.dice_score[i]);
							totalScore_P2[i] = ct.dice_score[i];
						}
					}
					gf.p1Total(totalScore_P1);
					gf.p2Total(totalScore_P2);

				}

				gf.nextplayer = false;
			}

			// Dices 버튼 클릭시
			if (gf.checkDices) {
				for (int i = 0; i < gf.diceKeep.length; i++) {
					if (gf.diceKeep[i] && !saveDice[i]) { // roll_dice -> save_dice
						System.out.println("다이스 저장됨");
						saveDice[i] = true;
						gf.diceKeep[i] = false;
						ct.dice.save_dice[i] = ct.dice.roll_dice[i];
						ct.dice.roll_dice[i] = 0;
					} else if (gf.diceKeep[i] && saveDice[i]) { // save_dice -> roll_dice
						System.out.println("다이스 꺼냄");
						saveDice[i] = false;
						gf.diceKeep[i] = false;
						ct.dice.roll_dice[i] = ct.dice.save_dice[i];
						ct.dice.save_dice[i] = 0;
					}
				}
				gf.checkDices = false;
			}

			// roll버튼 활성화/비활성화
			if (ct.dice.roll_chance <= 1)
				gf.rollEnable = false;
			else if (ct.dice.roll_chance == 3)
				gf.rollEnable = true;

			// roll버튼 클릭시
			if (gf.rollDice) {

				// 처음 roll버튼 누른 다음 점수판 활성화
				if (ct.dice.roll_chance == 3) {
					if (playerTurn) {
						gf.enableDiceButton(true);
						gf.enableButton_P1(true);
					} else {
						gf.enableDiceButton(true);
						gf.enableButton_P2(true);
					}
				}

				// 확인문
				System.out.println("던져짐!");
				ct.con(); // 주사위 던져짐

				// 확인문
				System.out.print("total_dice : ");
				for (int i = 0; i < ct.dice.total_dice.length; i++) {
					System.out.print(ct.dice.total_dice[i] + " ");
				}
				System.out.println();

				gf.setTryDicelb(ct.dice.roll_chance);
				for (int i = 0; i < ct.dice.roll_dice.length; i++) {
					System.out.print(ct.dice.roll_dice[i] + " ");
				}
				System.out.println();

				// 표 버튼 이름 설정
				gf.setDiceIcon(ct.dice.roll_dice);
				gf.rollDice = false;

				// 검사
				for (int i = 0; i < ct.dice_score.length; i++) {
					System.out.print(ct.dice_score[i] + " ");
				}
				System.out.println();

				// 표에 점수 표시
				if (playerTurn) {
					gf.p1setScore(ct.dice_score);
					gf.p1Total(totalScore_P1);
				} else {
					gf.p2setScore(ct.dice_score);
					gf.p2Total(totalScore_P2);
				}
			}

			if (turn > 13) {
				break;
			}
		} // while end

		// turn 14 이상 종료
		System.out.println("Game set!!");

		// 결과 변수들 생성
		int p1Score = gf.total(totalScore_P1);
		int p2Score = gf.total(totalScore_P2);
		String player1 = gf.getPlayer1().trim();
		String player2 = gf.getPlayer2().trim();

		new ResultFrame(player1, player2, p1Score, p2Score);

		// save !!
		PlayerLoader pl = new PlayerLoader();
		if (pl.getloadOk()) {
			pl.getInfo().saveplayer(player1, player2, p1Score, p2Score);
			new PlayerWriter(pl.getInfo());
		} else {
			Player playerFile = new Player();
			playerFile.saveplayer(player1, player2, p1Score, p2Score);
			new PlayerWriter(playerFile);
		}
	}// main
}
