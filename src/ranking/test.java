package ranking;


public class test {
	public static void main(String[] args) {
		PlayerLoader p = new PlayerLoader();
		
		p.getInfo().saveplayer("asd", "Tear", 200, 102);
		
		System.out.println("�����");
		
		new PlayerWriter(p.getInfo());
		
		System.out.println("�ۼ���");
	}
}
