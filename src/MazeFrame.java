import java.util.Random;

public class MazeFrame extends MyFrame {
	//GameFrameの代わり
	public void run() {
		
		    
		for (int i = 0; i <=64; i++) {
			if(i < 17) {
				MazeWorld.outerwall = new Outerwall(50, 60 + 20 * (i - 1), 20, 20);
				MazeWorld.outerwall.draw(this);
				//sleep(0.1);
				}
			else if(i<33) {
				MazeWorld.outerwall = new Outerwall(70 + 20 * (i-17), 360, 20, 20);
				MazeWorld.outerwall.draw(this);
				//sleep(0.1);
			}
			else if(i<50) {
				MazeWorld.outerwall = new Outerwall(370, 360-20 * (i-33), 20, 20);
				MazeWorld.outerwall.draw(this);
				//sleep(0.1);
			}
			else {
				MazeWorld.outerwall = new Outerwall(370-20 * (i-49), 40, 20, 20);
				MazeWorld.outerwall.draw(this);
				//sleep(0.1);
			}
			
		}
		
		int[][] kabe;
		kabe = new int[15][15];
		
		
		for(int i=0; i<15; i++) {     //初期化
			for(int j=0; j<15; j++) {
			    kabe[i][j]=0;
			}
		}
		
		for(int i = 1; i<15;i+=2) {      //柱生成
			for(int j= 1; j<15; j+=2) {
				kabe[i][j] = 1;
			}
		}
		for(int n = 0;n<15;n++) {
	    	 for(int m= 0;m<15;m++) {
	    		 if(kabe[n][m] == 1) {
	    			 int xx = n*20+70;
	    			 int yy = m*20+60;
	    			 MazeWorld.outerwall = new Outerwall(xx,yy, 20, 20);
	 				MazeWorld.outerwall.draw(this);
	 				sleep(0.01);
	    		 }
	    	 }
	     }
		
		
		for(int i = 1; i<15; i+=2) {
			for(int j = 1;j<15;j+=2) {
				Random houkou = new Random();
				int muki = houkou.nextInt(4);
			if(i == 1) {               //１行目の場合
				if(muki == 0) {        //up
					kabe[i-1][j] = 1;
				}
				else if(muki == 1) {   //down
					if(kabe[i+1][j] != 1) {
						kabe[i+1][j] = 1;
					}
					else {
						j-=2;
					}
				}
				else if(muki == 2) {   //left
					if(kabe[i][j-1]!= 1) {
						kabe[i][j-1] = 1;
					}
					else {
						j-=2;
					}
				}
				else {                 //right
					if(kabe[i][j+1]!=1) {
						kabe[i][j+1] = 1;
					}
					else {
						j-=2;
					}
				}
			 }
				else {                //２行目以降

					if(muki == 1) {   //down
						if(kabe[i+1][j] != 1) {
							kabe[i+1][j] = 1;
						}
						else {
							j-=2;
						}
					}
					else if(muki == 2) {   //left
						if(kabe[i][j-1] != 1) {
							kabe[i][j-1] = 1;
						}
						else {
							j-=2;
						}
					}
					else {                 //right
						if(kabe[i][j+1] !=1) {
							kabe[i][j+1] = 1;
						}
						else {
							j-=2;
						}
					}
				}
			}
		//}
		
			
				
				
		
		
		

		//ランダムでひたすら壁を生成するコード（１）
		//while(true) {
			//if(kabe[x][y] == 0) {
				//if(kabe[x+1][y]==0&&kabe[x+2][y]==0&&kabe[x-1][y]==0&&)
				//kabe[x][y] = 1;
				//break;
			//}
			//else {
				//x = rand.nextInt(15);
				//y = rand.nextInt(15);
			//}
		//}
		
		//（１）ここまで
		
		//最後に全部描写する処理
			
	     for(int n = 0;n<15;n++) {
	    	 for(int m= 0;m<15;m++) {
	    		 if(kabe[n][m] == 1) {
	    			 int xx = n*20+70;
	    			 int yy = m*20+60;
	    			 MazeWorld.outerwall = new Outerwall(xx,yy, 20, 20);
	 				MazeWorld.outerwall.draw(this);
	 				sleep(0.01);
	    		 }
	    	 }
	     }
		}
	
}
}

