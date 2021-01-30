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

	// ��ư Ŭ������ Ȯ��
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

		// up1Label ����
		up1Label = new JLabel[3];
		for (int i = 0; i < up1Label.length; i++) {
			up1Label[i] = new JLabel();
		}
		up1Label[0].setText("Turn");
		up1Label[1].setText("p1");
		up1Label[2].setText("p2");

		// up2Label ����
		up2Label = new JLabel[3];
		for (int i = 0; i < up2Label.length; i++) {
			up2Label[i] = new JLabel();
		}
		up2Label[0].setText("1/13");
		up2Label[1].setText(player1);
		up2Label[2].setText(player2);

		// underLabel ����
		underLabel = new JLabel[3];
		for (int i = 0; i < underLabel.length; i++) {
			underLabel[i] = new JLabel();
		}
		underLabel[0].setText("total");
		underLabel[1].setText("");
		underLabel[2].setText("");

		// middleLabel ����
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

		// leftpanel ����
		leftPanel.setBounds(10, 50, 300, 700);
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setLayout(new GridLayout(18, 3));

		// �ǳڿ� �߰�
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

		// Dice ImageIcon �߰� (diceicon) -----------------
		diceicon = new ImageIcon[6];
		diceicon[0] = new ImageIcon("�ֻ���1.png");
		diceicon[1] = new ImageIcon("�ֻ���2.png");
		diceicon[2] = new ImageIcon("�ֻ���3.png");
		diceicon[3] = new ImageIcon("�ֻ���4.png");
		diceicon[4] = new ImageIcon("�ֻ���5.png");
		diceicon[5] = new ImageIcon("�ֻ���6.png");

		// Dice�߰� ------------------------------------------
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
		String ptlb_str = "�� ���Դϴ�";
		String ptlb_str_main = player1 + ptlb_str;
		playerturnlb = new JLabel(ptlb_str_main);
		playerturnlb.setBounds(380, 100, 500, 60);
		playerturnlb.setFont(new Font(null, Font.BOLD, 50));
		gFrame.add(playerturnlb);

		// dicetrylb -------------------------------------
		dicetrylb = new JLabel("���� �ܼ� : 3");
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
					System.out.println("p1���� ��ư Ŭ���� : " + i);
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
					System.out.println("p2���� ��ư Ŭ���� : " + i);
					usedButton_P2[i] = true;
					for (int j = 0; j < p2ScoreButton.length; j++) {
						nextplayer = true;
						p2ScoreButton[j].setEnabled(false);
					}
					break;
				}
			}

			if (e.getSource() == roll) {
				System.out.println("roll��ư ���õ�");
				rollDice = true;
				roll.setEnabled(rollEnable);
			}

			for (int i = 0; i < dices.length; i++) {
				if (e.getSource() == dices[i]) {
					System.out.println(i + "�� ���̽� ���õ�");
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

	// startVoid �޼ҵ� ------------------------------------------

	public void startVoid(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		up2Label[1].setText(player1);
		up2Label[2].setText(player2);
		playerturnlb.setText(player1 + "�� �� �Դϴ�");
	}

	// ~~�� �� �Դϴ� �����޼ҵ�

	public void setPlayerTurnlb(boolean playerTurn) {
		if (playerTurn)
			playerturnlb.setText(player1 + "�� �� �Դϴ�");
		else
			playerturnlb.setText(player2 + "�� �� �Դϴ�");
	}

	// ��ư Ȱ��ȭ/��Ȱ��ȭ �޼ҵ� --------------------------------------
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

	// �ֻ��� ��� ���� ----------------------------------------------
	public void setDiceIcon(int[] dice) {
		for (int i = 0; i < dices.length; i++) {
			switch (dice[i]) {
			case 1:
				dices[i].setIcon(new ImageIcon("�ֻ���1.png"));
				break;
			case 2:
				dices[i].setIcon(new ImageIcon("�ֻ���2.png"));
				break;
			case 3:
				dices[i].setIcon(new ImageIcon("�ֻ���3.png"));
				break;
			case 4:
				dices[i].setIcon(new ImageIcon("�ֻ���4.png"));
				break;
			case 5:
				dices[i].setIcon(new ImageIcon("�ֻ���5.png"));
				break;
			case 6:
				dices[i].setIcon(new ImageIcon("�ֻ���6.png"));
				break;
			}
		}
	}

	// turnLabel text���� �޼ҵ�
	public void setTurnLabel(int turn) {
		up2Label[0].setText(turn + "/13");
	}

	// ���� �ܼ� ���� �޼ҵ�
	public void setTryDicelb(int tryDice) {
		dicetrylb.setText("���� �ܼ� : " + tryDice);
	}

	// �ֻ��� ���� ��ġ�� ����
	public void setDefaultDiceLocation() {
		for (int i = 0; i < dices.length; i++) {
			dices[i].setLocation(350 + i * 100, 280);

		}
	}

	// ���� p1ScoreButton�� ǥ��

	public void p1setScore(int[] score) {

		for (int i = 0; i < p1ScoreButton.length; i++) {
			if (!usedButton_P1[i]) {

				p1ScoreButton[i].setText("");
				if (score[i] != 0) { // score�� 0�� �ƴҽÿ� �ؽ�Ʈ ǥ��
					p1ScoreButton[i].setText("(" + score[i] + ")");
				}
			}

		}
	}

	// ���� p2ScoreButton�� ǥ��

	public void p2setScore(int[] score) {

		for (int i = 0; i < p2ScoreButton.length; i++) {
			if (!usedButton_P2[i]) {

				p2ScoreButton[i].setText("");
				if (score[i] != 0) { // score�� 0�� �ƴҽÿ� �ؽ�Ʈ ǥ��
					p2ScoreButton[i].setText("(" + score[i] + ")");
				}
			}

		}
	}

	// subTotal ���ʽ� total ���� ǥ�� ------------------------------------------ �����ʿ�

	public void p1Total(int[] score) {// p1

		int sum = 0;
		int sum2 = 0;

		// subtotal ���� ǥ��
		for (int i = 0; i < 6; i++) {
			sum += score[i];
		}
		middleLabel[1].setText(sum + "/63");

		// ���ʽ� ���� ǥ��
		if (sum >= 63) {
			middleLabel[4].setText("35");
			sum2 += 35;
		}

		// Total ���� ǥ��
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

		// subtotal ���� ǥ��
		for (int i = 0; i < 6; i++) {
			sum += score[i];
		}
		middleLabel[2].setText(String.valueOf(sum) + "/63");
		// ���ʽ� ���� ǥ��
		if (sum >= 63) {
			middleLabel[5].setText("35");
			sum2 += 35;
		}

		// Total ���� ǥ��
		for (int i = 0; i < score.length; i++) {
			sum2 += score[i];
		}
		underLabel[2].setText(String.valueOf(sum2));
	}

}
