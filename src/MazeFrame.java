
public class MazeFrame extends MyFrame {
	//GameFrameの代わり
	public void run() {
		for (int i = 0; i < 17; i++) {
				MazeWorld.outerwall = new Outerwall(50, 60 + 20 * (i - 1), 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);
			
		}
		for(int i = 0; i<16;i++) {
				MazeWorld.outerwall = new Outerwall(70 + 20 * i, 360, 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);
			}
		for(int i = 0; i<16;i++) {
				MazeWorld.outerwall = new Outerwall(370, 360-20 * i, 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);
			}
		for(int i = 0; i<16;i++) {
				MazeWorld.outerwall = new Outerwall(370-20 * i, 40, 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);
			}
		}
	}

