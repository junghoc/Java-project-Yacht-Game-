package ranking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PlayerWriter {
	// PlayerInfo�� ����

	public PlayerWriter(Player info){
		String path = "C:\\Download\\YachtPlayers.sav";
		
		File dir1 = new File("C:\\Download");
		if (!dir1.exists()) {
			dir1.mkdirs();
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			//���Ͼ���
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			//info��ü�� Gamesave.sav���Ϸ� ���
			oos.writeObject(info);
			
		} catch (Exception e) {
			System.out.println("������� ����");
			e.printStackTrace();
			
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// try-catch-finally
		
	}
}
