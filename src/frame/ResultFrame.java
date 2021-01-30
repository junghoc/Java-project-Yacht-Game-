package frame;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResultFrame {
	Frame resultFrame = null;
	Button exitButton = null;
	Label p1Label = null;
	Label p1subLabel = null;
	Label p2Label = null;
	Label p2subLabel = null;
	Label resultLabel = null;

	public String player1 = "";
	public String player2 = "";
	public int p1Score = 0;
	public int p2Score = 0;

	public ResultFrame(String player1, String player2, int p1Score, int p2Score) {

		this.player1 = player1;
		this.player2 = player2;
		this.p1Score = p1Score;
		this.p2Score = p2Score;

		resultFrame = new Frame("°á°ú");
		resultFrame.setBounds(200, 200, 500, 300);
		resultFrame.setResizable(false);
		resultFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				resultFrame.dispose();
			}
		});
		resultFrame.setLayout(null);
		p1Label = new Label(player1);
		p2Label = new Label(player2);
		p1Label.setBounds(20, 80, 130, 40);
		p2Label.setBounds(20, 120, 130, 40);
		p1subLabel = new Label(": " + p1Score + "Á¡");
		p2subLabel = new Label(": " + p2Score + "Á¡");
		p1subLabel.setBounds(160, 80, 100, 40);
		p2subLabel.setBounds(160, 120, 100, 40);

		resultLabel = new Label();
		if (p1Score > p2Score) {
			resultLabel.setText(player1 + "ÀÇ ½Â¸®!");
		} else if (p1Score < p2Score) {
			resultLabel.setText(player2 + "ÀÇ ½Â¸®!");
		} else {
			resultLabel.setText("¹«½ÂºÎ !!");
		}
		resultLabel.setBounds(20, 160, 200, 40);
		resultFrame.add(resultLabel);

		resultFrame.add(p1Label);
		resultFrame.add(p2Label);
		resultFrame.add(p1subLabel);
		resultFrame.add(p2subLabel);

		exitButton = new Button("Á¾·á");
		exitButton.setBounds(380, 240, 100, 40);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		resultFrame.add(exitButton);
		resultFrame.setVisible(true);

	}

}
