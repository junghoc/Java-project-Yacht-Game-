package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameFrame {

	public Frame gFrame = new Frame("Yacht");
	private Panel leftPanel = null;
	public JButton[] p1ScoreButton = null;
	public JButton[] p2ScoreButton = null;
	private JLabel[] leftLabel = null;
	private JLabel[] up1Label = null;
	private JLabel[] up2Label = null;
	public JLabel[] underLabel = null;
	private JLabel[] middleLabel = null;
	public JButton[] dices = null;
	private ImageIcon[] diceicon = null;
	private Label background1 = null;
	public Button roll = null;
	private JLabel playerturnlb = null;
	private JLabel dicetrylb = null;
	private Listener listener = new Listener();
	private String player1 = "";
	private String player2 = "";
	public boolean[] diceLocation = new boolean[5];
	private Button helpFrame = null;
	public boolean[] diceKeep = null;

	public String getPlayer1() {
		return player1;
	}

	public String getPlayer2() {
		return player2;
	}

	// 버튼 클릭여부 확인
	public boolean[] usedButton_P1 = new boolean[13];
	public boolean[] usedButton_P2 = new boolean[13];

	public GameFrame(String player1name, String player2name) {

		for (int i = 0; i < usedButton_P1.length; i++) {
			usedButton_P1[i] = false;
			usedButton_P2[i] = false;
		}

		player1 = player1name;
		player2 = player2name;

		for (int i = 0; i < diceLocation.length; i++) {
			diceLocation[i] = true;
		}

		diceKeep = new boolean[5];
		for (int i = 0; i < diceKeep.length; i++) {
			diceKeep[i] = false;
		}

		gFrame.setBounds(100, 100, 900, 800);
		gFrame.setResizable(false);
		gFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		gFrame.setLayout(null);
		gFrame.setBackground(new Color(0, 160, 0));

		leftPanel = new Panel();

		helpFrame = new Button("how to play");
		helpFrame.setBounds(750, 50, 100, 30);
		gFrame.add(helpFrame);
		helpFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HelpFrame();
			}
		});

		p1ScoreButton = new JButton[13];
		for (int i = 0; i < p1ScoreButton.length; i++) {
			p1ScoreButton[i] = new JButton();
		}

		p2ScoreButton = new JButton[13];
		for (int i = 0; i < p2ScoreButton.length; i++) {
			p2ScoreButton[i] = new JButton();
		}

		leftLabel = new JLabel[13];
		for (int i = 0; i < leftLabel.length; i++) {
			leftLabel[i] = new JLabel();
		}
		leftLabel[0].setText("ones");
		leftLabel[1].setText("twos");
		leftLabel[2].setText("threes");
		leftLabel[3].setText("fours");
		leftLabel[4].setText("fives");
		leftLabel[5].setText("sixs");
		leftLabel[6].setText("Choices");
		leftLabel[7].setText("3 of a kind");
		leftLabel[8].setText("4 of a kind");
		leftLabel[9].setText("full House");
		leftLabel[10].setText("S.Straight");
		leftLabel[11].setText("L.Straight");
		leftLabel[12].setText("Yacht");

		// up1Label 설정
		up1Label = new JLabel[3];
		for (int i = 0; i < up1Label.length; i++) {
			up1Label[i] = new JLabel();
		}
		up1Label[0].setText("Turn");
		up1Label[1].setText("p1");
		up1Label[2].setText("p2");

		// up2Label 설정
		up2Label = new JLabel[3];
		for (int i = 0; i < up2Label.length; i++) {
			up2Label[i] = new JLabel();
		}
		up2Label[0].setText("1/13");
		up2Label[1].setText(player1);
		up2Label[2].setText(player2);

		// underLabel 설정
		underLabel = new JLabel[3];
		for (int i = 0; i < underLabel.length; i++) {
			underLabel[i] = new JLabel();
		}
		underLabel[0].setText("total");
		underLabel[1].setText("");
		underLabel[2].setText("");

		// middleLabel 설정
		middleLabel = new JLabel[6];
		for (int i = 0; i < middleLabel.length; i++) {
			middleLabel[i] = new JLabel();
		}
		middleLabel[0].setText("SubTotal");
		middleLabel[1].setText("/63");
		middleLabel[2].setText("/63");
		middleLabel[3].setText("+35 Bonus");
		middleLabel[4].setText("");
		middleLabel[5].setText("");

		// leftpanel 설정
		leftPanel.setBounds(10, 50, 300, 700);
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setLayout(new GridLayout(18, 3));

		// 판넬에 추가
		for (int i = 0; i < up1Label.length; i++) {
			leftPanel.add(up1Label[i]);
		}

		for (int i = 0; i < up2Label.length; i++) {
			leftPanel.add(up2Label[i]);
		}

		for (int i = 0; i < 6; i++) {
			leftPanel.add(leftLabel[i]);
			leftPanel.add(p1ScoreButton[i]);
			leftPanel.add(p2ScoreButton[i]);
		}

		for (int i = 0; i < middleLabel.length; i++) {
			leftPanel.add(middleLabel[i]);
		}

		for (int i = 6; i < leftLabel.length; i++) {
			leftPanel.add(leftLabel[i]);
			leftPanel.add(p1ScoreButton[i]);
			leftPanel.add(p2ScoreButton[i]);
		}

		for (int i = 0; i < underLabel.length; i++) {
			leftPanel.add(underLabel[i]);
		}

		// Dice ImageIcon 추가 (diceicon) -----------------
		diceicon = new ImageIcon[6];
		diceicon[0] = new ImageIcon("주사위1.png");
		diceicon[1] = new ImageIcon("주사위2.png");
		diceicon[2] = new ImageIcon("주사위3.png");
		diceicon[3] = new ImageIcon("주사위4.png");
		diceicon[4] = new ImageIcon("주사위5.png");
		diceicon[5] = new ImageIcon("주사위6.png");

		// Dice추가 ------------------------------------------
		dices = new JButton[5];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new JButton(diceicon[0]);
			dices[i].setBounds(350 + i * 100, 280, 90, 90);
			dices[i].setBackground(new Color(0, 0, 0, 0));
			gFrame.add(dices[i]);
		}

		// background1 -------------------------------------
		background1 = new Label();
		background1.setBackground(Color.DARK_GRAY);
		background1.setBounds(340, 450, 500, 300);
		gFrame.add(background1);

		// roll button -------------------------------------
		roll = new Button("ROLL!");
		roll.setBounds(535, 400, 120, 30);
		gFrame.add(roll);

		// playerturnlb -----------------------------------
		String ptlb_str = "의 턴입니다";
		String ptlb_str_main = player1 + ptlb_str;
		playerturnlb = new JLabel(ptlb_str_main);
		playerturnlb.setBounds(380, 100, 500, 60);
		playerturnlb.setFont(new Font(null, Font.BOLD, 50));
		gFrame.add(playerturnlb);

		// dicetrylb -------------------------------------
		dicetrylb = new JLabel("남은 휫수 : 3");
		dicetrylb.setBounds(380, 200, 500, 60);
		dicetrylb.setFont(new Font(null, Font.BOLD, 16));
		gFrame.add(dicetrylb);

		gFrame.add(leftPanel);
		leftPanel.setVisible(true);
		gFrame.setVisible(false);

		// button actionListener --------------------------
		for (int i = 0; i < p1ScoreButton.length; i++) {
			p1ScoreButton[i].addActionListener(listener);
		}
		for (int i = 0; i < p2ScoreButton.length; i++) {
			p2ScoreButton[i].addActionListener(listener);
		}
		for (int i = 0; i < dices.length; i++) {
			dices[i].addActionListener(listener);
		}
		roll.addActionListener(listener);

	} // GameFrame() end

	// ActionListener -------------------------------------------------
	boolean rollEnable = true;
	int[] score = null;
	public boolean rollDice = false;
	public boolean nextplayer = false;
	public boolean checkDices = false;

	public class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < p1ScoreButton.length; i++) {
				if (e.getSource() == p1ScoreButton[i]) {
					System.out.println("p1점수 버튼 클릭됨 : " + i);
					usedButton_P1[i] = true;
					for (int j = 0; j < p1ScoreButton.length; j++) {
						nextplayer = true;
						p1ScoreButton[j].setEnabled(false);
					}
					break;
				}
			}

			for (int i = 0; i < p2ScoreButton.length; i++) {
				if (e.getSource() == p2ScoreButton[i]) {
					System.out.println("p2점수 버튼 클릭됨 : " + i);
					usedButton_P2[i] = true;
					for (int j = 0; j < p2ScoreButton.length; j++) {
						nextplayer = true;
						p2ScoreButton[j].setEnabled(false);
					}
					break;
				}
			}

			if (e.getSource() == roll) {
				System.out.println("roll버튼 선택됨");
				rollDice = true;
				roll.setEnabled(rollEnable);
			}

			for (int i = 0; i < dices.length; i++) {
				if (e.getSource() == dices[i]) {
					System.out.println(i + "번 다이스 선택됨");
					if (diceLocation[i]) {
						diceKeep[i] = true;
						dices[i].setLocation(350 + i * 100, 580);
						diceLocation[i] = false;
						checkDices = true;
					} else {
						diceKeep[i] = true;
						dices[i].setLocation(350 + i * 100, 280);
						diceLocation[i] = true;
						checkDices = true;
					}

				}
			}
		}
	} // Listener end

	// startVoid 메소드 ------------------------------------------

	public void startVoid(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		up2Label[1].setText(player1);
		up2Label[2].setText(player2);
		playerturnlb.setText(player1 + "의 턴 입니다");
	}

	// ~~의 턴 입니다 설정메소드

	public void setPlayerTurnlb(boolean playerTurn) {
		if (playerTurn)
			playerturnlb.setText(player1 + "의 턴 입니다");
		else
			playerturnlb.setText(player2 + "의 턴 입니다");
	}

	// 버튼 활성화/비활성화 메소드 --------------------------------------
	public void enableButton_P1(boolean b) {
		for (int i = 0; i < p1ScoreButton.length; i++) {
			if (!usedButton_P1[i])
				p1ScoreButton[i].setEnabled(b);
		}
	}

	public void enableButton_P2(boolean b) {
		for (int i = 0; i < p2ScoreButton.length; i++) {
			if (!usedButton_P2[i])
				p2ScoreButton[i].setEnabled(b);
		}
	}

	public void enableButton_roll(boolean b) {
		roll.setEnabled(b);
	}

	public void enableDiceButton(boolean b) {
		for (int i = 0; i < dices.length; i++) {
			dices[i].setEnabled(b);
		}
	}

	// total -------------------------------------------------
	public void setTotal_P1(int totalP1) {
		underLabel[1].setText("" + totalP1);
	}

	public void setTotal_P2(int totalP2) {
		underLabel[2].setText("" + totalP2);
	}

	// subtotal -----------------------------------------------
	public void setSubTotal_P1(int subTotal_P1) {
		middleLabel[1].setText(subTotal_P1 + "/63");
	}

	public void setsubTotal_P2(int subTotal_P2) {
		middleLabel[2].setText(subTotal_P2 + "/63");
	}

	// +35 bonus -----------------------------------------------
	public void setBonus_P1(boolean bonus) {
		middleLabel[4].setText("+35");
	}

	public void setBonus_P2(boolean bonus) {
		middleLabel[5].setText("+35");
	}

	// 주사위 모양 변경 ----------------------------------------------
	public void setDiceIcon(int[] dice) {
		for (int i = 0; i < dices.length; i++) {
			switch (dice[i]) {
			case 1:
				dices[i].setIcon(new ImageIcon("주사위1.png"));
				break;
			case 2:
				dices[i].setIcon(new ImageIcon("주사위2.png"));
				break;
			case 3:
				dices[i].setIcon(new ImageIcon("주사위3.png"));
				break;
			case 4:
				dices[i].setIcon(new ImageIcon("주사위4.png"));
				break;
			case 5:
				dices[i].setIcon(new ImageIcon("주사위5.png"));
				break;
			case 6:
				dices[i].setIcon(new ImageIcon("주사위6.png"));
				break;
			}
		}
	}

	// turnLabel text변경 메소드
	public void setTurnLabel(int turn) {
		up2Label[0].setText(turn + "/13");
	}

	// 남은 휫수 변경 메소드
	public void setTryDicelb(int tryDice) {
		dicetrylb.setText("남은 휫수 : " + tryDice);
	}

	// 주사위 원래 위치로 복귀
	public void setDefaultDiceLocation() {
		for (int i = 0; i < dices.length; i++) {
			dices[i].setLocation(350 + i * 100, 280);

		}
	}

	// 점수 p1ScoreButton에 표현

	public void p1setScore(int[] score) {

		for (int i = 0; i < p1ScoreButton.length; i++) {
			if (!usedButton_P1[i]) {

				p1ScoreButton[i].setText("");
				if (score[i] != 0) { // score가 0이 아닐시에 텍스트 표시
					p1ScoreButton[i].setText("(" + score[i] + ")");
				}
			}

		}
	}

	// 점수 p2ScoreButton에 표현

	public void p2setScore(int[] score) {

		for (int i = 0; i < p2ScoreButton.length; i++) {
			if (!usedButton_P2[i]) {

				p2ScoreButton[i].setText("");
				if (score[i] != 0) { // score가 0이 아닐시에 텍스트 표시
					p2ScoreButton[i].setText("(" + score[i] + ")");
				}
			}

		}
	}

	// subTotal 보너스 total 점수 표시 ------------------------------------------ 수정필요

	public void p1Total(int[] score) {// p1

		int sum = 0;
		int sum2 = 0;

		// subtotal 점수 표시
		for (int i = 0; i < 6; i++) {
			sum += score[i];
		}
		middleLabel[1].setText(sum + "/63");

		// 보너스 점수 표시
		if (sum >= 63) {
			middleLabel[4].setText("35");
			sum2 += 35;
		}

		// Total 점수 표시
		for (int i = 0; i < score.length; i++) {
			sum2 += score[i];
		}
		underLabel[1].setText("" + sum2);

	}
	
	public int total(int[] score) {
		int result = 0;
		for (int i = 0; i < score.length; i++) {
			result += score[i];
		}
		return result;
	}

	public void p2Total(int[] score) {// p2

		int sum = 0;
		int sum2 = 0;

		// subtotal 점수 표시
		for (int i = 0; i < 6; i++) {
			sum += score[i];
		}
		middleLabel[2].setText(String.valueOf(sum) + "/63");
		// 보너스 점수 표시
		if (sum >= 63) {
			middleLabel[5].setText("35");
			sum2 += 35;
		}

		// Total 점수 표시
		for (int i = 0; i < score.length; i++) {
			sum2 += score[i];
		}
		underLabel[2].setText(String.valueOf(sum2));
	}

}
