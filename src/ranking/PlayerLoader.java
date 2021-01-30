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

		if (f.exists()) { // 물리적으로 파일이 존재할때 true
			loadOk = true;
			try {
				fis = new FileInputStream(path);
				ois = new ObjectInputStream(fis);
				info = (Player)ois.readObject();
				
				System.out.println("로드완료");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("로드실패");
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
			System.out.println("YachtPlayers.sav가 없습니다 // 아직 한번도 플레이 하지 않았습니다 ");
		}
	}

}
