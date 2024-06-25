
public class Outerwall extends Wall{

	public Outerwall(int x, int y, int vx, int vy) {
		super(x, y, vx, vy);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	//外壁
	public void draw(MyFrame f) {
		f.setColor(0, 128, 128);
		f.fillRect(x, y, 20, 20);
		f.setColor(0, 180, 180);
		f.fillRect(x+5,y+5,10,10);
		f.setColor(0, 155, 155);
		f.fillRect(x, y, 5, 20);
		f.setColor(0, 170, 170);
		f.fillRect(x, y, 20, 5);
	}
}


