import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MazeFrame extends MyFrame {
	//GameFrameの代わり
	public void run() {


		
		Restart re = new Restart();

		int[][] kabe;
		kabe = new int[17][17];


		for (int i = 0; i < 4; i++) {
			for (int n = 0; n < 17; n++) {
				if (i == 0) { //leftouter
					kabe[n][0] = 2;
				} else if (i == 1) { //downouter
					kabe[16][n] = 2;
				} else if (i == 2) { //rightouter
					kabe[n][16] = 2;
				} else { //upouter
					kabe[0][n] = 2;
				}
			}

			for (int n = 0; n < 17; n++) {
				for (int m = 0; m < 17; m++) {
					if (kabe[n][m] == 2) {
						int xx = n * 20 + 50;
						int yy = m * 20 + 40;
						MazeWorld.outerwall = new Outerwall(xx, yy, 20, 20);
						MazeWorld.outerwall.draw(this);
					}
				}
			}
		}

		//柱生成

		for (int i = 2; i < 17; i += 2) { 
			for (int j = 2; j < 17; j += 2) {
				kabe[i][j] = 1;
			}
		}
		for (int n = 0; n < 17; n++) {

			for (int m = 0; m < 17; m++) {

				if (kabe[n][m] == 1) {
					int xx = n * 20 + 50;
					int yy = m * 20 + 40;
					MazeWorld.outerwall = new Outerwall(xx, yy, 20, 20);
					MazeWorld.outerwall.draw(this);
					sleep(0.01);
				}

			}

		}


       //迷路生成

		for (int i = 2; i < 15; i += 2) {
			for (int j = 2; j < 15; j += 2) {
				Random houkou = new Random();
				int muki = houkou.nextInt(4);

				//１行目の場合
				if (i == 1) {
					if (muki == 0) { //up
						kabe[i - 1][j] = 1;
					} else if (muki == 1) { //down
						if (kabe[i + 1][j] != 1) {
							kabe[i + 1][j] = 1;
						} else {
							j -= 2;
						}
					} else if (muki == 2) { //left
						if (kabe[i][j - 1] != 1) {
							kabe[i][j - 1] = 1;
						} else {
							j -= 2;
						}
					} else { //right
						if (kabe[i][j + 1] != 1) {
							kabe[i][j + 1] = 1;
						} else {
							j -= 2;
						}
					}
				}
				//２行目以降		
				else {

					if (muki == 1) { //down
						if (kabe[i + 1][j] != 1) {
							kabe[i + 1][j] = 1;
						} else {
							j -= 2;
						}
					} else if (muki == 2) { //left
						if (kabe[i][j - 1] != 1) {
							kabe[i][j - 1] = 1;
						} else {
							j -= 2;
						}
					} else { //right
						if (kabe[i][j + 1] != 1) {
							kabe[i][j + 1] = 1;
						} else {
							j -= 2;
						}
					}
				}
			}
			

			//描写する処理

			for (int n = 0; n < 17; n++) {
				for (int m = 0; m < 17; m++) {
					if (kabe[n][m] == 1) {
						int xx = n * 20 + 50;
						int yy = m * 20 + 40;
						MazeWorld.outerwall = new Outerwall(xx, yy, 20, 20);
						MazeWorld.outerwall.draw(this);
						sleep(0.01);
					}
				}
			}
		}

		MakeSG();

		addKeyListener(re);
				
	}

	

	
	
	public void MakeSG() {
		MazeWorld.goal = new Goal(350, 340, 20, 20);
		MazeWorld.goal.draw(this);

		MazeWorld.start = new Start(70, 60, 20, 20);
		MazeWorld.start.draw(this);
	}

	
	
	
	
	
	public class Restart implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				clear();
				run();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ

		}
	}

}
