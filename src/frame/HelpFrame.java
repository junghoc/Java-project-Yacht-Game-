package frame;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HelpFrame {

	private Frame hFrame = null;
	private ImageIcon img1 = null;
	private ImageIcon img2 = null;
	private JLabel jl = null;
	private JButton next = null;
	private JButton pre = null;
	private Panel pSouth = null;

	// 생성자
	public HelpFrame() {

		hFrame = new Frame("도움말");
		hFrame.setBounds(300, 500, 510, 484);
		hFrame.setResizable(false);

		// 남쪽단------------------------------------------------------

		pSouth = new Panel();

		next = new JButton(new ImageIcon("next.png"));
		pre = new JButton(new ImageIcon("back.png"));

		pSouth.add(pre);
		pSouth.add(next);

		// ----------------------------------------------------------

		// 중앙단------------------------------------------------------

		img1 = new ImageIcon("도움말1.jpg");
		img2 = new ImageIcon("도움말2.jpg");
		jl = new JLabel(img1);

		// ----------------------------------------------------------

		// 버튼 클릭시 화면 변경
		next.setEnabled(true);
		pre.setEnabled(false);

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jl.setIcon(img2);
				next.setEnabled(false);
				pre.setEnabled(true);

			}

		});

		pre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jl.setIcon(img1);
				next.setEnabled(true);
				pre.setEnabled(false);

			}
		});

		hFrame.add(jl, BorderLayout.CENTER);
		hFrame.add(pSouth, BorderLayout.SOUTH);

		hFrame.setVisible(true);
		hFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				hFrame.dispose();
			}
		});
	}
}