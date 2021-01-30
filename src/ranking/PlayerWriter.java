package ranking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PlayerWriter {
	// PlayerInfo를 저장

	public PlayerWriter(Player info){
		String path = "C:\\Download\\YachtPlayers.sav";
		
		File dir1 = new File("C:\\Download");
		if (!dir1.exists()) {
			dir1.mkdirs();
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			//파일쓰기
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			//info객체를 Gamesave.sav파일로 기록
			oos.writeObject(info);
			
		} catch (Exception e) {
			System.out.println("기록저장 실패");
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
