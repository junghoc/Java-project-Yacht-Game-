package frame;

import ranking.PlayerLoader;
import ranking.RankFrame;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoadFrame {

	public Frame loadFrame = null;
	private JButton l_start = null;
	private JButton l_rank = null;
	private JButton l_exit = null;
	private Label p1 = null;
	private Label p2 = null;
	private Font pFont = null;
	private Font font = null;
	public TextField player1 = null;
	public TextField player2 = null;
	private ImageIcon backImg = null;
	private JLabel backJl = null;

	private String player1Name = "";
	private String player2Name = "";

	public String getPlayer1Name() {
		return player1Name;
	}

	public String getPlayer2Name() {
		return player2Name;
	}

	private boolean check1 = false;
	private boolean check2 = false;

	// ������
	public LoadFrame() {

		loadFrame = new Frame("Game - Yacht");
		loadFrame.setBounds(300, 200, 400, 700);
		loadFrame.setLayout(null);
		loadFrame.setResizable(false);

		l_start = new JButton("����");
		l_start.setBounds(150, 450, 100, 40);
		loadFrame.add(l_start);

		l_rank = new JButton("��ŷ");
		l_rank.setBounds(150, 495, 100, 40);
		loadFrame.add(l_rank);

		l_exit = new JButton("������");
		l_exit.setBounds(150, 540, 100, 40);
		loadFrame.add(l_exit);

		// p1 ���̵� �Է�
		p1 = new Label("P1");
		pFont = new Font("�ü�ü", Font.BOLD, 20);
		p1.setFont(pFont);
		p1.setBounds(75, 130, 30, 30);
		loadFrame.add(p1);

		player1 = new TextField(10);
		font = new Font("�ü�ü", Font.PLAIN, 15);
		player1.setFont(font);
		player1.setBounds(120, 130, 200, 30);
		loadFrame.add(player1);

		// p2 ���̵� �Է�
		p2 = new Label("P2");
		p2.setFont(pFont);
		p2.setBounds(75, 170, 30, 30);
		loadFrame.add(p2);

		player2 = new TextField(10);
		player2.setFont(font);
		player2.setBounds(120, 170, 200, 30);
		loadFrame.add(player2);

		// �� ��� �̹���
		backImg = new ImageIcon("image.png");
		backJl = new JLabel(backImg);
		backJl.setBounds(0, 0, 400, 700);
		loadFrame.add(backJl);

		// '����'��ư ��Ȱ��ȭ
		l_start.setEnabled(false);

		// p1 and p2�� ���ڰ� ���� �� Ȱ��ȭ
		player1.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent arg0) {
				if (!player1.getText().trim().equals("")) {
					check1 = true;
				} else {
					check1 = false;
				}

				// chech1,2�� true�� �Ǹ� ���۹�ư Ȱ��ȭ
				if (check1 == true && check2 == true) {
					l_start.setEnabled(true);
				}

			}
		});

		player2.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent arg0) {
				if (!player2.getText().trim().equals("")) {
					check2 = true;
				} else {
					check2 = false;
				}

				// chech1,2�� true�� �Ǹ� ���۹�ư Ȱ��ȭ
				if (check1 == true && check2 == true) {
					l_start.setEnabled(true);
				}
			}
		});

		// '����' ������ ��
		l_start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (player1.getText().trim().equals(player2.getText().trim())) {
					System.out.println("���̵� �����ϴ�.");
					JOptionPane.showMessageDialog(
							loadFrame, "���̵� �����ϴ�.");
				} else {
					player1Name = player1.getText().trim();
					player2Name = player2.getText().trim();

					// ���̵� ������ game�� ������� ���ھ�� �Բ� ����---------------------------------------------
					loadFrame.dispose();
				}
			}
		});

		// '��ŷ' ������ ��
		l_rank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerLoader loader = new PlayerLoader();

				if (loader.getloadOk()) {
					new RankFrame(loader.getInfo().gethmRank(), loader.getInfo().getarrRName());
				} else {
					System.out.println("sav�� ���⶧���� �ε����� �ʽ��ϴ�.");
					JOptionPane.showMessageDialog(
							loadFrame, "sav�� ���⶧���� �ε����� �ʽ��ϴ�.");
				}
			}
		});

		// '������' ������ �� ����
		l_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		loadFrame.setVisible(true);
		loadFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
	}

}
