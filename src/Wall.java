
public class Wall {
	//Characterの代わり
	int x,y,vx,vy;
	public Wall(int x, int y, int vx, int vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
//外壁
	public void draw(MyFrame f) {
	f.fillRect(x,y,20,20);
	}
}
