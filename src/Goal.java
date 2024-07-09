
public class Goal extends Wall{

	public Goal(int x, int y, int vx, int vy) {
		super(x, y, vx, vy);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void draw(MyFrame f) {
		f.setColor(255, 0, 0);
		f.fillRect(x, y, 20, 20);
	}
}
