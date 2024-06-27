import java.util.Random;

public class MazeFrame extends MyFrame {
	//GameFrameの代わり
	public void run() {
		
		int[][] kabe;
		kabe = new int[15][15];
		
		
		for(int i=0; i<15; i++) {     //初期化
			for(int j=0; j<15; j++) {
			    kabe[i][j]=0;
			}
		}
		
		for(int n =0; n<225; n++) {  //試すときよう
		
		Random rand = new Random();
		int x = rand.nextInt(15);    //0～14の間でランダム
		int y = rand.nextInt(15);
		
		while(true) {
			if(kabe[x][y] == 0) {
				kabe[x][y] = 1;
				break;
			}
			else {
				x = rand.nextInt(15);
				y = rand.nextInt(15);
			}
		}
		
	     for(int i = 0;i<15;i++) {
	    	 for(int j= 0;j<15;j++) {
	    		 if(kabe[i][j] == 1) {
	    			 int xx = i*20+70;
	    			 int yy = j*20+60;
	    			 MazeWorld.outerwall = new Outerwall(xx,yy, 20, 20);
	 				MazeWorld.outerwall.draw(this);
	 				sleep(0.3);
	    		 }
	    	 }
	     }
		}
		//int start = rand.nextInt(3); //どの壁から生成始める？
		//if(start == 0) {        //左
			//int one = rand.nextInt(240)+100;
			//while(one % 20 !=0) {
				//one++;
				//if(one>360) {
					//one =100;
				//}
			//}
			//MazeWorld.outerwall = new Outerwall(70, one, 20, 20);
			//MazeWorld.outerwall.draw(this);
			//System.out.println(one);
		//}
		//System.out.println (start);
		
	    //int yoko = rand.nextInt(350) + 70;  //横の生成範囲
	    //int tate = rand.nextInt(360) + 80;  //縦の生成範囲
	    
		for (int i = 0; i <=64; i++) {
			if(i < 17) {
				MazeWorld.outerwall = new Outerwall(50, 60 + 20 * (i - 1), 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);}
			else if(i<33) {
				MazeWorld.outerwall = new Outerwall(70 + 20 * (i-17), 360, 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);
			}
			else if(i<50) {
				MazeWorld.outerwall = new Outerwall(370, 360-20 * (i-33), 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);
			}
			else {
				MazeWorld.outerwall = new Outerwall(370-20 * (i-49), 40, 20, 20);
				MazeWorld.outerwall.draw(this);
				sleep(0.1);
			}
			
		}
	}
	}

