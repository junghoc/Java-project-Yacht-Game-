package ranking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PlayerLoader {
	private Player info ;
	boolean loadOk = false;
	
	public boolean getloadOk() {
		return loadOk;
	}
	
	public Player getInfo() {
		return info;
	}
	
	public PlayerLoader() {
		String path = "C:\\Download\\YachtPlayers.sav";
		
		File f = new File(path);
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		if (f.exists()) { // ���������� ������ �����Ҷ� true
			loadOk = true;
			try {
				fis = new FileInputStream(path);
				ois = new ObjectInputStream(fis);
				info = (Player)ois.readObject();
				
				System.out.println("�ε�Ϸ�");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�ε����");
			} finally {
				try {
					ois.close();
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			loadOk = false;
			System.out.println("YachtPlayers.sav�� �����ϴ� // ���� �ѹ��� �÷��� ���� �ʾҽ��ϴ� ");
		}
	}

}
