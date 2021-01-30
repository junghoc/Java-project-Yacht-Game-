package ranking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RankFrame {

	private Frame rFrame = null;
	private Font nFont = null;//북쪽 랭킹 폰트
	private Font font = null;//기본 폰트
	
	private ImageIcon imgRank = null;//이미지
	
	private JPanel pNorth = null;//북쪽 판넬
	private JLabel rLabel = null;//북쪽 라벨글
	//-----------------------------------------------------------------------------
	private JPanel pCenter = null;//가운데 판넬
	
	private JPanel pCenter0 = null;//0줄
	private JLabel[] zero = null;
	
	private JPanel pCenter1 = null;//1줄
	private JLabel[] fir = null;
	
	private JPanel pCenter2 = null;//2줄
	private JLabel[] sec = null;
	
	private JPanel pCenter3 = null;//3줄
	private JLabel[] thi = null;
	
	private JPanel pCenter4 = null;//4줄
	private JLabel[] four = null;
	
	private JPanel pCenter5 = null;//5줄
	private JLabel[] fif = null;
	
	private JPanel pCenter6 = null;//6줄
	private JLabel[] six = null;
	
	private JPanel pCenter7 = null;//7줄
	private JLabel[] sev = null;
	
	private JPanel pCenter8 = null;//8줄
	private JLabel[] eig = null;
	
	private JPanel pCenter9 = null;//9줄
	private JLabel[] nin = null;
	
	private JPanel pCenter10 = null;//10줄
	private JLabel[] ten = null;
	
	//-----------------------------------------------------------------------------
	private JPanel pSouth = null;//남쪽 판넬
	private JTextField tfName = null;//남쪽 판넬 이름입력
	private JLabel sRank = null;//남쪽 라벨순위
	private JLabel sWin = null;//남쪽 라벨 승
	private JLabel sLose = null;//남쪽 라벨 패
	private JLabel sMax = null;//남쪽 라벨 최고점수
	private int cts;
	
	public RankFrame( HashMap<String, int[]> hm, ArrayList<String> arrRName ) {
		
		rFrame = new Frame("Rank");
		rFrame.setBounds(300, 300, 800, 500);
		rFrame.setResizable(false);
		
		//북쪽단-------------------------------------------------------
		
		pNorth = new JPanel();
		rLabel = new JLabel("R  A  N  K");
		nFont = new Font("궁서체", Font.BOLD, 30);
		pNorth.setBackground(Color.white);
		
		//사진 첨부
		imgRank = new ImageIcon("랭킹.png");
		JLabel jlRank1 = new JLabel(imgRank);
		JLabel jlRank2 = new JLabel(imgRank);
		
		pNorth.add( jlRank1 );
		pNorth.add( rLabel );
		pNorth.add( jlRank2 );
		rLabel.setFont( nFont );
		
		rFrame.add(pNorth, BorderLayout.NORTH);
		
		//-----------------------------------------------------------
		
		//중앙단-------------------------------------------------------
		
		pCenter = new JPanel( new GridLayout(11, 0) );
		font = new Font("궁서체", Font.PLAIN, 20);
		
		//0번째 줄
		pCenter0 = new JPanel( new GridLayout(1, 0) );
		pCenter0.setBackground(Color.YELLOW);
		zero = new JLabel[5];
		for (int i = 0; i < zero.length; i++) {
			zero[i] = new JLabel();
		}//for
		//이름 저장
		zero[0].setText("RANK");
		zero[1].setText("NAME");
		zero[2].setText("WIN");
		zero[3].setText("LOSE");
		zero[4].setText("MAX SCORE");
		//0번째 줄에 저장
		for (int i = 0; i < zero.length; i++) {
			zero[i].setFont(font);
			zero[i].setHorizontalAlignment(JLabel.CENTER);
			zero[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter0.add(zero[i]);
		}//for
		
		
		//1번째줄
		pCenter1 = new JPanel( new GridLayout(1, 0) );
		pCenter1.setBackground(Color.white);
		fir = new JLabel[5];
		for (int i = 0; i < zero.length; i++) {
			fir[i] = new JLabel();
		}//for
		//이름 저장
		fir[0].setText("1");
		if(arrRName.size() > 0) {
			fir[1].setText(arrRName.get(0));
			fir[2].setText( String.valueOf(hm.get(arrRName.get(0))[0]) );
			fir[3].setText( String.valueOf(hm.get(arrRName.get(0))[1]) );
			fir[4].setText( String.valueOf(hm.get(arrRName.get(0))[2]) );
		}else {
			fir[1].setText("-");
			fir[2].setText("-");
			fir[3].setText("-");
			fir[4].setText("-");
			
		}
		//1번째 줄에 저장
		for (int i = 0; i < fir.length; i++) {
			fir[i].setFont(font);
			fir[i].setHorizontalAlignment(JLabel.CENTER);
			fir[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter1.add(fir[i]);
		}//for
		
		//2번째줄
		pCenter2 = new JPanel( new GridLayout(1, 0) );
		pCenter2.setBackground(Color.white);
		sec = new JLabel[5];
		for (int i = 0; i < sec.length; i++) {
			sec[i] = new JLabel();
		}//for
		//이름 저장
		sec[0].setText("2");
		if(arrRName.size() > 1) {
			sec[1].setText(arrRName.get(1));
			sec[2].setText( String.valueOf(hm.get(arrRName.get(1))[0]) );
			sec[3].setText( String.valueOf(hm.get(arrRName.get(1))[1]) );
			sec[4].setText( String.valueOf(hm.get(arrRName.get(1))[2]) );
		}else {
			sec[1].setText("-");
			sec[2].setText("-");
			sec[3].setText("-");
			sec[4].setText("-");
		}
		//2번째 줄에 저장
		for (int i = 0; i < sec.length; i++) {
			sec[i].setFont(font);
			sec[i].setHorizontalAlignment(JLabel.CENTER);
			sec[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter2.add(sec[i]);
		}//for
		
		//3번째줄
		pCenter3 = new JPanel( new GridLayout(1, 0) );
		pCenter3.setBackground(Color.white);
		thi = new JLabel[5];
		for (int i = 0; i < thi.length; i++) {
			thi[i] = new JLabel();
		}//for
		//이름 저장
		thi[0].setText("3");
		if(arrRName.size() > 2) {
			thi[1].setText(arrRName.get(2));
			thi[2].setText( String.valueOf(hm.get(arrRName.get(2))[0]) );
			thi[3].setText( String.valueOf(hm.get(arrRName.get(2))[1]) );
			thi[4].setText( String.valueOf(hm.get(arrRName.get(2))[2]) );
		}else {
			thi[1].setText("-");
			thi[2].setText("-");
			thi[3].setText("-");
			thi[4].setText("-");
		}
		//3번째 줄에 저장
		for (int i = 0; i < thi.length; i++) {
			thi[i].setFont(font);
			thi[i].setHorizontalAlignment(JLabel.CENTER);
			thi[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter3.add(thi[i]);
		}//for
		
		//4번째줄
		pCenter4 = new JPanel( new GridLayout(1, 0) );
		pCenter4.setBackground(Color.white);
		four = new JLabel[5];
		for (int i = 0; i < four.length; i++) {
			four[i] = new JLabel();
		}//for
		//이름 저장
		four[0].setText("4");
		if(arrRName.size() > 3) {
			four[1].setText(arrRName.get(3));
			four[2].setText( String.valueOf(hm.get(arrRName.get(3))[0]) );
			four[3].setText( String.valueOf(hm.get(arrRName.get(3))[1]) );
			four[4].setText( String.valueOf(hm.get(arrRName.get(3))[2]) );
		}else {
			four[1].setText("-");
			four[2].setText("-");
			four[3].setText("-");
			four[4].setText("-");
		}
		//4번째 줄에 저장
		for (int i = 0; i < four.length; i++) {
			four[i].setFont(font);
			four[i].setHorizontalAlignment(JLabel.CENTER);
			four[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter4.add(four[i]);
		}//for
		
		//5번째줄
		pCenter5 = new JPanel( new GridLayout(1, 0) );
		pCenter5.setBackground(Color.white);
		fif = new JLabel[5];
		for (int i = 0; i < fif.length; i++) {
			fif[i] = new JLabel();
		}//for
		//이름 저장
		fif[0].setText("5");
		if(arrRName.size() > 4) {
			fif[1].setText(arrRName.get(4));
			fif[2].setText( String.valueOf(hm.get(arrRName.get(4))[0]) );
			fif[3].setText( String.valueOf(hm.get(arrRName.get(4))[1]) );
			fif[4].setText( String.valueOf(hm.get(arrRName.get(4))[2]) );
		}else {
			fif[1].setText("-");
			fif[2].setText("-");
			fif[3].setText("-");
			fif[4].setText("-");
		}
		//5번째 줄에 저장
		for (int i = 0; i < fif.length; i++) {
			fif[i].setFont(font);
			fif[i].setHorizontalAlignment(JLabel.CENTER);
			fif[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter5.add(fif[i]);
		}//for
		
		//6번째줄
		pCenter6 = new JPanel( new GridLayout(1, 0) );
		pCenter6.setBackground(Color.white);
		six = new JLabel[5];
		for (int i = 0; i < six.length; i++) {
			six[i] = new JLabel();
		}//for
		//이름 저장
		six[0].setText("6");
		if(arrRName.size() > 5) {
			six[1].setText(arrRName.get(5));
			six[2].setText( String.valueOf(hm.get(arrRName.get(5))[0]) );
			six[3].setText( String.valueOf(hm.get(arrRName.get(5))[1]) );
			six[4].setText( String.valueOf(hm.get(arrRName.get(5))[2]) );
		}else {
			six[1].setText("-");
			six[2].setText("-");
			six[3].setText("-");
			six[4].setText("-");
		}
		//6번째 줄에 저장
		for (int i = 0; i < six.length; i++) {
			six[i].setFont(font);
			six[i].setHorizontalAlignment(JLabel.CENTER);
			six[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter6.add(six[i]);
		}//for
		
		//7번째줄
		pCenter7 = new JPanel( new GridLayout(1, 0) );
		pCenter7.setBackground(Color.white);
		sev = new JLabel[5];
		for (int i = 0; i < sev.length; i++) {
			sev[i] = new JLabel();
		}//for
		//이름 저장
		sev[0].setText("7");
		if(arrRName.size() > 6) {
			sev[1].setText(arrRName.get(6));
			sev[2].setText( String.valueOf(hm.get(arrRName.get(6))[0]) );
			sev[3].setText( String.valueOf(hm.get(arrRName.get(6))[1]) );
			sev[4].setText( String.valueOf(hm.get(arrRName.get(6))[2]) );
		}else {
			sev[1].setText("-");
			sev[2].setText("-");
			sev[3].setText("-");
			sev[4].setText("-");
		}
		//7번째 줄에 저장
		for (int i = 0; i < sev.length; i++) {
			sev[i].setFont(font);
			sev[i].setHorizontalAlignment(JLabel.CENTER);
			sev[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter7.add(sev[i]);
		}//for
		
		//8번째줄
		pCenter8 = new JPanel( new GridLayout(1, 0) );
		pCenter8.setBackground(Color.white);
		eig = new JLabel[5];
		for (int i = 0; i < eig.length; i++) {
			eig[i] = new JLabel();
		}//for
		//이름 저장
		eig[0].setText("8");
		if(arrRName.size() > 7) {
			eig[1].setText(arrRName.get(7));
			eig[2].setText( String.valueOf(hm.get(arrRName.get(7))[0]) );
			eig[3].setText( String.valueOf(hm.get(arrRName.get(7))[1]) );
			eig[4].setText( String.valueOf(hm.get(arrRName.get(7))[2]) );
		}else {
			eig[1].setText("-");
			eig[2].setText("-");
			eig[3].setText("-");
			eig[4].setText("-");
		}
		
		//8번째 줄에 저장
		for (int i = 0; i < eig.length; i++) {
			eig[i].setFont(font);
			eig[i].setHorizontalAlignment(JLabel.CENTER);
			eig[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter8.add(eig[i]);
		}//for
		
		//9번째줄
		pCenter9 = new JPanel( new GridLayout(1, 0) );
		pCenter9.setBackground(Color.white);
		nin = new JLabel[5];
		for (int i = 0; i < nin.length; i++) {
			nin[i] = new JLabel();
		}//for
		//이름 저장
		nin[0].setText("9");
		if(arrRName.size() > 8) {
			nin[1].setText(arrRName.get(8));
			nin[2].setText( String.valueOf(hm.get(arrRName.get(8))[0]) );
			nin[3].setText( String.valueOf(hm.get(arrRName.get(8))[1]) );
			nin[4].setText( String.valueOf(hm.get(arrRName.get(8))[2]) );
		}else {
			nin[1].setText("-");
			nin[2].setText("-");
			nin[3].setText("-");
			nin[4].setText("-");
		}
		//9번째 줄에 저장
		for (int i = 0; i < nin.length; i++) {
			nin[i].setFont(font);
			nin[i].setHorizontalAlignment(JLabel.CENTER);
			nin[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter9.add(nin[i]);
		}//for
		
		//10번째줄
		pCenter10 = new JPanel( new GridLayout(1, 0) );
		pCenter10.setBackground(Color.white);
		ten = new JLabel[5];
		for (int i = 0; i < ten.length; i++) {
			ten[i] = new JLabel();
		}//for
		//이름 저장
		ten[0].setText("10");
		if(arrRName.size() > 9) {
			ten[1].setText(arrRName.get(9));
			ten[2].setText( String.valueOf(hm.get(arrRName.get(9))[0]) );
			ten[3].setText( String.valueOf(hm.get(arrRName.get(9))[1]) );
			ten[4].setText( String.valueOf(hm.get(arrRName.get(9))[2]) );
		}else {
			ten[1].setText("-");
			ten[2].setText("-");
			ten[3].setText("-");
			ten[4].setText("-");
		}
		//10번째 줄에 저장
		for (int i = 0; i < ten.length; i++) {
			ten[i].setFont(font);
			ten[i].setHorizontalAlignment(JLabel.CENTER);
			ten[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			pCenter10.add(ten[i]);
		}//for
		
		//rframe에 저장
		pCenter.add(pCenter0);
		pCenter.add(pCenter1);
		pCenter.add(pCenter2);
		pCenter.add(pCenter3);
		pCenter.add(pCenter4);
		pCenter.add(pCenter5);
		pCenter.add(pCenter6);
		pCenter.add(pCenter7);
		pCenter.add(pCenter8);
		pCenter.add(pCenter9);
		pCenter.add(pCenter10);
		
		rFrame.add(pCenter, BorderLayout.CENTER);
		
		//-----------------------------------------------------------
		
		//남쪽단-------------------------------------------------------
		
		//아이디 검색후 순위
		pSouth = new JPanel( new GridLayout(1, 0));
		pSouth.setBackground(Color.white);
		
		//아이디 검색
		tfName = new JTextField(10);
		tfName.setFont(font);
		tfName.setHorizontalAlignment(JLabel.CENTER);
		
		//기본틀
		sRank = new JLabel("-");//순위
		sWin = new JLabel("-");//승
		sLose = new JLabel("-");//패
		sMax = new JLabel("-");//최고점수

		//tfName에 아이디를 입력후 엔터치면 순위 및 승패 확인
		tfName.addKeyListener( new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//tfName가 엔터키를 입력 받았을 때
				if( e.getKeyChar() == KeyEvent.VK_ENTER ) {
					cts = 0;//방 번호를 알기위한 변수
					for( cts = 0; cts < arrRName.size(); cts++ ) {
						if( tfName.getText().trim().equals(arrRName.get(cts)) ) {
							//아이디가 존재
							sRank.setText( String.valueOf(cts + 1) );//순위
							sWin.setText( String.valueOf(hm.get(arrRName.get(cts))[0]) );//승
							sLose.setText( String.valueOf(hm.get(arrRName.get(cts))[1]) );//패
							sMax.setText( String.valueOf(hm.get(arrRName.get(cts))[2]) );//최고점수
							break;
						}//if_inner
						
					}//for
					
				}//if_outer
			}
		});
		
		//순위
		sRank.setFont(font);
		sRank.setHorizontalAlignment(JLabel.CENTER);
		
		//승
		sWin.setFont(font);
		sWin.setHorizontalAlignment(JLabel.CENTER);
		
		//패
		sLose.setFont(font);
		sLose.setHorizontalAlignment(JLabel.CENTER);
		
		//max점수
		sMax.setFont(font);
		sMax.setHorizontalAlignment(JLabel.CENTER);
		
		//테두리
		sRank.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		tfName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		sWin.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		sLose.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		sMax.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		pSouth.add(sRank);
		pSouth.add(tfName);
		pSouth.add(sWin);
		pSouth.add(sLose);
		pSouth.add(sMax);
		
		rFrame.add(pSouth, BorderLayout.SOUTH);
		
		//-----------------------------------------------------------
		
		rFrame.setVisible( true );
		rFrame.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				rFrame.dispose();
			}
		});
		
	}
	
	
	
}
